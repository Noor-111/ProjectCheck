package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity

@Table(name="movies")
@SequenceGenerator(name="moseq", sequenceName = "seq_movie", allocationSize = 1)
@NamedQuery(name = "allMovies",query = "Select m from Movie m")
@NamedQuery(name = "byGenre",query = "Select m from Movie m where m.genre = :gen ")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "moseq")
	private int id;
	
	@Column(length = 20)
	private  String title;
	
	@Column(length = 20)
	private String genre;
	
	
	@Column
	private int rating;


	//getters setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
