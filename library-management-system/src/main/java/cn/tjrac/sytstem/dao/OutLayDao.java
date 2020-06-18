package cn.tjrac.sytstem.dao;

import cn.tjrac.sytstem.vo.DepartVo;
import cn.tjrac.sytstem.vo.NotifionVo;
import cn.tjrac.sytstem.vo.OutLayVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/4/14 17:43
 */
@Mapper
@Component
public interface OutLayDao {

    int addOutLay(List<OutLayVo> list);

    int insertNotifion(NotifionVo notifionVos);

    int insertStatement(List<NotifionVo> nlist);

    List<OutLayVo> selectOutLay();

    int upRepertory(@Param("bookNumber") String bookNumber,@Param("repertoryQuantity") int repertoryQuantity);

    DepartVo selectDepartment(String department);

    List<NotifionVo> selectNotifion();

    List<NotifionVo> selectStatment();

}
