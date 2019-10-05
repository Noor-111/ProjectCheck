package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>{
	//custom methods
	@Query("select m from Movie m")
	List<Movie> getAllMovies();
	
	
	@Query("SELECT m from Movie m where  m.genre = :gen")
	List<Movie> getByGenre(String gen);

}
