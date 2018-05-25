package com.yash.movie_booking.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnOne() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		Seat seat = new Seat("G-12", "Gold", 400);
		Screen screen = new Screen(1, "AUDI-2", movie, seat, show);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		when(screenDAO.insert(screen)).thenReturn(1);
		int rowsAffected = screenService.add(screen);
		assertEquals(1, rowsAffected);
	}
	
	@Test(expected = NullObjectProvidedException.class)
	public void addScreen_ScreenObjectGiven_ThrowExceptionIfScreenObjectIsNull() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		Seat seat = new Seat("G-12", "Gold", 400);
		Screen screen = new Screen(1, "AUDI-2", movie, seat, show);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		when(screenDAO.insert(screen)).thenThrow(NullObjectProvidedException.class);
		screenService.add(screen);
		
	}
	
	@Test(expected = AlreadyExistsException.class)
	public void addScreen_ScreenObjectGiven_ThrowExceptionIfScreenObjectIsAlreadyExists() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		Seat seat = new Seat("G-12", "Gold", 400);
		Screen screen = new Screen(1, "AUDI-2", movie, seat, show);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		when(screenDAO.getByName(screen.getScreenName())).thenThrow(AlreadyExistsException.class);
		screenService.add(screen);
		
	}

	@Test(expected = SizeExceededExeption.class)
	public void addScreen_ScreenObjectGiven_ThrowExceptionIfScreenSizeIsMoreThanThree() {
		ScreenDAO screenDAO = mock(ScreenDAO.class);
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		Seat seat = new Seat("G-12", "Gold", 400);
		Screen screen = new Screen(3, "AUDI-2", movie, seat, show);
		when(screenDAO.getId(screen.getScreenId())).thenThrow(SizeExceededExeption.class);
		screenService.add(screen);
		
	}
	
	


}
