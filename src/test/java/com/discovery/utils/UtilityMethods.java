package com.discovery.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class UtilityMethods implements FileLocation {
	public static Properties property = new Properties();
	public static FileInputStream fis;

	public static String getPropertyValues(String key) {
		try {
			fis = new FileInputStream(new File(URLDATA_FILE_LOCATION));
			property.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return property.getProperty(key);
	}
}
