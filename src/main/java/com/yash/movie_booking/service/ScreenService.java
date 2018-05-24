package com.yash.movie_booking.service;

import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.pojo.Screen;

public interface ScreenService {

	int add(Screen screen);

	int checkIfScreenObjectIsNull(Screen screen) throws NullObjectProvidedException;

	String getScreenName(String screenName) throws AlreadyExistsException;
}
