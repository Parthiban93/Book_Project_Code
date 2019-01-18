package com.java.book.Util;

import java.util.UUID;

public class CommonUtils {
	
	/**
	 * The process of this method is to generate unique book id.
	 * @return Unique String value.
	 */
	public static String getUniqueId() {
		return UUID.randomUUID().toString();
	}
	
}
