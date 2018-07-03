package com.zhzteam.zhz233.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REVUtils {

    /**
     * 验证验证输入汉字
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean isChinese(String str) {
        /*String regex = "^[\u4e00-\u9fa5],{0,}$";*/
        String regex = "^([\\u4e00-\\u9fa5]){2,7}$";
        return match(regex, str);
    }

    /**
     * 11位 手机号
     * @param str
     * @return
     */
    public static boolean isLogonPhone(String str) {
        String regex = "^[1][3,4,5,7,8][0-9]{9}$";//^[\\\\w]{8,12}$
        return match(regex, str);
    }

    /**
     * 6-12位 账号 手机号 密码 验证
     * @param str
     * @return
     */
    public static boolean isLogonInfo(String str) {
        String regex = "^[a-zA-Z0-9_]{6,12}$";
        return match(regex, str);
    }

    /**
     * 验证邮箱
     *
     * @param str
     * @return 如果是符合的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean isEmail(String str) {
        //"[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";//邮箱
        String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        return match(regex, str);
    }
    /**
     * 验证输入身份证号
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsIDcard(String str) {
        String regex = "(^\\d{18}$)|(^\\d{15}$)";
        return match(regex, str);
    }
    /**
     * 验证输入两位小数
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsDecimal(String str) {
        String regex = "^[0-9]+(.[0-9]{2})?$";
        return match(regex, str);
    }

    /**
     * 验证输入一年的12个月
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */

    public static boolean IsMonth(String str) {
        String regex = "^(0?[[1-9]|1[0-2])$";
        return match(regex, str);
    }

    /**
     * 验证输入一个月的31天
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsDay(String str) {
        String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
        return match(regex, str);
    }

    /**
     * 验证日期时间
     *
     * @param str
     * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean isDate(String str) {
        // 严格验证时间格式的(匹配[2002-01-31], [1997-04-30],
        // [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])
        // String regex =
        // "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";
        // 没加时间验证的YYYY-MM-DD
        // String regex =
        // "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";
        // 加了时间验证的YYYY-MM-DD 00:00:00
        String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
        return match(regex, str);
    }

    /**
     * 验证数字输入
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsNumber(String str) {
        String regex = "^[0-9]*$";
        return match(regex, str);
    }

    /**
     * 验证非零的正整数
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsIntNumber(String str) {
        String regex = "^\\+?[1-9][0-9]*$";
        return match(regex, str);
    }

    /**
     * 验证大写字母
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsUpChar(String str) {
        String regex = "^[A-Z]+$";
        return match(regex, str);
    }

    /**
     * 验证小写字母
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsLowChar(String str) {
        String regex = "^[a-z]+$";
        return match(regex, str);
    }

    /**
     * 验证验证输入字母
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsLetter(String str) {
        String regex = "^[A-Za-z]+$";
        return match(regex, str);
    }

    /**
     * 验证验证输入汉字
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsChinese(String str) {
        String regex = "^[\u4e00-\u9fa5],{0,}$";
        return match(regex, str);
    }

    /**
     * 验证验证输入字符串
     *
     * @param str
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsLength(String str) {
        String regex = "^.{8,}$";
        return match(regex, str);
    }

    /**
     * @Title: matchr
     * @Description: TODO(验证正则表达式 广义)
     * @param @param regex 验证的字符串规则
     * @param @param str 待验证的字符串
     * @param @return
     * @return boolean
     * @throws
     */
    @SuppressWarnings("unused")
    private static boolean matchr(String regex, String str) {
        //编译正则表达式
        Pattern ptn = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);//忽略大小写
        Matcher mthr = ptn.matcher(str);
        // 字符串是否与正则表达式相匹配
        return mthr.matches();//返回结果
    }
    /**
     * @Title: match
     * @Description: TODO(验证正则表达式 狭义)
     * @param @param 验证的字符串规则
     * @param @param str 待验证的字符串
     * @param @return
     * @return boolean
     * @throws
     */
    private static boolean match(String regex, String str) {
        // 编译正则表达式
        Pattern ptn = Pattern.compile(regex);
        Matcher mthr = ptn.matcher(str);
        // 字符串是否与正则表达式相匹配
        return mthr.matches();//返回结果
    }
}
