package com.zhzteam.zhz233.common.utils;

public class XMLPathUtils {
    private final static String XMLHR= "XMLHttpRequest";

    /**
     * 判断Ajax 访问
     * @param requestType
     * @return
     */
    public static boolean isXMLHR(String requestType){
        if(XMLHR.equals(requestType))return true;
        return false;
    }
}
