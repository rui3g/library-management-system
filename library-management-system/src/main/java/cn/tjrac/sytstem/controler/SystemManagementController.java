package cn.tjrac.sytstem.controler;

import cn.tjrac.sytstem.service.SystemManagementService;
import cn.tjrac.sytstem.util.CommonRespUtil;
import cn.tjrac.sytstem.vo.SystemVo;
import cn.tjrac.sytstem.vo.SystemxVo;
import cn.tjrac.sytstem.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/4/24 12:17
 */
@RestController
@RequestMapping("/System")
@Api("系统管理")
public class SystemManagementController {

    @Autowired
    private SystemManagementService systemManagementService;

    @ApiOperation(value = "公告查询", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectSystem", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object selectSystem(){
        List<SystemVo> systemVos = systemManagementService.selectSystem();
        if (systemVos.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"查询成功",systemVos);
        }else {
            return  CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "消息查询", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectInformtion", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object selectInformtion(){
        List<SystemVo> systemVos = systemManagementService.selectInformtion();
        if (systemVos.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"查询成功",systemVos);
        }else {
            return  CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "公告发布", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/insertNotice", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object insertNotice(@RequestBody SystemxVo systemxVo){
        int i = systemManagementService.insertNotice(systemxVo);
        if (i == 1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"发布成功");
        }else {
            return  CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "消息发布", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/insertInformtion", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object insertInformtion(@RequestBody SystemxVo systemxVo){
        int i = systemManagementService.insertInformtion(systemxVo);
        if (i == 1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"发布成功");
        }else {
            return  CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "未审核用户", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectUserInfo", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object selectUserInfo(){
       List<UserVo> userVos = systemManagementService.selectUserInfo();
        if (userVos.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"查询成功",userVos);
        }else {
            return  CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "修改审核状态", notes = "修改", produces = "application/json")
    @RequestMapping(value = "/updateUserStatus", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object updateUserStatus(@RequestBody UserVo userVo){
        int i = systemManagementService.updateUserStatus(userVo.getUid());
        if (i == 1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"审核成功");
        }else {
            return  CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"审核失败");
        }
    }

    @ApiOperation(value = "删除用户", notes = "删除", produces = "application/json")
    @RequestMapping(value = "/delUser", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object  delUser(@RequestBody UserVo userVo){
        int i = systemManagementService.delUser(userVo.getUid());
        if (i == 1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"删除成功");
        }else {
            return  CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"删除失败");
        }
    }


}
