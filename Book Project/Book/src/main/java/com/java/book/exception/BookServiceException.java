package com.java.book.exception;


public class BookServiceException extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046169125059352271L;

	
	private final String customeMsg;
    public BookServiceException(String customeMsg) {
        super();
        this.customeMsg = customeMsg;
    }
   
    public String getCustomeMsg() {
        return this.customeMsg;
    }
}
