package com.yash.movie_booking.dao;

import com.yash.movie_booking.pojo.Show;

public interface ShowDAO {

	int insert(Show show);

	boolean checkForNull(Show show);

	boolean getId(Integer showId);

}
