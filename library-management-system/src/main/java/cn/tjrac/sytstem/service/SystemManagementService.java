package cn.tjrac.sytstem.service;

import cn.tjrac.sytstem.vo.SystemVo;
import cn.tjrac.sytstem.vo.SystemxVo;
import cn.tjrac.sytstem.vo.UserVo;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/4/24 12:19
 */
public interface SystemManagementService {

    List<SystemVo> selectSystem();//查公告

    List<SystemVo> selectInformtion();

    int insertNotice(SystemxVo systemVo);

    int insertInformtion(SystemxVo systemVo);

    List<UserVo> selectUserInfo();

    int updateUserStatus(int uid);

    int delUser(int uid);//删除用户
}
