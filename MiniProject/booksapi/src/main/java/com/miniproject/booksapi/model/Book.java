package com.miniproject.booksapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "isbn")
	Integer isbn;// primary key

	@Column(name = "title")
	String title;

	@Column(name = "description")
	String description;

	@Column(name = "tag")
	String tag;

	@Column(name = "cover")
	String cover;

	@ManyToOne
	// @JoinColumn(name = "author_pk", insertable = false, updatable = false)
	@OneToOne
	@JoinColumn(name = "author_pk")
	Author author;

	//@OneToMany
	//@JoinColumn(name = "review_id", insertable = false, updatable = false)
	@OneToMany(mappedBy = "books")
	List<Review> reviews;

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	
	public Book(Integer isbn, String title, String description, String tag, String cover, Author author,
			List<Review> reviews) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.tag = tag;
		this.cover = cover;
		this.author = author;
		this.reviews = reviews;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

}
