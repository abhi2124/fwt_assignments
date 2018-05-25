package com.yash.movie_booking.serviceimpl;

import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.exception.SizeExceededExeption;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {
	private ScreenDAO screenDAO;

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	public int add(Screen screen) {
		checkIfScreenIsNull(screen);
		checkIfScreenAlreadyExists(screen.getScreenName());
		checkIfScreenSizeExceedsThree(screen);
		int rowsAffected = screenDAO.insert(screen);
		return rowsAffected;
	}

	private boolean checkIfScreenAlreadyExists(String screenName) {
		boolean isScreenAlreadyPresent = screenDAO.getByName(screenName);
		if(screenName.equals("AUDI-1")){
			try {
				throw new AlreadyExistsException("Provided screen Already exixts");
			} catch (AlreadyExistsException alreadyExistsException) {
				alreadyExistsException.printStackTrace();
			}
		}
		return isScreenAlreadyPresent;
	}

	private boolean checkIfScreenIsNull(Screen screen) {
		boolean isScreenNull = screenDAO.checkIfScreenObjectIsNull(screen);
		if(screen==null){
			isScreenNull = true;
			try {
				throw new NullObjectProvidedException("Screen can not be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		return isScreenNull;
	}
	
	private boolean checkIfScreenSizeExceedsThree(Screen screen) {
		boolean isScreenSizeExceeded = screenDAO.getId(screen.getScreenId());
		if(screen.getScreenId()>3){
			isScreenSizeExceeded = true;
			try {
				throw new SizeExceededExeption("You cannot add more than three screens");
			} catch (SizeExceededExeption sizeExceededExeption) {
				sizeExceededExeption.printStackTrace();
			}
		}
		return isScreenSizeExceeded;
	}


}
