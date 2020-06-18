package cn.tjrac.sytstem.service;

import cn.tjrac.sytstem.vo.DepartVo;
import cn.tjrac.sytstem.vo.NotifionVo;
import cn.tjrac.sytstem.vo.OutLayVo;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/4/14 17:44
 */
public interface OutLayService {

    int addOutLay(List<OutLayVo> outlist);//出库记录

    int insertNotifion(NotifionVo notifionVo);//生成费用通知表

    int insertStatement(List<NotifionVo> statementVos);//填写费用核算单

    List<OutLayVo> selectOutLay();//查询出库记录

    int upRepertory(String bookNumber,int repertoryQuantity);//修改数量

    int takeLogic(List<OutLayVo> outlist); //减库存加出库记录

    DepartVo selectDepartment(String department);//查系别

    List<NotifionVo> selectNotifion();//查询费用通知单

    List<NotifionVo> selectStatment();//查询费用核算单

}
