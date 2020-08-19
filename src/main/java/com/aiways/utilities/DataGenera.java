package com.aiways.utilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DataGenera {

    public String getTimeNow(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        return date;
    }

    public static String subStrToEnd(String str,String indexStr) {

        return str.substring(str.indexOf(indexStr)+1);
    }

    public DesiredCapabilities getIosCapabilities(Map<String, String> map) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            capabilities.setCapability(entry.getKey(), entry.getValue());
        }
        return capabilities;
    }
}
