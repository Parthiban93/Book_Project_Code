package com.java.book.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.book.exception.BookServiceException;
import com.java.book.model.Book;
import com.java.book.services.IBookService;
import com.java.book.services.imp.BookServiceImp;

/**
 * BookApiController : The process this class is to handle the Book Service API request.
 * @author Parthiban Subramanian
 *
 */
@RestController
public class BookApiController {

	private static final Logger LOGGER = Logger.getLogger(BookApiController.class);
	
	@Autowired
	private IBookService bookService;

	/**
	 * The process of this method is to retrieve all books which are exist in the system.
	 * @return bookList : Json Object list 
	 */
	@RequestMapping(value = "/getBookList", method = RequestMethod.GET)
	
	public ResponseEntity<List<Book>> getAllBook() {
		LOGGER.debug("getBookList method start");
		List<Book> bookList=new ArrayList<Book>();
		try {
			bookList = bookService.getAllBooks();
		} catch (BookServiceException ex) {
			LOGGER.error(ex.getCustomeMsg());
			return new ResponseEntity<List<Book>>(bookList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.debug("getBookList method end");
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
	
	/**
	 * The process of this method is to ceate or update book according to book param.
	 * @param book : A Json Object
	 * @return A String Value of process status.
	 */
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		LOGGER.debug("addBook method start");
		try {
			String response="";
			response = bookService.updateBook(book);
			LOGGER.debug("addBook method end");
			return new ResponseEntity<String>(response,HttpStatus.OK);
		} catch (BookServiceException ex) {
			LOGGER.error(ex.getCustomeMsg());
			return new ResponseEntity<String>(ex.getCustomeMsg(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
