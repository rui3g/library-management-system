package cn.tjrac.sytstem.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CommonRespUtil
 * @Description 控制层通用返回封装工具类
 * @Author GaoLei
 * @Date 2019/1/21 22:08
 * @Version 1.0
 **/
public class CommonRespUtil {

    private static final String EMPTY = "";
    public final static String KEY_CODE = "code";
    public final static String KEY_DESC = "desc";
    public final static String KEY_DATA = "data";

    public final static String SUCCESS = "1";
    public final static String FAILED = "0";
    public final static String UNKNOWN = "2";

    /**
     * 无数据返回消息
     * @param code
     * @param desc
     * @return java.lang.String
     */
    public static String returnMsg(String code, String desc) {

        return new StringBuilder("{\"code\":\"")
                .append(code)
                .append("\",\"desc\":\"")
                .append(desc).append("\"}").toString();
    }

    /**
     * 无数据返回消息
     * @param code
     * @param desc
     * @return java.lang.String
     */
    public static String returnMsg(int code, String desc) {
        return new StringBuilder("{\"code\":\"")
                .append(code)
                .append("\",\"desc\":\"")
                .append(desc).append("\"}").toString();
    }

    /**
     * 带数据返回消息
     * @param code 返回编码
     * @param desc 返回描述
     * @param data 数据实体
     * @param <T>
     * @param <J>
     * @return
     */
    public static  <T,J extends JSON> J returnMsg(String code, String desc, T data){
        Map resultMap = new HashMap();
        resultMap.put("code",code);
        resultMap.put("result",data);
        resultMap.put("desc",desc);
        return (J)new JSONObject(resultMap);
    }

}
