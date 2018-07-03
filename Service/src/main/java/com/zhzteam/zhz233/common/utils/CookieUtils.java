package com.zhzteam.zhz233.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CookieUtils {
    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name
     *            cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 保存Cookies
     *
     * @param response
     *            servlet请求
     * @param value
     *            保存值
     * @author jxf
     */
    public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value, int time) {
        // new一个Cookie对象,键值对为参数
        Cookie cookie = new Cookie(name, value);
        // tomcat下多应用共享
        cookie.setPath("/");
        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
        try {
            URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(time);//单位 秒
        cookie.setHttpOnly(true);
        // 将Cookie添加到Response中,使之生效
        response.addCookie(cookie); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
        return response;
    }
    /**
     * 删除无效cookie
     * 无效☞1.过时 2.未发布
     * @param request
     * @param response
     * @param
     */
    private void delectCookieByName(HttpServletRequest request, HttpServletResponse response,String deleteKey) throws NullPointerException {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        for (String key : cookieMap.keySet()) {
            if(key==deleteKey && key.equals(deleteKey)) {
                Cookie cookie = cookieMap.get(key);
                cookie.setMaxAge(0);//设置cookie有效时间为0
                cookie.setPath("/");//不设置存储路径
                response.addCookie(cookie);
            }
        }
    }
}
