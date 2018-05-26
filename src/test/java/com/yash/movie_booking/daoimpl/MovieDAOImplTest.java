package com.yash.movie_booking.daoimpl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.util.FileUtil;

public class MovieDAOImplTest {
	private Movie movie;
	private FileUtil fileUtil;
	List<String> listOfActors ;
	private Show show;
	private MovieDAO movieDAO;

	@Before
	public void executeBeforeEach() {
		listOfActors= new ArrayList<String>();
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		fileUtil = new FileUtil();
		show = new Show(1, new Date(), 3);
		movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		movieDAO = new MovieDAOImpl(fileUtil);
	}

	@Test
	public void addMovie_MovieObjectGiven_ShouldReturnOne() {
		int rowsAffected = movieDAO.insert(movie);
		assertEquals(1, rowsAffected);
	}

	@Test
	public void checkIfScreenObjectIsNull_ScreenObjectGiven_ShouldReturnFalseIfObjectIsNotNull() {
		boolean isMovieNull = movieDAO.checkIfObjectIsNull(movie);
		assertFalse(isMovieNull);
	}

	@Test
	public void getByName_MovieObjectGiven_ShouldReturnFalseIfMovieAlreadyExists() {
		String movieName = "Raazi";
		boolean isMovieFound = movieDAO.getByName(movieName);
		assertFalse(isMovieFound);
	}

}
