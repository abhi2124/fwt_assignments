package com.yash.movie_booking.service;

import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Show;

public interface ShowService {

	int add(Show show);

	int checkIfShowObjectIsNull(Show show) throws NullObjectProvidedException;

	int checkIfShowObjectAlredyExists(Integer showId) throws AlreadyExistsException;

}
