package com.yinzhi.eduplat.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 平台配置文件
 * @author 黄清泉
 * @date 2013-3-20
 */
public class EduplatCfgUtil {

	private static Properties prop = null;
	
	static{
		String classpath = EduplatCfgUtil.class.getResource("/").getPath();
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(classpath + "application-ini.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		return prop.getProperty(key);
	}
}
