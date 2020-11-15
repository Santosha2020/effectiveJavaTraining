
package com.miniproject.booksapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "author_id")
	Integer authorId;// primary key
	
	@Column(name = "name")
	String name;
	
	@Column(name = "biography")
	String biography;
	
	@Column(name = "photograph")
	String photograph;

	//@OneToMany
	//@JoinColumn(name = "book_fk",  insertable = false, updatable = false)
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL)  //isbn
	List<Book> books;

	

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPhotograph() {
		return photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(Integer authorId, String name, String biography, String photograph, List<Book> books) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.biography = biography;
		this.photograph = photograph;
		this.books = books;
	}
	
}
