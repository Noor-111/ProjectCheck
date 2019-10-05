package com.cg.repo;

import java.util.List;

import com.cg.entity.Movie;
import com.cg.service.InvalidMovieException;

public interface MovieDao {
Movie save(Movie movie);
	
	Movie fetch(int id) throws InvalidMovieException;
	
	List<Movie> getAll();
	
	boolean delete(int id) throws InvalidMovieException;

	Movie update(Movie movie);
	
	List<Movie> findByGenre(String gen);

}
