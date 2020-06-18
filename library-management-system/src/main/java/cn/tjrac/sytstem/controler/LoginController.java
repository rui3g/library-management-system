package cn.tjrac.sytstem.controler;

import cn.tjrac.sytstem.service.LoginService;
import cn.tjrac.sytstem.util.CommonRespUtil;
import cn.tjrac.sytstem.util.SHALUtil;
import cn.tjrac.sytstem.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther zzddxx
 * @Data 2020/4/22
 */
@RestController
@RequestMapping("/lc")
@Api("登陆")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录", notes = "登录", produces = "application/json")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object login(@RequestBody UserVo userVo) {
        try {
            userVo.setPassword(SHALUtil.getSha1(userVo.getPassword()));
            UserVo userVo1 = loginService.login(userVo);
            if (userVo1 == null) {
                return CommonRespUtil.returnMsg(CommonRespUtil.FAILED, "账号密码错误");
            } else {
                return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS, "登录成功", userVo1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonRespUtil.returnMsg(CommonRespUtil.FAILED, "登录错误，请联系管理员");
        }
    }

    @ApiOperation(value = "注册", notes = "注册", produces = "application/json")
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object register(@RequestBody UserVo userVo) {
        try {
            userVo.setPassword(SHALUtil.getSha1(userVo.getPassword()));
            loginService.register(userVo);

            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS, "注册成功");

        } catch (Exception e){
            e.printStackTrace();
            return CommonRespUtil.returnMsg(CommonRespUtil.FAILED, "注册错误，请联系管理员!");
        }
    }

    @ApiOperation(value = "修改密码", notes = "修改密码", produces = "application/json")
    @RequestMapping(value = "/uppassword", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object uppassword(@RequestBody UserVo userVo) {
        try {
            userVo.setPassword(SHALUtil.getSha1(userVo.getPassword()));
            loginService.uppassword(userVo);

            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS, "修改成功，请重新登录！");

        } catch (Exception e) {
            e.printStackTrace();
            return CommonRespUtil.returnMsg(CommonRespUtil.FAILED, "修改错误，请联系管理员！");
        }
    }

    @ApiOperation(value = "系别专业年级查询", notes = "系别专业年级查询", produces = "application/json")
    @RequestMapping(value = "/dgplist", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object dgplist() {
        try {
            ListVo listVo = new ListVo();
            List<DepartVo> departmentVoList = loginService.seldepartment();
            List<GradeVo> gradeVoList = loginService.selgrade();
            List<ProfessionVo> professionVoList = loginService.selprofession();
            listVo.setDepartmentVoList(departmentVoList);
            listVo.setGradeVoList(gradeVoList);
            listVo.setProfessionVoList(professionVoList);
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"系别专业年级查询成功",listVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonRespUtil.returnMsg(CommonRespUtil.FAILED,"系别专业年级查询失败");
        }
    }


}
