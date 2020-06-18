package cn.tjrac.sytstem.dao;

import cn.tjrac.sytstem.vo.SystemVo;
import cn.tjrac.sytstem.vo.SystemxVo;
import cn.tjrac.sytstem.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/4/24 12:18
 */
@Mapper
@Component
public interface SystemManagementDao {

    List<SystemVo> selectSystem();//查公告

    List<SystemVo> selectInformtion();

    int insertNotice(SystemxVo systemVo);//公告

    int insertInformtion(SystemxVo systemVo);

    List<UserVo> selectUserInfo();//未审核用户

    int updateUserStatus(int uid);//修改审核状态

    int delUser(int uid);//删除用户


}
