package cn.tjrac.sytstem.dao;

import cn.tjrac.sytstem.vo.EnterHouseVo;
import cn.tjrac.sytstem.vo.OrderVo;
import cn.tjrac.sytstem.vo.RepertoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/3/31 17:05
 */
@Mapper
@Component
public interface ListOrderDao {

    OrderVo selectListOrder(@Param("bookNumber") String bookNumber,@Param("profession") String profession,@Param("grade") String grade);

    int insertListOrder(EnterHouseVo enterHouseVo);

    List<EnterHouseVo> selectEnterHouse();

    int insertRepertory(EnterHouseVo enterHouseVo);

    List<RepertoryVo> selectRepertory();

    List<OrderVo> selectAllOrder();

    OrderVo selectOneOrder(String bookNumber);
}
