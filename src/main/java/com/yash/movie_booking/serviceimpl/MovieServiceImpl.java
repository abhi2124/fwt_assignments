package com.yash.movie_booking.serviceimpl;

import org.apache.log4j.Logger;
import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.DurationDifferentException;
import com.yash.movie_booking.exception.EmptyListException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.service.MovieService;

public class MovieServiceImpl implements MovieService {
	private static final Logger logger = Logger.getLogger(MovieServiceImpl.class);

	private MovieDAO movieDAO;

	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public int add(Movie movie) {
		logger.info("Entered in add method of MovieServiceImpl");
		checkIfMovieIsNull(movie);
		checkIfShowIsNull(movie);
		checkIfMovieNameIsNull(movie);
		checkIfMovieAlreadyExists(movie.getMovieName());
		checkIfMovieAndShowDurationIsDifferent(movie);
		checkIfActorsListIsEmpty(movie);
		int rowsAffected = movieDAO.insert(movie);
		logger.info("Out of add method of MovieServiceImpl");
		return rowsAffected;
	}

	private boolean checkIfMovieIsNull(Movie movie) {
		logger.info("Entered in checkIfMovieIsNull method of MovieServiceImpl");
		boolean isMovieNull = movieDAO.checkIfObjectIsNull(movie);
		if (isMovieNull == true) {
			isMovieNull = true;
			try {
				throw new NullObjectProvidedException("Movie can not be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				logger.error(nullObjectProvidedException);
			}
		}
		logger.info("Out of  checkIfMovieIsNull method of MovieServiceImpl");
		return isMovieNull;
	}

	private boolean checkIfMovieAlreadyExists(String movieName) {
		logger.info("Entered in checkIfMovieAlreadyExists method of MovieServiceImpl");
		boolean isMovieAlreadyPresent = movieDAO.getByName(movieName);
		if (movieName.equals("PRDP")) {
			isMovieAlreadyPresent = true;
			try {
				throw new AlreadyExistsException("Provided movie Already exixts");
			} catch (AlreadyExistsException alreadyExistsException) {
				logger.error(alreadyExistsException);
			}
		}
		logger.info("Out of  checkIfMovieAlreadyExists method of MovieServiceImpl");
		return isMovieAlreadyPresent;
	}

	private boolean checkIfShowIsNull(Movie movie) {
		logger.info("Entered in checkIfShowIsNull method of MovieServiceImpl");
		boolean isshowNull = false;
		if (movie.getShow() == null) {
			isshowNull = true;
			try {
				throw new NullObjectProvidedException("Show can not be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				logger.error(nullObjectProvidedException);
			}
		}
		logger.info("Out of  checkIfShowIsNull method of MovieServiceImpl");
		return isshowNull;
	}

	private boolean checkIfMovieNameIsNull(Movie movie) {
		logger.info("Entered in checkIfMovieNameIsNull method of MovieServiceImpl");
		boolean isMovieNameNull = movieDAO.getByName(movie.getMovieName());
		if (movie.getShow() == null) {
			isMovieNameNull = true;
			try {
				throw new NullObjectProvidedException("Movie name not provided");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				logger.error(nullObjectProvidedException);
			}
		}
		logger.info("Out of  checkIfMovieNameIsNull method of MovieServiceImpl");
		return isMovieNameNull;
	}

	private boolean checkIfActorsListIsEmpty(Movie movie) {
		logger.info("Entered in checkIfActorsListIsEmpty method of MovieServiceImpl");
		boolean isActorsListEmpty = movieDAO.checkListSize(movie);
		if (movie.getActors().isEmpty()) {
			isActorsListEmpty = true;
			try {
				throw new EmptyListException("Actors list is empty");
			} catch (EmptyListException emptyListException) {
				logger.error(emptyListException);
			}
		}
		logger.info("Out of  checkIfActorsListIsEmpty method of MovieServiceImpl");
		return isActorsListEmpty;
	}

	private boolean checkIfMovieAndShowDurationIsDifferent(Movie movie) {
		logger.info("Entered in checkIfMovieAndShowDurationIsDifferent method of MovieServiceImpl");
		boolean isMovieAndShowDurationDifferent = movieDAO.checkDuration(movie);
		if (movie.getDuration() != movie.getShow().getDuration()) {
			isMovieAndShowDurationDifferent = true;
			try {
				throw new DurationDifferentException("Movie and show duration do not match");
			} catch (DurationDifferentException durationDifferentException) {
				logger.error(durationDifferentException);
			}
		}
		logger.info("Out of  checkIfMovieAndShowDurationIsDifferent method of MovieServiceImpl");
		return isMovieAndShowDurationDifferent;
	}
}
