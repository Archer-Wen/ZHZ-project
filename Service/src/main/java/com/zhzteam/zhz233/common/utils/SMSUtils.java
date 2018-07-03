/**
* Copyright © 2018 ZhzTeam Info. All rights reserved.
*  
* @Title: SMSUtils.java 
* @Package com.zhz233.common.utils 
* @Description: TODO 
* @author ZhzTeam
* @date 2018年3月19日
* @version V1.0.0
*/
package com.zhzteam.zhz233.common.utils;

import com.zhzteam.zhz233.common.config.SMSConfig;
import com.zhzteam.zhz233.model.zlb.CodeResult;
import com.zhzteam.zhz233.model.zlb.SMSResult;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
* @ClassName: SMSUtils
* @Description: TODO 
* @author ZhzTeam
* @date 2018年3月19日
*/
public class SMSUtils {
	//配置url
	private static final String operation = "/industrySMS/sendSMS";
	/**
	 * 
	* @Title: cerateMsg
	* @Description: TODO 
	* @param len
	* @return 
	* CodeResult  
	* @throws
	 */
	public static CodeResult cerateMsg(int len){
		String code = "";
		char[] chr = {'0', '1', '2', '3', '4', '5', '6',
				'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 
				'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < len; i++) {
		buffer.append(chr[random.nextInt(62)]);
		}
		code = buffer.toString();
		String msg ="【租号站233】尊敬的用户，"
				+ "您的验证码为{+"+code+"+}，"
				+ "请于{30}分钟内正确输入，"
				+ "如非本人操作，"
				+ "请忽略此短信。";
		CodeResult codeResult = new CodeResult();
		codeResult.setCode(code);
		codeResult.setMsg(msg);
		return codeResult;
	}
	/**
	 * 
	* @Title: execute
	* @Description: TODO 
	* @param to
	* @param msg
	* @return 
	* SMSResult  
	* @throws
	 */
	public static SMSResult execute(String to,String msg){
		SMSResult smsResult = new SMSResult();
		String url = SMSConfig.BASE_URL + operation;
		String body = "accountSid=" + SMSConfig.ACCOUNT_SID + "&to=" + to + "&smsContent=" + msg
				+ createCommonParam();
		// 提交请求
		String result = post(url, body);
		//System.out.println("result:" + System.lineSeparator() + result);
		//解析返回数据
		smsResult = GsonUtils.jsonStrToObject(result.toString(), SMSResult.class);
		return smsResult;
	}
	/**
	 * 构造通用参数timestamp、sig和respDataType
	 * 
	 * @return
	 */
	public static String createCommonParam()
	{
		// 时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());

		// 签名
		String sig = DigestUtils.md5Hex(SMSConfig.ACCOUNT_SID + SMSConfig.AUTH_TOKEN + timestamp);

		return "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + SMSConfig.RESP_DATA_TYPE;
	}

	/**
	 * post请求
	 * 
	 * @param url
	 *            功能和操作
	 * @param body
	 *            要post的数据
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, String body){
		/*System.out.println("url:" + System.lineSeparator() + url);
		System.out.println("body:" + System.lineSeparator() + body);*/

		String result = "";
		try
		{
			OutputStreamWriter out = null;
			BufferedReader in = null;
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();

			// 设置连接参数
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(20000);

			// 提交数据
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(body);
			out.flush();

			// 读取返回数据
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			boolean firstLine = true; // 读第一行不加换行符
			while ((line = in.readLine()) != null)
			{
				if (firstLine)
				{
					firstLine = false;
				} else
				{
					result += System.lineSeparator();
				}
				result += line;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
