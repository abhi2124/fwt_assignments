package com.yash.movie_booking.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;

import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.service.MovieService;

public class MovieServiceImplTest {

	@Test
	public void addMovie_MovieObjectGiven_ShouldReturnOne() {
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		Show show = new Show(1, new Date(), 3);
		Movie movie = new Movie(1, show, 3, "Salman Khan", "Dharma Production");
		when(movieDAO.insert(movie)).thenReturn(1);
		int rowsAffected = movieService.add(movie);
		assertEquals(1, rowsAffected);
	}

}
