package com.yash.movie_booking.serviceimpl;

import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.service.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;

	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public int add(Movie movie) {
		int rowsAffected = movieDAO.insert(movie);
		return rowsAffected;
	}

}
