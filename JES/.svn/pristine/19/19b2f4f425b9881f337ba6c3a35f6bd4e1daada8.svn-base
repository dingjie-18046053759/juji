package com.fmcq.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

/**
 * @category 系统配置及核心参数常量
 */
public class Comm {
	
	public final static Integer PAGE_SISE=10;
	/**
	 * 用户会话名称
	 */
	public final static String USER_SESSION_NAME="adminsession";
	public final static String MSG="msg";//消息KEY名称
	public final static String THIS_URL = "http://app.onlinebiz.com.cn:8899/IES/";
//	public final static String TXT_URL = "http://app.onlinebiz.com.cn:8899/IES/ctxt/";
	public final static String TXT_URL = "http://118.194.194.37/";

	/**
	 * 操作警告提示
	 * @param req
	 * @param info
	 */
	public static void ScriptAlert(HttpServletRequest req, String info)
    {
        req.setAttribute(MSG, String.format("conTip('%s',icons.warning);",info));
    }
	

	/**
	 * 操作成功提示
	 * @param req
	 * @param info
	 */
	public static void ScriptInfo(HttpServletRequest req, String info)
    {
        req.setAttribute(MSG, String.format("conTip('%s',icons.succeed);",info));
    }
	
	/**
	 * @param str
	 * @return MD5加密
	 */
	public static String MD5(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
}
