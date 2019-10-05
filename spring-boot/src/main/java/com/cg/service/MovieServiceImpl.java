package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Movie;
import com.cg.repo.MovieRepo;


@Service
@Transactional(rollbackFor = InvalidMovieException.class)
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepo repo;

	@Override
	public Movie save(Movie movie) {

		return repo.save(movie);
	}

	@Override
	public Movie fetch(int id) throws InvalidMovieException {
		try {
			return repo.findById(id).get();
		} catch (Exception e) {
			throw new InvalidMovieException("Invalid Movie ID: "+id);
		}
	}

	@Override
	public List<Movie> getAll() {

		//return repo.findAll();
		return repo.getAllMovies();
	}

	@Override
	public boolean delete(int id) throws InvalidMovieException {

	  try {
		repo.deleteById(id);
			return true;
	} catch (Exception e) {
		throw new InvalidMovieException("Could Not find Movie Object to Delete");
	}
	}

	@Override
	public Movie update(Movie movie) {
		return repo.save(movie);
		
	}

	@Override
	public List<Movie> findByGenre(String gen) {
		return repo.getByGenre(gen);
	}

}
