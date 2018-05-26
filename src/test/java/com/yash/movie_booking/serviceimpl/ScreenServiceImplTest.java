package com.yash.movie_booking.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.exception.SizeExceededExeption;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.service.ScreenService;

public class ScreenServiceImplTest {
	private Movie movie;
	private Seat seat;
	List<String> listOfActors = new ArrayList<String>();
	private Show show;
	private Screen screen;

	@Before
	public void executeBeforeEach() {
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		show = new Show(1, new Date(), 3);
		movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		seat = new Seat("G-12", "Gold", 400);
		screen = new Screen(1, "AUDI-2", movie, seat, show);
	}

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnOne() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		when(screenDAO.insert(screen)).thenReturn(1);
		int rowsAffected = screenService.add(screen);
		assertEquals(1, rowsAffected);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = NullObjectProvidedException.class)
	public void addScreen_ScreenObjectGiven_ThrowExceptionIfScreenObjectIsNull() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		when(screenDAO.insert(screen)).thenThrow(NullObjectProvidedException.class);
		screenService.add(screen);

	}

	@SuppressWarnings("unchecked")
	@Test(expected = AlreadyExistsException.class)
	public void addScreen_ScreenObjectGiven_ThrowExceptionIfScreenObjectIsAlreadyExists() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		when(screenDAO.getByName(screen.getScreenName())).thenThrow(AlreadyExistsException.class);
		screenService.add(screen);

	}

	@SuppressWarnings("unchecked")
	@Test(expected = SizeExceededExeption.class)
	public void addScreen_ScreenObjectGiven_ThrowExceptionIfScreenSizeIsMoreThanThree() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		when(screenDAO.getId(screen.getScreenId())).thenThrow(SizeExceededExeption.class);
		screenService.add(screen);

	}

}
