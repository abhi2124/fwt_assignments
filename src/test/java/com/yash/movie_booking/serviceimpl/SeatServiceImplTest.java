package com.yash.movie_booking.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.yash.movie_booking.dao.SeatDAO;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.service.SeatService;

public class SeatServiceImplTest {

	@Test
	public void addSeat_SeatObjectGiven_ShouldReturnOne() {
		SeatDAO seatDAO = mock(SeatDAO.class);
		SeatService seatService = new SeatServiceImpl(seatDAO);
		Seat seat = new Seat("G12", "Gold", 500);
		when(seatDAO.insert(seat)).thenReturn(1);
		int rowsAffected = seatService.add(seat);
		assertEquals(1, rowsAffected);
	}

}
