package com.yash.movie_booking.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.yash.movie_booking.dao.SeatDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.service.SeatService;

	public class SeatServiceImplTest {
		private Seat seat;
	@Before
	public void executeBeforeEach() {
		seat = new Seat("G12", "Gold", 500);
	}

	@Test
	public void addSeat_SeatObjectGiven_ShouldReturnOne() {
		SeatDAO seatDAO = mock(SeatDAO.class);
		SeatService seatService = new SeatServiceImpl(seatDAO);
		when(seatDAO.insert(seat)).thenReturn(1);
		int rowsAffected = seatService.add(seat);
		assertEquals(1, rowsAffected);
	}

	@Test(expected = NullObjectProvidedException.class)
	public void addSeat_SeatObjectGiven_ThrowExceptionIfSeatObjectIsNull() {
		SeatDAO seatDAO = mock(SeatDAO.class);
		SeatService seatService = new SeatServiceImpl(seatDAO);
		when(seatDAO.checkForNull(seat)).thenThrow(NullObjectProvidedException.class);
		seatService.add(seat);
	}

	@Test(expected = AlreadyExistsException.class)
	public void addSeat_SeatObjectGiven_ThrowExceptionIfSeatObjectAlreadyExists() {
		SeatDAO seatDAO = mock(SeatDAO.class);
		SeatService seatService = new SeatServiceImpl(seatDAO);
		when(seatDAO.getSeatNo(seat.getSeatNo())).thenThrow(AlreadyExistsException.class);
		seatService.add(seat);
	}

}
