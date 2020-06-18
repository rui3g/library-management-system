package cn.tjrac.sytstem.impl;

import cn.tjrac.sytstem.dao.ListOrderDao;
import cn.tjrac.sytstem.service.ListOrderService;
import cn.tjrac.sytstem.util.ExportExcelUtil;
import cn.tjrac.sytstem.vo.*;
import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Rui3g
 * @date 2020/3/31 17:07
 */
@Service
@Transactional
public class ListOrderServiceImpl implements ListOrderService {

    @Autowired
    private ListOrderDao listOrderDao;

    //查询预定表信息
    @Override
    public OrderVo selectListOrder(String bookNumber,String profession,String grade) {
        return listOrderDao.selectListOrder(bookNumber,profession,grade);
    }

    //订单核对
    @Override
    public int orderCheck(String orderVoList) {
        ListOrderVo orderVos = JSON.parseObject(orderVoList,ListOrderVo.class);
        System.out.println("==== "+orderVoList.toString());
        String bookNumber = "";
        String profession = "";
        String grade = "";
        int teacherCount = 0;
        int studentQuantity = 0;
        int flag = 0;
        try {
            w:for (int i = 0;i<orderVos.getOrderVoList().size();i++){
                bookNumber = orderVos.getOrderVoList().get(i).get书号();
                profession = orderVos.getOrderVoList().get(i).get专业();
                grade = orderVos.getOrderVoList().get(i).get年级();
                teacherCount = orderVos.getOrderVoList().get(i).get教师用书数量();
                studentQuantity = orderVos.getOrderVoList().get(i).get学生用书数量();
                OrderVo orderVo = selectListOrder(bookNumber,profession,grade);
                if (orderVo.getStudentBookQuantity()==studentQuantity&&orderVo.getTeacherBookCount()==teacherCount){
                    System.out.println("=======信息正确========");
                    flag = 1;
                }else {
                    flag = 2;
                    break w;
                }
            }
        } catch (Exception e) {
            flag = 2;
        }
        return flag;
    }

    //入库记录
    @Override
    public int insertListOrder(EnterHouseVo enterHouseVo) {

        return listOrderDao.insertListOrder(enterHouseVo);
    }

    //入库操作
    @Override
    public int enterHouse(String enterHouseJsonVos) {
        System.out.println("========="+enterHouseJsonVos);
        ListEnerHouseVo orderVoList = JSON.parseObject(enterHouseJsonVos,ListEnerHouseVo.class);
        EnterHouseVo enterHouseVo = new EnterHouseVo();
        int enterQuantity = 0;
        int flag = 0;
        System.out.println("======="+orderVoList.getEnterHouseJsonVos().size());
        for (int i = 0;i<orderVoList.getEnterHouseJsonVos().size();i++) {
            enterHouseVo.setBookNumber(orderVoList.getEnterHouseJsonVos().get(i).getBookNumber());
            enterHouseVo.setBookName(orderVoList.getEnterHouseJsonVos().get(i).getBookName());
            enterHouseVo.setBookPrice(orderVoList.getEnterHouseJsonVos().get(i).getBookPrice());
            SimpleDateFormat unix_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            enterHouseVo.setDateTime(unix_time.format(new Date()));
            enterHouseVo.setDepartment(orderVoList.getEnterHouseJsonVos().get(i).getDepartment());
            enterQuantity = orderVoList.getEnterHouseJsonVos().get(i).getStudentBookQuantity() + orderVoList.getEnterHouseJsonVos().get(i).getTeacherBookCount();
            enterHouseVo.setEnterQuantity(enterQuantity);
            //入库
            insertRepertory(enterHouseVo);
            //入库记录
            flag = insertListOrder(enterHouseVo);
        }
        return flag;
    }

    //查询入库记录
    @Override
    public List<EnterHouseVo> selectEnterHouse() {
        return listOrderDao.selectEnterHouse();
    }

    //插入库存表
    @Override
    public int insertRepertory(EnterHouseVo enterHouseVo) {
        return listOrderDao.insertRepertory(enterHouseVo);
    }

    //查询库存
    @Override
    public List<RepertoryVo> selectRepertory() {
        return listOrderDao.selectRepertory();
    }

    //查询全部预定表
    @Override
    public List<OrderVo> selectAllOrder() {
        return listOrderDao.selectAllOrder();
    }

    @Override
    public int outExcel(String title, String[] headers, Collection<T> dataset, OutputStream out) {
        ExportExcelUtil exportExcelUtil = new ExportExcelUtil();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        exportExcelUtil.exportExcel2007(title,headers,dataset,out,pattern);
        return 1;
    }

    //查预定表单条数据
    @Override
    public OrderVo selectOneOrder(String bookNumber) {
        return listOrderDao.selectOneOrder(bookNumber);
    }
}
