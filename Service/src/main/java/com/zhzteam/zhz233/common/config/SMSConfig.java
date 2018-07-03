/**
* Copyright © 2018 ZhzTeam Info. All rights reserved.
*  
* @Title: SMSConfig.java 
* @Package com.zhz233.common.config 
* @Description: TODO 
* @author ZhzTeam
* @date 2018年3月19日
* @version V1.0.0
*/
package com.zhzteam.zhz233.common.config;

/**
* @ClassName: SMSConfig
* @Description: TODO 
* @author ZhzTeam
* @date 2018年3月19日
*/
public class SMSConfig {
	/**
	 * url前半部分
	 * */
	public static final String BASE_URL = "https://api.miaodiyun.com/20150822";

	/**
	 * 开发者注册后系统自动生成的账号，可在官网登录后查看
	 */
	public static final String ACCOUNT_SID = "bd78ebaecf524a01a8664d6ceb7a0a4a";

	/**
	 * 开发者注册后系统自动生成的TOKEN，可在官网登录后查看
	 */
	public static final String AUTH_TOKEN = "ae94ee0f8d394d7bbd21e21ac089a582";

	/**
	 * 响应数据类型, JSON或XML
	 */
	public static final String RESP_DATA_TYPE = "json";
	/**
	 * 状态码 发送成功
	 */
	public static final String RESPCODE_SUCCESS = "00000";
	/**
	 * 状态码 手机格式错误
	 */
	public static final String RESPCODE_PHONE_ERROR = "00025";
	/**
	 * 内容模板错误
	 */
	public static final String RESPCODE_BODYTHEME_ERROR = "00134";
	/**
	 * 内容错误<=2 1min
	 */
	public static final String RESPCODE_BODY2_ERROR = "00174";
	/**
	 * 内容错误<=4 30min
	 */
	public static final String RESPCODE_BODY4_ERROR = "00141";
	/**
	 * 内容错误<=10 24hour
	 */
	public static final String RESPCODE_BODY10_ERROR = "00142";
	/**
	 * 超时时间设置 30min
	 */
	public static final Long REDIS_TIMEOUT_30MIN = 1800L;//30min
}
