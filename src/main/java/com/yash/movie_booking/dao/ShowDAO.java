package com.yash.movie_booking.dao;

import com.yash.movie_booking.pojo.Show;

public interface ShowDAO {

	int insert(Show show);

	int checkForNull(Show show);

	int getById(Integer showId);

}
