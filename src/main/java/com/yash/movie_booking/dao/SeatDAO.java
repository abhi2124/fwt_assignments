package com.yash.movie_booking.dao;

import com.yash.movie_booking.pojo.Seat;

public interface SeatDAO {

	int insert(Seat seat);

	boolean checkForNull(Seat seat);

	boolean getSeatNo(String seatNo);

}
