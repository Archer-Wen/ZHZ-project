package com.zhzteam.zhz233.test;

import com.zhzteam.zhz233.common.utils.*;
import com.zhzteam.zhz233.model.JWTModel;
import com.zhzteam.zhz233.model.zlb.JWTResult;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilsTest {
    @Test
    public void Test9(){
        //System.err.println(AutoIncUtils.getFileURLNo(""));
        System.err.println(REVUtils.isChinese("张三李四我aiab"));
    }
    @Test
    public void Test8(){
        System.err.println(DateTimeUtils.getPatternYMDHMS());
        System.err.println(DateTimeUtils.getCurrentTimeMillis());
        System.err.println(DateTimeUtils.getCurrentTimeMillis());
    }

    @Test
    public void Test7(){
        System.err.println(AutoIncUtils.getInvlaOrderNo("2018052500000000000001"));
    }
    @Test
    public void Test6(){
        String A = AutoIncUtils.getAccountNo("");
        System.err.println(A);
        String a = AutoIncUtils.getLeaseOrderNo("");
        System.err.println(a);
    }
    @Test
    public void Test5(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        //calendar.add(Calendar.DAY_OF_MONTH,1);
        //calendar.add(Calendar.DAY_OF_YEAR,1);
        System.err.println(df.format(calendar.getTime()));
    }
    @Test
    public void Test4(){
        Date t= DateTimeUtils.getDateTime(22,0,0);
        System.err.println(t);
        Date tt= DateTimeUtils.getDateTime(22+10,0,0);
        System.err.println(tt);
    }
    @Test
    public void Test3(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Long t = System.currentTimeMillis();
        Date tt = new Date(t);
        Date ttt = new Date(t+ DateUtils.getLongHour(2));

        System.err.println(df.format(tt));
        System.err.println(ttt);
        System.err.println(DateTimeUtils.getDatePATTERN_YMDHMS(df.format(tt)));
    }
    @Test
    public void Test2(){
        String fileName = "12312.jpg";
        String prefixName = fileName.substring(fileName.lastIndexOf("."));
        prefixName = fileName.substring(0,fileName.lastIndexOf("."));
        System.out.println(fileName.lastIndexOf("."));
        System.out.println(prefixName);
    }
    @Test
    public void Test1(){
        String autoNo = AutoIncUtils.getAccountNo("");
    }
    @Test
    public void Test0() {
        //String jwtStr = JWTUtils.createJWT(JWTConfig.JWT_ISS, "", "1", "", JWTConfig.JWT_TIME_30MINUTE);
        String jwtStr = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJaSFpUZWFtIiwiYXVkIjoienVtZW5nMjAxOCIsImp0aSI6IjIwMTgwMDAwMDAwMyIsInN1YiI6IlpIWjIzM19VU0VSX0FVVEgwIiwiaWF0IjoxNTI2MzEyMDMwLCJleHAiOjE1MjYzMTM4MzB9.hPGoOmzTXGdg8aYV42k-GhixEb0VbTorWhul7yNEvP8";
        JWTResult jwtResult = JWTUtils.validateJWT(jwtStr);
        System.err.println(jwtResult.getStatus());
        String claims = GsonUtils.objectToJsonStr(jwtResult.getClaims());
        JWTModel jwtModel = GsonUtils.jsonStrToObject(claims, JWTModel.class);
        System.err.println(jwtStr);
        System.err.println(claims);
        System.err.println(jwtModel.getJti());
    }
}
