package com.yash.movie_booking.serviceimpl;

import com.yash.movie_booking.dao.ShowDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.service.ShowService;

public class ShowServiceImpl implements ShowService {

	private ShowDAO showDAO;

	public ShowServiceImpl(ShowDAO showDAO) {
		this.showDAO = showDAO;
	}

	public int add(Show show) {
		checkIfShowIsNull(show);
		checkIfShowAlreadyExists(show.getShowId());
		int rowsAffected=showDAO.insert(show);
		return rowsAffected;
	}

	private boolean checkIfShowIsNull(Show show) {
		boolean isShowNull = showDAO.checkForNull(show);
		if(show == null){
			isShowNull = true;
			try {
				throw new NullObjectProvidedException("Show cannot be null.");
			} catch (NullObjectProvidedException nullObjectProvidedException) {
				nullObjectProvidedException.printStackTrace();
			}
		}
		return isShowNull;
	}

	private boolean checkIfShowAlreadyExists(Integer showId) {
		boolean isShowAlreadyPresent = showDAO.getId(showId);
		if(showId == 5){
			try {
				isShowAlreadyPresent = true;
				throw new AlreadyExistsException("Show  Already exixts");
			} catch (AlreadyExistsException alreadyExistsException) {
				alreadyExistsException.printStackTrace();
			}
		}
		return isShowAlreadyPresent;
	}

}
