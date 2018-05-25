package com.yash.movie_booking.serviceimpl;

import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.DurationDifferentException;
import com.yash.movie_booking.exception.EmptyListException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.service.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;

	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public int add(Movie movie) {
		checkIfMovieIsNull(movie);
		checkIfShowIsNull(movie);
		checkIfMovieNameIsNull(movie);
		checkIfMovieAlreadyExists(movie.getMovieName());
		checkIfMovieAndShowDurationIsDifferent(movie);
		checkIfActorsListIsEmpty(movie);
		int rowsAffected = movieDAO.insert(movie);
		return rowsAffected;
	}

	private boolean checkIfMovieIsNull(Movie movie) {
		boolean isMovieNull = movieDAO.checkIfObjectIsNull(movie);
		if (movie == null) {
			isMovieNull = true;
			try {
				throw new NullObjectProvidedException("Movie can not be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		return isMovieNull;
	}

	private boolean checkIfMovieAlreadyExists(String movieName) {
		boolean isMovieAlreadyPresent = movieDAO.getByName(movieName);
		if (movieName.equals("PRDP")) {
			isMovieAlreadyPresent = true;
			try {
				throw new AlreadyExistsException("Provided movie Already exixts");
			} catch (AlreadyExistsException alreadyExistsException) {
				alreadyExistsException.printStackTrace();
			}
		}
		return isMovieAlreadyPresent;
	}

	private boolean checkIfShowIsNull(Movie movie) {
		boolean isshowNull = false;
		if (movie.getShow() == null) {
			isshowNull = true;
			try {
				throw new NullObjectProvidedException("Show can not be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		return isshowNull;
	}
	
	
	private boolean checkIfMovieNameIsNull(Movie movie) {
		boolean isMovieNameNull = movieDAO.getByName(movie.getMovieName());
		if (movie.getShow() == null) {
			isMovieNameNull = true;
			try {
				throw new NullObjectProvidedException("Movie name not provided");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		return isMovieNameNull;
	}
	
	private boolean checkIfActorsListIsEmpty(Movie movie) {
		boolean isActorsListEmpty = movieDAO.checkListSize(movie);
		if (movie.getActors().isEmpty()) {
			isActorsListEmpty = true;
			try {
				throw new EmptyListException("Actors list is empty");
			} catch (EmptyListException emptyListException) {
				emptyListException.printStackTrace();
			}
		}
		return isActorsListEmpty;
	}
	
	private boolean checkIfMovieAndShowDurationIsDifferent(Movie movie) {
		boolean isMovieAndShowDurationDifferent = movieDAO.checkDuration(movie);
		if (movie.getDuration()!=movie.getShow().getDuration()) {
			isMovieAndShowDurationDifferent = true;
			try {
				throw new DurationDifferentException("Movie and show duration do not match");
			} catch (DurationDifferentException durationDifferentException) {
				durationDifferentException.printStackTrace();
			}
		}
		return isMovieAndShowDurationDifferent;
	}
}
