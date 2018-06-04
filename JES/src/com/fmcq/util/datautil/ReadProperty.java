package com.fmcq.util.datautil;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @date 2016-1-27 下午2:06:30
 * @author xb
 * Created by IntelliJ IDEA. User: CJava Date: 12-3-23 Time: 下午2:52 To change
 * this template use File | Settings | File Templates.
 */
public class ReadProperty {

	public static String read(String key) {
		return read(key, null);
	}

	public static String read(String key, String fileName) {
		Properties props = new Properties();
		InputStream in = null;
		if ((fileName == null) || (fileName.equals("")))
			fileName = "/config.properties";
		try {
			in = new BufferedInputStream(ReadProperty.class.getResourceAsStream(fileName));
			props.load(in);
			String value = props.getProperty(key);
			in.close();
			props.clear();
			return new String(value.getBytes("ISO8859_1"), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			if (in != null)
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		return null;
	}
}
