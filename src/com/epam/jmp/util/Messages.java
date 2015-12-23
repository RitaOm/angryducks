package com.epam.jmp.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class Messages {

	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle(PathManager.PROPERTY_FILE_PATH);

	private Messages() {
	}

	public static String getProperty(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	 public static String getProperty(String key, String param) {
	        try {
	            return MessageFormat.format(resourceBundle.getString(key), param);
	        } catch (MissingResourceException e) {
	            return '!' + key + '!';
	        }
	    }

}
