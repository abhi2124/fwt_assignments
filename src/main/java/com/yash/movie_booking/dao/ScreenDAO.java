package com.yash.movie_booking.dao;

import com.yash.movie_booking.pojo.Screen;

public interface ScreenDAO {

	int insert(Screen screen);

	int checkIfScreenObjectIsNull(Screen screen);

	boolean getByName(String screenName);


	boolean getId(Integer screenId);

}
