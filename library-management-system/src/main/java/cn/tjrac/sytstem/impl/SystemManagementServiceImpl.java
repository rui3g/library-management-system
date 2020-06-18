package cn.tjrac.sytstem.impl;

import cn.tjrac.sytstem.dao.SystemManagementDao;
import cn.tjrac.sytstem.service.SystemManagementService;
import cn.tjrac.sytstem.vo.SystemVo;
import cn.tjrac.sytstem.vo.SystemxVo;
import cn.tjrac.sytstem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/4/24 12:19
 */
@Service
@Transactional
public class SystemManagementServiceImpl implements SystemManagementService {

    @Autowired
    private SystemManagementDao systemManagementDao;

    @Override
    public List<SystemVo> selectSystem() {
        return systemManagementDao.selectSystem();
    }

    @Override
    public List<SystemVo> selectInformtion() {
        return systemManagementDao.selectInformtion();
    }

    @Override
    public int insertNotice(SystemxVo systemxVo) {
        return systemManagementDao.insertNotice(systemxVo);
    }

    @Override
    public int insertInformtion(SystemxVo systemxVo) {
        return systemManagementDao.insertInformtion(systemxVo);
    }

    @Override
    public List<UserVo> selectUserInfo() {
        return systemManagementDao.selectUserInfo();
    }

    @Override
    public int updateUserStatus(int uid) {
        return systemManagementDao.updateUserStatus(uid);
    }

    @Override
    public int delUser(int uid) {
        return systemManagementDao.delUser(uid);
    }
}
