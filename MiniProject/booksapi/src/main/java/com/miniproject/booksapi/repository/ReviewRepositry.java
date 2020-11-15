package com.miniproject.booksapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.booksapi.model.Book;
import com.miniproject.booksapi.model.Review;

@Repository
public interface ReviewRepositry extends JpaRepository<Review, Integer> {

	List<Review> findByRatingBetween(int min, int max);

	List<Review> findByReviewContainingIgnoreCase(String text);

	//List<Review> findByBookIsbn(Integer isbn);



}
