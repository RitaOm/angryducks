package com.epam.jmp.utils;

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
	
	 public static String getProperty(String key, Object... params ) {
	        try {
	            return MessageFormat.format(resourceBundle.getString(key), params);
	        } catch (MissingResourceException e) {
	            return '!' + key + '!';
	        }
	    }

}
