package com.miniproject.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.booksapi.model.Review;
import com.miniproject.booksapi.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/api/reviews")
	public List<Review> getAllReviews(){
		return reviewService.getAllReviews();
	}
	
	@PostMapping("/api/reviews/{isbn}")
	public void addReview(@PathVariable Integer isbn,@RequestBody Review review){
		reviewService.addNewReview(isbn, review);
	}
	
	@GetMapping("/api/reviews/{isbn}")
	public List<Review> getReviewsByIsbn(@PathVariable Integer isbn){
		return reviewService.getAllReviewsForReviewId(isbn);
	}
	
	@GetMapping("/api/reviews/rating-between/{min}/and/{max}")
	public List<Review> getRatingBetweenRange(@PathVariable Integer min, @PathVariable Integer max){
		return reviewService.getBooksInRatingRange(min, max);
	}
	
	@GetMapping("/api/reviews/containing/{text}")
	public List<Review> getReviewContainingText(@PathVariable String text){
		return reviewService.getReviewContainingText(text);
	}

}
