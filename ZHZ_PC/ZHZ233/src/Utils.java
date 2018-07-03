import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	/**
	 * 是否空字符串
	 * @param str
	 * @return
	 */
	public static boolean isNullString(String str) {
		if(str == null || str.isEmpty() || str=="" || str.length()==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否为数字
	 * @param str
	 * @return
	 */
	public static boolean IsNumber(String str) {
	       String regex = "^[0-9]*$";
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
	 
	private static boolean match(String regex, String str) {
	       // 编译正则表达式
	       Pattern ptn = Pattern.compile(regex);
	       Matcher mthr = ptn.matcher(str);
	       // 字符串是否与正则表达式相匹配
	       return mthr.matches();//返回结果
	}
}
