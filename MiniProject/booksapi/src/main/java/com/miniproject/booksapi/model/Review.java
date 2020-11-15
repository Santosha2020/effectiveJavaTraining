package com.miniproject.booksapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "review_id")
	Integer reviewId;//primary key

	@Column(name = "reviewer")
	String reviewer;
	
	@Column(name = "review")
	String review;
	
	@Column(name = "rating")
	Integer rating;
	
	@ManyToOne
	@JoinColumn(name = "book_pk",  insertable = false, updatable = false)//book_pk
	//@ManyToOne(targetEntity = Book.class)
	Book books; 

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Book getBooks() {
		return books;
	}

	public void setBooks(Book books) {
		this.books = books;
	}

	public Review(Integer reviewId, String reviewer, String review, Integer rating, Book books) {
		super();
		this.reviewId = reviewId;
		this.reviewer = reviewer;
		this.review = review;
		this.rating = rating;
		this.books = books;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}



}
