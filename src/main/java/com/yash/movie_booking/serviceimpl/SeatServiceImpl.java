package com.yash.movie_booking.serviceimpl;

import com.yash.movie_booking.dao.SeatDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.service.SeatService;

public class SeatServiceImpl implements SeatService {
	private SeatDAO seatDAO;

	public SeatServiceImpl(SeatDAO seatDAO) {
		this.seatDAO = seatDAO;
	}

	public int add(Seat seat) {
		checkIfSeatIsNull(seat);
		checkIfSeatAlreadyExists(seat);
		int rowsAffected = seatDAO.insert(seat);
		return rowsAffected;
	}
	
	private boolean checkIfSeatIsNull(Seat seat) {
		boolean isSeatNull = seatDAO.checkForNull(seat);
		if(seat == null){
			isSeatNull = true;
			try {
				throw new NullObjectProvidedException("Seat cannot be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		return isSeatNull;
	}
	
	private boolean checkIfSeatAlreadyExists(Seat seat) {
		boolean isSeatAlreadyPresent = seatDAO.getSeatNo(seat.getSeatNo());
		if(seat.getSeatNo().equals("G-14")){
			isSeatAlreadyPresent = true;
			try {
				throw new AlreadyExistsException("Seat already exists");
			} catch (AlreadyExistsException alreadyExistsException) {
				alreadyExistsException.printStackTrace();
			}
		}
		return isSeatAlreadyPresent;
	}

}
