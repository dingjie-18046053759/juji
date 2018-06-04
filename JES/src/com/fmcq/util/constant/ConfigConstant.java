package com.fmcq.util.constant;

import com.fmcq.util.datautil.ReadProperty;

public class ConfigConstant {
	public static final String APPID = ReadProperty.read("appId"); 
	public static final String APPKEY = ReadProperty.read("appKey"); 
	public static final String URL = ReadProperty.read("URL"); 
	public static final String ECCODE = ReadProperty.read("ECCode"); 
	public static final int STIME = Integer.parseInt(ReadProperty.read("SleepTime")); 

}
