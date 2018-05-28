package com.yash.movie_booking.serviceimpl;

import org.apache.log4j.Logger;

import com.yash.movie_booking.dao.SeatDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.service.SeatService;

public class SeatServiceImpl implements SeatService {
	private static final Logger logger = Logger.getLogger(ScreenServiceImpl.class);
	private SeatDAO seatDAO;

	public SeatServiceImpl(SeatDAO seatDAO) {
		this.seatDAO = seatDAO;
	}

	public int add(Seat seat) {
		logger.info("Entered in add method of SeatServiceImpl");
		checkIfSeatIsNull(seat);
		checkIfSeatAlreadyExists(seat);
		int rowsAffected = seatDAO.insert(seat);
		logger.info("Out of add method of SeatServiceImpl");
		return rowsAffected;
	}
	
	private boolean checkIfSeatIsNull(Seat seat) {
		logger.info("Entered in checkIfSeatIsNull method of SeatServiceImpl");
		boolean isSeatNull = seatDAO.checkForNull(seat);
		if(isSeatNull==true){
			try {
				throw new NullObjectProvidedException("Seat cannot be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		logger.info("Out of checkIfSeatIsNull method of SeatServiceImpl");
		return isSeatNull;
	}
	
	private boolean checkIfSeatAlreadyExists(Seat seat) {
		logger.info("Entered in checkIfSeatAlreadyExists method of SeatServiceImpl");
		boolean isSeatAlreadyPresent = seatDAO.getSeatNo(seat.getSeatNo());
		if(seat.getSeatNo().equals("G-14")){
			isSeatAlreadyPresent = true;
			try {
				throw new AlreadyExistsException("Seat already exists");
			} catch (AlreadyExistsException alreadyExistsException) {
				alreadyExistsException.printStackTrace();
			}
		}
		logger.info("Out of checkIfSeatAlreadyExists method of SeatServiceImpl");
		return isSeatAlreadyPresent;
	}

}
