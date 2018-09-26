package edu.csuft.assess.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
	
	/**
	 * 将字符串编码为SHA256
	 * @param text
	 * @return
	 */
	public static String stringToSHA256(String text) {
		String result = "";
		try {
			byte[] data = MessageDigest.getInstance("SHA-256").digest(text.getBytes());
			result = new BigInteger(1, data).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}
