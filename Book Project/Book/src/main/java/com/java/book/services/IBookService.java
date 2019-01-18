package com.java.book.services;

import java.util.List;

import com.java.book.exception.BookServiceException;
import com.java.book.model.Book;

public interface IBookService {
	
	public void initializedBooks() throws BookServiceException;
	
	public List<Book> getAllBooks() throws BookServiceException;
	
	public String updateBook(Book book) throws BookServiceException;

}
