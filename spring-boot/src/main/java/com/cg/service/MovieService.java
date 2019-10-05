package com.cg.service;

import java.util.List;

import com.cg.entity.Movie;

public interface MovieService {
	
	Movie save(Movie movie);
	
	Movie fetch(int id) throws InvalidMovieException;
	
	List<Movie> getAll();
	
	boolean delete(int id) throws InvalidMovieException;

	Movie update(Movie movie);
	
	List<Movie> findByGenre(String gen);
	
	

}
