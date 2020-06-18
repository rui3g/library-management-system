package cn.tjrac.sytstem.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YO
 * @create 2019-07-09 11:56
 */
public class UnixTimeUtil {
    public static final String GSTIME="yyyy-MM-dd HH:mm:ss";

    public static String getTimestampDate(String timestamp){
        String str;
        SimpleDateFormat unix_time = new SimpleDateFormat(GSTIME);
        str = unix_time.format(new Date(Long.valueOf(timestamp)));
        return str;
    }
}
