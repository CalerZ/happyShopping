package com.jkq.jsqiang.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Caler_赵康乐
 * @create 2020-02-14 11:07
 * @description :
 */
public class Utils {


    //日期时间
    public static String getCurrentDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = sdf.format(new Date());
        return dateStr;

    }

    //日期时间
    public static Date getDateTime2String(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return date;

    }
}
