package com.yash.movie_booking.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.service.ScreenService;

public class ScreenServiceImplTest {

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnOne() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		Show show = new Show(1, new Date(), 3);
		Movie movie = new Movie(1, show, 3, "Salman Khan", "Dharma Production");
		Seat seat = new Seat("G-12", "Gold", 400);
		Screen screen = new Screen(1, "AUDI-1", movie, seat, show);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		when(screenDAO.insert(screen)).thenReturn(1);
		int rowsAffected = screenService.add(screen);
		assertEquals(1, rowsAffected);
	}

	@Test(expected = NullObjectProvidedException.class)
	public void checkIfScreenObjectIsNull_ScreenObjectGiven_ThrowExceptionIfScreenObjectIsNull()
			throws NullObjectProvidedException {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		Screen screen = null;
		when(screenDAO.checkIfScreenObjectIsNull(screen)).thenThrow(NullObjectProvidedException.class);
		screenService.checkIfScreenObjectIsNull(screen);
	}

	@Test(expected = AlreadyExistsException.class)
	public void getScreenName_ScreenObjectGiven_ThrowExceptionIfScreenAlreadyExists()
			throws AlreadyExistsException {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		Screen screen = new Screen();
		screen.setScreenName("AUDI-1");
		String screenName = screen.getScreenName();
		when(screenDAO.getName(screenName)).thenThrow(AlreadyExistsException.class);
		screenService.getScreenName(screenName);

	}

}
