package cn.tjrac.sytstem.impl;

import cn.tjrac.sytstem.dao.ListOrderDao;
import cn.tjrac.sytstem.dao.OutLayDao;
import cn.tjrac.sytstem.service.OutLayService;
import cn.tjrac.sytstem.vo.DepartVo;
import cn.tjrac.sytstem.vo.NotifionVo;
import cn.tjrac.sytstem.vo.OrderVo;
import cn.tjrac.sytstem.vo.OutLayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/4/14 17:44
 */
@Service
@Transactional
public class OutLayServiceImpl implements OutLayService {

    @Autowired
    private OutLayDao outLayDao;

    @Autowired
    private ListOrderDao listOrderDao;

    @Override
    public int addOutLay(List<OutLayVo> outlist) {
        return outLayDao.addOutLay(outlist);
    }

    @Override
    public int insertNotifion(NotifionVo notifionVo) {
        return outLayDao.insertNotifion(notifionVo);
    }

    @Override
    public int insertStatement(List<NotifionVo> statementVos) {
        return outLayDao.insertStatement(statementVos);
    }

    @Override
    public List<OutLayVo> selectOutLay() {
        return outLayDao.selectOutLay();
    }

    @Override
    public int upRepertory(String bookNumber, int repertoryQuantity) {
        return outLayDao.upRepertory(bookNumber,repertoryQuantity);
    }


    @Override
    public DepartVo selectDepartment(String department) {
        return outLayDao.selectDepartment(department);
    }

    @Override
    public List<NotifionVo> selectNotifion() {
        return outLayDao.selectNotifion();
    }

    @Override
    public List<NotifionVo> selectStatment() {
        return outLayDao.selectStatment();
    }


    //出库,库存减少逻辑
    @Override
    public int takeLogic(List<OutLayVo> outlist) {
        int x = 0;
        int sumPrice = 0;
        String orderNumber = "";
        NotifionVo notifionVo =new NotifionVo();
        addOutLay(outlist);//出库记录
        for (int i =0;i<outlist.size();i++){
            x=upRepertory(outlist.get(i).getBookNumber(),outlist.get(i).getOutQuantity());//库存量修改
            OrderVo orderVo = listOrderDao.selectOneOrder(outlist.get(i).getBookNumber());//查预定表信息
            notifionVo.setBookNumber(outlist.get(i).getBookNumber());
            notifionVo.setBookName(outlist.get(i).getBookName());
            notifionVo.setBookPrice(orderVo.getBookPrice());
            DepartVo departVo = selectDepartment(orderVo.getDepartment());//查系别
            //System.out.println("====="+orderVo.getGrade());
            //System.out.println("======"+departVo.getDepartmentID());
            orderNumber = departVo.getDepartmentID()+orderVo.getGrade();//订单号
            System.out.println("====订单号====="+orderNumber);
            notifionVo.setOrderNumber(orderNumber);
            notifionVo.setQuantity(outlist.get(i).getOutQuantity());
            sumPrice = outlist.get(i).getOutQuantity()*orderVo.getBookPrice();//总价
            notifionVo.setSumPrice(sumPrice);
            insertNotifion(notifionVo);//生成通知单
            if (x==1){
                System.out.println("======出库成功===========");
            }else{
                System.out.println("=====库存里没有此书籍========");
            }
        }

        return x;
    }


}
