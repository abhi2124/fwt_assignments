package com.yash.movie_booking.serviceimpl;

import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {
	private ScreenDAO screenDAO;

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	public int add(Screen screen) {
		int rowsAffected = screenDAO.insert(screen);
		return rowsAffected;
	}

	public int checkIfScreenObjectIsNull(Screen screen) throws NullObjectProvidedException {
		
		return screenDAO.checkIfScreenObjectIsNull(screen);
	}

	public String getScreenName(String screenName) throws AlreadyExistsException {
		
		return screenDAO.getName(screenName);
	}

	public String getScreenName(Screen screen) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

}
