package com.java.book.Util;

import java.util.HashMap;

import com.java.book.model.Book;

/**
 * The process of this class to store books data in memory.
 * @author Parthiban Subramanian
 *
 */
public class Storage {
	public static Boolean isInitialized = false;
    public static HashMap<String, Book> bookStorage = new  HashMap<String, Book>();

}
