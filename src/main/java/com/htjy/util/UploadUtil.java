package com.htjy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UploadUtil {
	/**
	 * 2018年4月10日
	 * wcy
	 */
	private static Properties properties = new Properties();
	private static InputStream inputStream;
	
	static{
		 inputStream = UploadUtil.class.getClassLoader().getResourceAsStream("upload.properties");
		 try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取需求新增图片的上传的外部路径地址
	 * @return
	 */
	public static String getUploadPath(){
		return properties.getProperty("path");
	}
}
