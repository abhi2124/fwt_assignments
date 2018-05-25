package com.yash.movie_booking.dao;

import com.yash.movie_booking.pojo.Movie;

public interface MovieDAO {

	int insert(Movie movie);

	boolean checkIfObjectIsNull(Movie movie);

	boolean getByName(String movieName);

	boolean checkListSize(Movie movie);

	boolean checkDuration(Movie movie);

}
