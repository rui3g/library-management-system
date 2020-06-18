package cn.tjrac.sytstem.service;



import cn.tjrac.sytstem.vo.DepartVo;
import cn.tjrac.sytstem.vo.GradeVo;
import cn.tjrac.sytstem.vo.ProfessionVo;
import cn.tjrac.sytstem.vo.UserVo;

import java.util.List;

/**
 * @Auther zzddxx
 * @Data 2020/4/22
 */
public interface LoginService {

    UserVo login(UserVo userVo);

    void register(UserVo userVo);

    void uppassword(UserVo userVo);

    List<DepartVo> seldepartment();

    List<GradeVo> selgrade();

    List<ProfessionVo> selprofession();


}
