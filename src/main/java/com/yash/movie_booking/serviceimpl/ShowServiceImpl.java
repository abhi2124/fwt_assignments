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
		int rowsAffected=showDAO.insert(show);
		return rowsAffected;
	}

	public int checkIfShowObjectIsNull(Show show) throws NullObjectProvidedException{
		return showDAO.checkForNull(show);
	}

	public int checkIfShowObjectAlredyExists(Integer showId) throws AlreadyExistsException{
	
		return showDAO.getById(showId);
	}
	
	

}
