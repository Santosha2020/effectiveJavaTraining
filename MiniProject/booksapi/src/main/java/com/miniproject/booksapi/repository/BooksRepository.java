package com.miniproject.booksapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.booksapi.model.Author;
import com.miniproject.booksapi.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

	List<Book> findByAuthorName(String authorName);


	//List<Book> findByPriceBetween(Integer min, Integer max);


}
	