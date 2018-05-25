package com.yash.movie_booking.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.DurationDifferentException;
import com.yash.movie_booking.exception.EmptyListException;
import com.yash.movie_booking.exception.NoNameProvidedException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.service.MovieService;

public class MovieServiceImplTest {

	

	@Test
	public void addMovie_MovieObjectGiven_ShouldReturnOne() {
		
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		when(movieDAO.insert(movie)).thenReturn(1);
		int rowsAffected = movieService.add(movie);
		assertEquals(1, rowsAffected);
	}

	@Test(expected = NullObjectProvidedException.class)
	public void addMovie_MovieObjectGiven_ThrowExceptionIfMovieObjectIsNull() {
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		when(movieDAO.checkIfObjectIsNull(movie)).thenThrow(NullObjectProvidedException.class);
		movieService.add(movie);
	}

	@Test(expected = AlreadyExistsException.class)
	public void addMovie_MovieObjectGiven_ThrowExceptionIfMovieObjectAlreadyExists() {
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		when(movieDAO.getByName(movie.getMovieName())).thenThrow(AlreadyExistsException.class);
		movieService.add(movie);
	}

	@Test(expected = NullObjectProvidedException.class)
	public void addMovie_MovieObjectGiven_ThrowExceptionIfShowObjectIsNull() {
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		Show show = null;
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		when(movieDAO.checkIfObjectIsNull(movie)).thenThrow(NullObjectProvidedException.class);
		movieService.add(movie);
	}

	@Test(expected = NoNameProvidedException.class)
	public void addMovie_MovieObjectGiven_ThrowExceptionIfMovieNameIsNull() {
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		when(movieDAO.getByName(movie.getMovieName())).thenThrow(NoNameProvidedException.class);
		movieService.add(movie);
	}

	@Test(expected = EmptyListException.class)
	public void addMovie_MovieObjectGiven_ThrowExceptionIfActorsListIsEmpty() {
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		when(movieDAO.checkListSize(movie)).thenThrow(EmptyListException.class);
		movieService.add(movie);
	}
	
	@Test(expected = DurationDifferentException.class)
	public void addMovie_MovieObjectGiven_ThrowExceptionIfMovieDuartionAndShowDurationIsDifferent() {
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		Show show = new Show(1, new Date(), 3);
		List<String> listOfActors = new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		when(movieDAO.checkDuration(movie)).thenThrow(DurationDifferentException.class);
		movieService.add(movie);
	}
	

}
