package com.yash.movie_booking.dao;

import com.yash.movie_booking.pojo.Screen;

public interface ScreenDAO {

	int insert(Screen screen);

	int checkIfScreenObjectIsNull(Screen screen);

	String getName(String screenName);

}
