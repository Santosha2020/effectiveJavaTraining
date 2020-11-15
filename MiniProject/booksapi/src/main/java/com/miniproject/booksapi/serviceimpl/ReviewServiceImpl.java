package com.miniproject.booksapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.booksapi.model.Book;
import com.miniproject.booksapi.model.Review;
import com.miniproject.booksapi.repository.BooksRepository;
import com.miniproject.booksapi.repository.ReviewRepositry;
import com.miniproject.booksapi.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepositry reviewRepository;
	
	@Autowired
	BooksRepository bookRepository;
	
	@Override
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	@Override
	public void addNewReview(Integer isbn,Review review) {
		Book existingBook=bookRepository.findById(isbn).orElse(null);
		if(existingBook==null)
			return; 
		review.setBooks(existingBook);
		reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReviewsForReviewId(Integer isbn) {
		return (List<Review>) reviewRepository.findById(isbn).orElse(null);
	}

	@Override
	public List<Review> getBooksInRatingRange(int min, int max) {
		return reviewRepository.findByRatingBetween(min,max);
	}
  
	@Override
	public List<Review> getReviewContainingText(String text) {
		return reviewRepository.findByReviewContainingIgnoreCase(text);
	}
	
}
