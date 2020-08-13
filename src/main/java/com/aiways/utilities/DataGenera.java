package com.aiways.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataGenera {

    public String getTimeNow(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        return date;
    }

    public static String subStrToEnd(String str,String indexStr) {

        return str.substring(str.indexOf(indexStr)+1);
    }
}
