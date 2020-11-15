package com.miniproject.booksapi.service;

import java.util.List;

import com.miniproject.booksapi.model.Author;
import com.miniproject.booksapi.model.Book;

public interface AuthorService {

	public List<Author> getAllAuthors(); //list of authors
	
	public void addAuthor(Author author); //create new author
	
	public Author getAuthorById(Integer authorId); //author by id
	
	public void updateAuthor(Integer authorId,Author author);  //update author
	
	public void deleteAuthor(Integer authorId);  //delete author
	

}
