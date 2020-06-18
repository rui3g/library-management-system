package cn.tjrac.sytstem.service;

import cn.tjrac.sytstem.vo.EnterHouseVo;
import cn.tjrac.sytstem.vo.OrderVo;
import cn.tjrac.sytstem.vo.RepertoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

/**
 * @author Rui3g
 * @date 2020/3/31 17:05
 */
public interface ListOrderService {

    //查询预定表
    OrderVo selectListOrder(String bookNumber,String profession,String grade);

    //订单核对
    int orderCheck(String order);

    //入库
    int insertListOrder(EnterHouseVo enterHouseVo);

    //入库操作
    int enterHouse(String order);

    //查询入库记录表
    List<EnterHouseVo> selectEnterHouse();

    //插入库存表
    int insertRepertory(EnterHouseVo enterHouseVo);

    //查询库存表
    List<RepertoryVo> selectRepertory();

    //查询预定表全部信息
    List<OrderVo> selectAllOrder();

    //导出excl
    int outExcel(String title, String[] headers, Collection<T> dataset, OutputStream out);

    //查单条书籍数据
    OrderVo selectOneOrder(String bookNumber);
}
