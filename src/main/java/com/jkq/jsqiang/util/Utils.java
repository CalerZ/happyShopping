package com.jkq.jsqiang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Caler_赵康乐
 * @create 2020-02-14 11:07
 * @description :
 */
public class Utils {


    //日期时间
    public String getCurrentDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = sdf.format(new Date());
        return dateStr;




    }
}
