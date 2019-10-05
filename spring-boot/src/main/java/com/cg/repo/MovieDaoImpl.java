package com.cg.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.Movie;
//import com.cg.entity.Product;
import com.cg.service.InvalidMovieException;


@Repository
public class MovieDaoImpl implements MovieDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public Movie save(Movie movie) {
		 mgr.persist(movie);
		 return movie;
	}

	@Override
	public Movie fetch(int id) throws InvalidMovieException {
		Movie m = (Movie) mgr.find(Movie.class, id);
		if(m==null)
				throw new InvalidMovieException("Invalid Movie ID");
		return m;
	}

	@Override
	public List<Movie> getAll() {
		TypedQuery<Movie> query =
				mgr.createNamedQuery("findAll", Movie.class);
		List<Movie> results = query.getResultList();
		return results;
	}

	@Override
	public boolean delete(int id) throws InvalidMovieException {
		Movie m = mgr.find(Movie.class, id);
		if(m==null)
				throw new InvalidMovieException("Invalid movie ID, cannot Delete.");
		mgr.remove(m);
		return true;
	}

	@Override
	public Movie update(Movie movie) {
		return mgr.merge(movie);
	}

	@Override
	public List<Movie> findByGenre(String gen) {
		
		return mgr.createNamedQuery("byGenre").setParameter("gen",gen).getResultList();
		
		
	}

}
