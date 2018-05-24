package com.yash.movie_booking.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;

import com.yash.movie_booking.dao.ShowDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.service.ShowService;

public class ShowServiceImplTest {

	@Test
	public void addShow_ShowObjectGiven_ShouldReturnOne() {
		ShowDAO showDAO = mock(ShowDAO.class);
		ShowService showService = new ShowServiceImpl(showDAO);
		Show show = new Show(1, new Date(), 3);
		when(showDAO.insert(show)).thenReturn(1);
		int rowsAffected = showService.add(show);
		assertEquals(1, rowsAffected);
	}

	@Test(expected = NullObjectProvidedException.class)
	public void checkIfShowObjectIsNull_ShowObjectGiven_ThrowExceptionIfShowObjectIsNull() throws NullObjectProvidedException {
		ShowDAO showDAO = mock(ShowDAO.class);
		ShowService showService = new ShowServiceImpl(showDAO);
		Show show = null;
		when(showDAO.checkForNull(show)).thenThrow(NullObjectProvidedException.class);
		showService.checkIfShowObjectIsNull(show);
	}
	
	@Test(expected = AlreadyExistsException.class)
	public void checkIfShowObjectAlreadyExists_ShowObjectGiven_ThrowExceptionIfShowObjectIsAlreadyPresent() throws AlreadyExistsException {
		ShowDAO showDAO = mock(ShowDAO.class);
		ShowService showService = new ShowServiceImpl(showDAO);
		Show show = new Show();
		show.setShowId(1);
		Integer showId = show.getShowId();
		when(showDAO.getById(showId)).thenThrow(AlreadyExistsException.class);
		showService.checkIfShowObjectAlredyExists(showId);
	}
	
	

}
