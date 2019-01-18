package com.java.book.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.book.Util.ApplicationConstant;
import com.java.book.Util.CommonUtils;
import com.java.book.Util.Storage;
import com.java.book.exception.BookServiceException;
import com.java.book.model.Book;
import com.java.book.services.IBookService;

/**
 * The process of this call to handle all of books related service.
 * @author Parthiban Subramanian
 *
 */
@Service(value = "BookServiceImp")
public class BookServiceImp implements IBookService {

	private static final Logger LOGGER = Logger.getLogger(BookServiceImp.class);

	/**
	 * The process of this method is to initialized Book data when the project is started.
	 */
	@PostConstruct
	public void initializedBooks() throws BookServiceException {
		LOGGER.debug("initializedBooks method start");
		HashMap<String, Book> bookBox = Storage.bookStorage;
		for(Book b : getExistingBookList()) {
			bookBox.put(b.getBookId(), b);
		}
		LOGGER.debug("initializedBooks method End");
	}

	/**
	 * The process of the method is to retrieve all books data with exist in the system.
	 */
	public List<Book> getAllBooks() throws BookServiceException {
		LOGGER.debug("getAllBooks method start");
		return new ArrayList<Book>(Storage.bookStorage.values());
	}
	
	/**
	 * The process of the method is to populate books init data.
	 * @return
	 */
	private List<Book> getExistingBookList() {
		LOGGER.debug("getExistingBookList method start");
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book(CommonUtils.getUniqueId(), "Here Comes Trouble", 1, "Biography & Autobiography", true,
				"Michael Moore catapults readers along a revealing journey through his early life.");
		Book book2 = new Book(CommonUtils.getUniqueId(), "Spillover: Animal Infections and the Next Human Pandemic", 1, "Science & Nature", true, "Unpredictable. Unforgiving. Untamed.\r\n" + 
				"Another inconvenient truth? You don't read an intense, uncompromising Science book like Spillover because you're looking for something to lull you to sleep at night");
		Book book3 = new Book(CommonUtils.getUniqueId(), "Eat & Run: My Unlikely Journey to Ultramarathon Greatness", 2, "Sports & Recreation ", false, "What an ultramarathon man eats. When it comes to long-distance running, Scott Jurek wrote the book – well, obviously! He was previously profiled in Christopher McDougall's bestselling Sports book, Born to Run, which details Jurek's triumphant experiences as an ultramarathoner.");
		Book book4 = new Book(CommonUtils.getUniqueId(), "	Acclaimed authors and enduring characters. ", 3, "Fiction", true, "Dive into the latest from Toni Morrison to Haruki Murikami to Margaret Atwood. While their works of literary fiction may be very different, these critically lauded authors share an uncanny ability to serve up complex, absorbing novels that are rich and multilayered");
		Book book5 = new Book(CommonUtils.getUniqueId(), "A dog and an American dream", 1, "Travel", false, "Let's say you're John Steinbeck and it's 1960. You've already entered the ranks of the literary immortals and created classic pieces of Americana back in the '30s with your novels Grapes of Wrath and Of Mice and Men");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		bookList.add(book5);
		LOGGER.debug("getExistingBookList method End");
		return bookList;
	}

	/**
	 * The process of this method is to create or update books data.
	 */
	public String updateBook(Book book) throws BookServiceException {
		LOGGER.debug("updateBook method start");
		HashMap<String, Book> bookBox = Storage.bookStorage;
		bookDataValidation(book);
		if(StringUtils.isBlank(book.getBookId())) {
			book.setBookId(CommonUtils.getUniqueId());
			bookBox.put(book.getBookId().trim(), book);
			LOGGER.debug("updateBook method end");
			return ApplicationConstant.SUCCESS_SAVE;
		}
		else {
			if(bookBox.containsKey(book.getBookId())) {
				bookBox.put(book.getBookId().trim(), book);
				LOGGER.debug("updateBook method end");
				return ApplicationConstant.SUCCESS_UPDAGE;
			}
			else {
				LOGGER.error("Book id does not exist.");
				throw new BookServiceException("Book id does not exist.");
			}	
		}

	}
	
	/**
	 * The process of this method is to validate books data.
	 * @param book
	 * @throws BookServiceException
	 */
	private void bookDataValidation(Book book) throws BookServiceException {
		if(StringUtils.isBlank(book.getBookTitle())) {
			LOGGER.error("Book title cannot be blank");
			throw new BookServiceException("Book title cannot be blank");
		}
		if(StringUtils.isBlank(book.getCategory())) {
			LOGGER.error("Book category cannot be blank");
			throw new BookServiceException("Book category cannot be blank");
		}
		if(StringUtils.isBlank(book.getDescription())) {
			LOGGER.error("Book description cannot be blank");
			throw new BookServiceException("Book description cannot be blank");
		}
	}

}
