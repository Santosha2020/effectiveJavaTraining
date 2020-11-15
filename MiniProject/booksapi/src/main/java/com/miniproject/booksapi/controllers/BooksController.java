package com.miniproject.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.booksapi.model.Author;
import com.miniproject.booksapi.model.Book;
import com.miniproject.booksapi.service.BookService;

@RestController
//@RequestMapping("/api/books")
public class BooksController {

    @Autowired 
    BookService service;
	
	
	@GetMapping("/api/books")
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	@PostMapping(value="/api/books", consumes = "application/json")
	public Book addBook(@RequestBody Book book) {
		service.addBook(book);		
		return book;
	}
	
	@GetMapping("/api/books/{isbn}")
	public Book getBookById(@PathVariable Integer isbn) {
		return service.getBookByIsbn(isbn);
	}

	@PutMapping("/api/books/{isbn}")
	public Book updateTheBook(@PathVariable Integer isbn,@RequestBody Book book) {
		service.updateBook(isbn,book);
		return book;
	}
	
	@DeleteMapping("/api/books/{isbn}")
    public void delete(@PathVariable Integer isbn) {
		service.deleteBook(isbn);
    }
	
	
	@GetMapping("/api/books/by/{authorName}")
	public List<Book> getBooksByAuthor(@PathVariable("authorName") String authorName) {
		return service.getBookByAuthorName(authorName);
	}
	
}
