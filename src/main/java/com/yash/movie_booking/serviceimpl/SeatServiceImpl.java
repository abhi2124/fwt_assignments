package com.yash.movie_booking.serviceimpl;

import com.yash.movie_booking.dao.SeatDAO;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.service.SeatService;

public class SeatServiceImpl implements SeatService {
	private SeatDAO seatDAO;

	public SeatServiceImpl(SeatDAO seatDAO) {
		this.seatDAO = seatDAO;
	}

	public int add(Seat seat) {
		int rowsAffected = seatDAO.insert(seat);
		return rowsAffected;
	}

}
