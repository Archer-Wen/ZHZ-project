package com.zhzteam.zhz233.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    /**
     * 1小时
     */
    private static final Long HOUR_1_MS = 60 * 60 *1000L;//60 * 60 *1000
    /**
     * 1 天
     */
    private static final Long DAY_1_MS =  24 * 60 * 60 *1000L;

    /**
     * 获取当前时间 Ms
     * @return
     */
    public static Long getDateTime(){
        return System.currentTimeMillis();
    }

    /**
     * 返回时间差 单位小时
     * @param hour
     * @return
     */
    public static Long getLongHour(int hour){
        return HOUR_1_MS * hour;
    }

    /**
     * 返回时间差 单位天
     * @param day
     * @return
     */
    public static Long getLongDay(int day){
        return DAY_1_MS * day;
    }

}
