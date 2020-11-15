package com.miniproject.booksapi.service;

import java.util.List;

import com.miniproject.booksapi.model.Author;
import com.miniproject.booksapi.model.Book;
import com.miniproject.booksapi.model.Review;

public interface BookService {
	
	List<Book> getAllBooks(); //list all books
	
	void addBook(Book book);  //create new book

	Book getBookByIsbn(Integer isbn);  //book by isbn
	
	void updateBook(Integer isbn,Book book);  // update the book

	void deleteBook(Integer isbn); //delete book
	
    List<Book> getBookByAuthorName(String authorName); //get book by author


	//List<Book> getBookByPriceRange(Integer min, Integer max);

	//List<Review> getAllReviews(String isbn);
	 
}
