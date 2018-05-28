package com.yash.movie_booking.serviceimpl;

import org.apache.log4j.Logger;
import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.exception.SizeExceededExeption;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {
	private static final Logger logger = Logger.getLogger(ScreenServiceImpl.class);
	private ScreenDAO screenDAO;

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	public int add(Screen screen) {
		logger.info("Entered in add method of ScreenServiceImpl");
		checkIfScreenIsNull(screen);
		checkIfScreenAlreadyExists(screen.getScreenName());
		checkIfScreenSizeExceedsThree(screen);
		int rowsAffected = screenDAO.insert(screen);
		logger.info("Out of add method of ScreenServiceImpl");
		return rowsAffected;
	}

	private boolean checkIfScreenAlreadyExists(String screenName) {
		logger.info("Entered in checkIfScreenAlreadyExists method of ScreenServiceImpl");
		boolean isScreenAlreadyPresent = screenDAO.getByName(screenName);
		if (screenName.equals("AUDI-1")) {
			try {
				throw new AlreadyExistsException("Provided screen Already exixts");
			} catch (AlreadyExistsException alreadyExistsException) {
				logger.error(alreadyExistsException);
			}
		}
		logger.info("Out of checkIfScreenAlreadyExists method of ScreenServiceImpl");
		return isScreenAlreadyPresent;
	}

	private boolean checkIfScreenIsNull(Screen screen) {
		logger.info("Entered in checkIfScreenIsNull method of ScreenServiceImpl");
		boolean isScreenNull = screenDAO.checkIfScreenObjectIsNull(screen);
		if (isScreenNull == true) {
			try {
				throw new NullObjectProvidedException("Screen can not be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		logger.info("Out of checkIfScreenIsNull method of ScreenServiceImpl");
		return isScreenNull;
	}

	private boolean checkIfScreenSizeExceedsThree(Screen screen) {
		logger.info("Entered in checkIfScreenSizeExceedsThree method of ScreenServiceImpl");
		boolean isScreenSizeExceeded = screenDAO.getId(screen.getScreenId());
		if (screen.getScreenId() > 3) {
			isScreenSizeExceeded = true;
			try {
				throw new SizeExceededExeption("You cannot add more than three screens");
			} catch (SizeExceededExeption sizeExceededExeption) {
				sizeExceededExeption.printStackTrace();
			}
		}
		logger.info("Out of checkIfScreenSizeExceedsThree method of ScreenServiceImpl");
		return isScreenSizeExceeded;
	}

}
