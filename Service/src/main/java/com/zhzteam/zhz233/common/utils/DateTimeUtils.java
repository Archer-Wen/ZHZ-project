package com.zhzteam.zhz233.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理类
 */
public class DateTimeUtils {
    /**
     * 格式 yyyy-MM-dd HH:mm:ss
     */
    private static final String PATTERN_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
    /**
     * 格式 yyyyMMddHHmmss
     */
    private static final String PATTERNYMDHMS = "yyyyMMddHHmmss";
    /**
     * 格式 yyyy-MM-dd
     */
    private static final String PATTERN_Y_M_D = "yyyy-MM-dd";
    /**
     * 格式 yyyyMMdd
     */
    private static final String PATTERN_YMD = "yyyyMMdd";
    /**
     * 格式 yyyy-MM
     */
    private static final String PATTERN_Y_M = "yyyy-MM";
    /**
     * 格式 yyyyMM
     */
    private static final String PATTERN_YM = "yyyyMM";
    /**
     * 格式 yyyy
     */
    private static final String PATTERN_Y = "yyyy";

    /**
     * 获取 13 位毫秒数
     * @return
     */
    public static Long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }


    /**
     * 设置时间 ymd dms
     * @param minute
     * @param second
     * @return
     */
    public static Date getDateTime(Integer hour,Integer minute,Integer second){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        return calendar.getTime();
    }

    /**
     *
     * @param day
     * @return
     */
    public static Date addDay(Integer day){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,day);
        return calendar.getTime();
    }

    /**
     * 增加 小时
     * @param hour
     * @return
     */
    public static Date addHour(Integer hour){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,hour);
        return calendar.getTime();
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Date getDateTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 获取Date 时间
     * @param dateStr
     * @return
     */
    public static Date getDatePATTERN_YMDHMS(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前日期时间 年月日 格式：PATTERN_Y_M
     * @return
     */
    public static String getPatternY() {
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_Y);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    }
    /**
     * 获取当前日期时间 年月日 格式：PATTERN_YM
     * @return
     */
    public static String getPatternYM() {
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_YM);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    }
    /**
     * 获取当前日期时间 年月日 格式：PATTERN_Y_M
     * @return
     */
    public static String getPatternY_M() {
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_Y_M);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    }
    /**
     * 获取当前日期时间 年月日 格式：PATTERN_YMD
     * @return
     */
    public static String getPatternYMD() {
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_YMD);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    }
    /**
     * 获取当前日期时间 年月日 格式：PATTERN_Y_M_D
     * @return
     */
    public static String getPattern_YMD() {
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_Y_M_D);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    }
    /**
     * 获取当前日期时间 年月日 格式：PATTERNYMDHMS
     * @return
     */
    public static String getPatternYMDHMS() {
        SimpleDateFormat df = new SimpleDateFormat(PATTERNYMDHMS);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    }
    /**
     * 获取当前日期时间 年月日 格式：PATTERN_Y_M_D_H_M_S
     * @return
     */
    public static String getPattern_YMDHMS() {
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_Y_M_D_H_M_S);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    }
}
