package cn.tjrac.sytstem.controler;

import cn.tjrac.sytstem.service.OutLayService;
import cn.tjrac.sytstem.util.CommonRespUtil;
import cn.tjrac.sytstem.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Rui3g
 * @date 2020/4/14 17:41
 */
@RestController
@RequestMapping("/outManagement")
@Api("出库管理")
public class OutLayController {

    @Autowired
    private OutLayService outLayService;

    @ApiOperation(value = "添加出库记录", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/addOutLay", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addOutLay(@RequestBody String outlay){
         //list = JSONArray.toJSONString(map.get("data"));
        ListOutLayVo outLayVos = JSON.parseObject(outlay,ListOutLayVo.class);
        System.out.println("============"+outlay);
        System.out.println("============="+outLayVos.getOutlay().size());
        List<OutLayVo> outlist = outLayVos.getOutlay();
        int i = outLayService.takeLogic(outlist);//添加出库库存减少生成通知单
        if (i==1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"出库记录成功");
        }else{
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"记录失败或没有此书籍");
        }
    }

    @ApiOperation(value = "生成费用核算单", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/insertStatement", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object insertStatement(@RequestBody String notifionVos ){
        ListNotifionVo listNotifionVo = JSON.parseObject(notifionVos, ListNotifionVo.class);
        System.out.println("============"+listNotifionVo.getNotifionVos().size());
        int i = outLayService.insertStatement(listNotifionVo.getNotifionVos());
        if (i==1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"费用核算单生成成功");
        }else{
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"生成失败");
        }
    }

    @ApiOperation(value = "查询出库记录", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectOutLay", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object selectOutLay(){
        List<OutLayVo> outLayVos = outLayService.selectOutLay();
        if (outLayVos.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"出库记录查询成功",outLayVos);
        }else{
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"生成失败");
        }
    }

    @ApiOperation(value = "查询费用通知单", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectNotifion", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object selectNotifion(){

        List<NotifionVo> notifionVos = outLayService.selectNotifion();
        if (notifionVos.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"费用通知单查询成功",notifionVos);
        }else{
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "查询费用通知单", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectStatment", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object selectStatment(){

        List<NotifionVo> notifionVos = outLayService.selectStatment();
        if (notifionVos.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"费用核算单查询成功",notifionVos);
        }else{
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

}
