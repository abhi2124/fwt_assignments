package com.yash.movie_booking.serviceimpl;

import org.apache.log4j.Logger;

import com.yash.movie_booking.dao.ShowDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.service.ShowService;

public class ShowServiceImpl implements ShowService {
	private static final Logger logger = Logger.getLogger(ScreenServiceImpl.class);

	private ShowDAO showDAO;

	public ShowServiceImpl(ShowDAO showDAO) {
		this.showDAO = showDAO;
	}

	public int add(Show show) {
		logger.info("Entered in add method of ShowServiceImpl");
		checkIfShowIsNull(show);
		checkIfShowAlreadyExists(show.getShowId());
		int rowsAffected = showDAO.insert(show);
		logger.info("Out of add method of ShowServiceImpl");
		return rowsAffected;
	}

	private boolean checkIfShowIsNull(Show show) {
		logger.info("Entered in checkIfShowIsNull method of ShowServiceImpl");
		boolean isShowNull = showDAO.checkForNull(show);

		if (isShowNull == true) {
			isShowNull = true;
			try {
				throw new NullObjectProvidedException("Show cannot be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		logger.info("Out of checkIfShowIsNull method of ShowServiceImpl");
		return isShowNull;
	}

	private boolean checkIfShowAlreadyExists(Integer showId) {
		logger.info("Entered in checkIfShowAlreadyExists method of ShowServiceImpl");

		boolean isShowAlreadyPresent = showDAO.getId(showId);
		if (showId == 5) {
			try {
				isShowAlreadyPresent = true;
				throw new AlreadyExistsException("Show  Already exixts");
			} catch (AlreadyExistsException alreadyExistsException) {
				alreadyExistsException.printStackTrace();
			}
		}
		logger.info("Out of checkIfShowAlreadyExists method of ShowServiceImpl");

		return isShowAlreadyPresent;
	}

}
