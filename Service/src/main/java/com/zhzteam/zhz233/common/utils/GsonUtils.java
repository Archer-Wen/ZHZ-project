/**
* Copyright © 2018 ZhzTeam Info. All rights reserved.
*  
* @Title: GsonUtils.java 
* @Package com.zhz233.common.utils 
* @Description: TODO 
* @author ZhzTeam
* @date 2018年3月19日
* @version V1.0.0
*/
package com.zhzteam.zhz233.common.utils;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
* @ClassName: GsonUtils
* @Description: TODO 
* @author ZhzTeam
* @date 2018年3月19日
*/
public class GsonUtils {
	/**
	 * 
	 */
	private static Gson gson = new Gson();
	/**
	 * 
	 * @Title: objectToJsonStr 
	 * @Description: TODO(对象序列化为json字符串)
	 * @param object
	 * @return String
	 * @throws
	 */
	public static <T> String objectToJsonStr(T object) {
		return gson.toJson(object);
	}	
	/**
	 * 
	 * @Title: jsonToList 
	 * @Description: TODO(json字符串解析为List集合)
	 * @param jsonStr
	 * @param type
	 * @return ListTModel<T>
	 * @throws
	 */
	public static <T> List<T> jsonToList(String jsonStr, Type type) {
		return gson.fromJson(jsonStr, type);
	}
	/**
	 * 
	 * @Title: jsonStrToObject 
	 * @Description: TODO(json字符串解析为对象)
	 * @param jsonStr
	 * @param classOfT
	 * @return T
	 * @throws
	 */
	public static <T> T jsonStrToObject(String jsonStr, Class<T> classOfT) {
		return gson.fromJson(jsonStr, classOfT);
	}
	/**
	 * 
	 * @Title: type 
	 * @Description: TODO()
	 * @param raw
	 * @param args
	 * @return ParameterizedType
	 * @throws
	 */
	public static ParameterizedType type(final Class<?> raw, final Type... args) {
		return new ParameterizedType() {
			
			@Override
			public Type getRawType() {
				return raw;
			}
			
			@Override
			public Type getOwnerType() {
				return null;
			}
			
			@Override
			public Type[] getActualTypeArguments() {
				return args;
			}
		};
	}
}
