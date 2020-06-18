package cn.tjrac.sytstem.controler;

import cn.tjrac.sytstem.service.ListOrderService;
import cn.tjrac.sytstem.util.CommonRespUtil;
import cn.tjrac.sytstem.vo.EnterHouseVo;
import cn.tjrac.sytstem.vo.ListOrderVo;
import cn.tjrac.sytstem.vo.OrderVo;
import cn.tjrac.sytstem.vo.RepertoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

/**
 * @author Rui3g
 * @date 2020/3/31 17:09
 */

@RestController
@RequestMapping("/libraryManagement")
@Api("教材订单核对")
public class ListOrderController {

    @Autowired
    private ListOrderService listOrderService;

    @ApiOperation(value = "订单核对", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectorder", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object selectListOrder(@RequestBody String orderVoList){
        System.out.println("======"+orderVoList);
       int flag = listOrderService.orderCheck(orderVoList);
        //flag =1,信息正确|flag =2,数量不对
        if (flag==1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"核对成功,购买数量正确");
        }else if (flag == 2){
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"核对成功,数量有误");
        }else {
            return CommonRespUtil.returnMsg(CommonRespUtil.FAILED,"程序出错");
        }
    }

    @ApiOperation(value = "入库操作", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/insertorder", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object insertListOrder(@RequestBody String enterHouseJsonVos){
        //System.out.println("============="+order);
        int result = listOrderService.enterHouse(enterHouseJsonVos);
        if (result==1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"入库成功");
        }else {
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"入库失败，程序出错");
        }
    }

    @ApiOperation(value = "查询入库记录", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectEnterHouse", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object  selectEnterHouse(){
        List<EnterHouseVo> enterHouseVoList = listOrderService.selectEnterHouse();
        if (enterHouseVoList.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"查询入库记录成功",enterHouseVoList);
        }else{
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "查询库存", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectRepertory", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object  selectRepertory(){
        List<RepertoryVo> repertoryVoList = listOrderService.selectRepertory();
        if (repertoryVoList.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"查询库存成功",repertoryVoList);
        }else{
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "查询预定表全部信息", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectAllOrder", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object  selectAllOrder(){
        List<OrderVo> orderVoList = listOrderService.selectAllOrder();
        if (orderVoList.size()>0){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"查询库存成功",orderVoList);
        }else{
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN,"查询失败");
        }
    }

    @ApiOperation(value = "导出excel", notes = "导出", produces = "application/json")
    @RequestMapping(value = "/outExcel", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object outExcel(@RequestParam(value = "title") String title,
                           @RequestParam(value = "header") String[] header,
                           @RequestParam(value = "dataset") ListOrderVo listOrderVo){
        //HttpServletResponse response =null;
        //response.setHeader(application/x-www-form-urlencoded);
        OutputStream out =null;
        int i = 0;
        try {
            OutputStream outputStream = new FileOutputStream("D:/");
            Collection<T> dataset = (Collection<T>) listOrderVo.getOrderVoList().iterator();
            i = listOrderService.outExcel(title,header,dataset,outputStream);
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (i==1){
        return  CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"导出成功");
        }else {
            return CommonRespUtil.returnMsg(CommonRespUtil.UNKNOWN, "导出失败");
        }
    }

}
