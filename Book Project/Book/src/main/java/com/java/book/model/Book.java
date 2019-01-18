package com.java.book.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book implements Serializable {

	private static final long serialVersionUID = -7356553156596519690L;

	private String bookId;
	private String bookTitle;
	private Integer edition;
	private String category;
	private Boolean isBestSeller;
	private String description;

	@JsonCreator
	public Book(@JsonProperty("bookId")String bookId, @JsonProperty("bookTitle")String bookTitle, @JsonProperty("edition")Integer edition, 
			@JsonProperty("category")String category, @JsonProperty("isBestSeller")Boolean isBestSeller,
			@JsonProperty("description")String description) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.edition = edition;
		this.category = category;
		this.isBestSeller = isBestSeller;
		this.description = description;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getIsBestSeller() {
		return isBestSeller;
	}

	public void setIsBestSeller(Boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
