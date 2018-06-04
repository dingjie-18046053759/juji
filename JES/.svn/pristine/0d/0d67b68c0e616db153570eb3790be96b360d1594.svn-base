package com.fmcq.util.codingutil;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptAES {
	//算法名称/加密模式/填充方式 
	//DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
	private static final String AESTYPE = "AES/ECB/PKCS5Padding";

	public static String AES_Encrypt(String keyStr, String plainText) {
		byte[] encrypt = null;
		try {
			Key key = generateKey(keyStr);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypt = cipher.doFinal(plainText.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(Base64.encode(encrypt));
	}

	public static String AES_Decrypt(String keyStr, String encryptData) {
		byte[] decrypt = null;
		try {
			Key key = generateKey(keyStr);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypt = cipher.doFinal(Base64.decode(encryptData));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(decrypt).trim();
	}

	private static Key generateKey(String key) throws Exception {
		try {
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
			return keySpec;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public static void main(String[] args) {

		String keyStr = "1234567899876543";

		//		String plainText = "this is a string will be AES_Encrypt";
		String plainText = "{\"head\": {\"Channel\": \"Web\",\"Action\": \"CWA001\"},"
				+ "\"body\": {\"Phone\": \"13905920132\",\"FlowNum\": \"50\",\"EffType\": \"1\","
				+ "\"EndTime\": \"20160329\",\"DealID\": \"3831001001\",\"CallbackURL\": \"http://127.0.0.1:8080/ycode/flow/interface/test.do\"}}";

		String encText = AES_Encrypt(keyStr, plainText);
		String decString = AES_Decrypt(keyStr, encText);

		System.out.println(encText);
		System.out.println(decString);

	}
}
