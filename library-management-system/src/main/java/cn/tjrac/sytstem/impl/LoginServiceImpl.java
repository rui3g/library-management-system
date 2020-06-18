package cn.tjrac.sytstem.impl;


import cn.tjrac.sytstem.dao.LoginDao;
import cn.tjrac.sytstem.service.LoginService;
import cn.tjrac.sytstem.vo.DepartVo;
import cn.tjrac.sytstem.vo.GradeVo;
import cn.tjrac.sytstem.vo.ProfessionVo;
import cn.tjrac.sytstem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther zzddxx
 * @Data 2020/4/22
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public UserVo login(UserVo userVo) {
        return loginDao.login(userVo);
    }

    @Override
    public void register(UserVo userVo) {
        loginDao.register(userVo);
    }

    @Override
    public void uppassword(UserVo userVo) {
        loginDao.uppassword(userVo);
    }

    @Override
    public List<DepartVo> seldepartment() {
        return loginDao.seldepartment();
    }

    @Override
    public List<GradeVo> selgrade() {
        return loginDao.selgrade();
    }

    @Override
    public List<ProfessionVo> selprofession() {
        return loginDao.selprofession();
    }


}
