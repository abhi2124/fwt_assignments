package com.yash.movie_booking.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.util.FileUtil;

public class ScreenDAOImplTest {
	private Movie movie;
	private Seat seat;
	List<String> listOfActors = new ArrayList<String>();
	private Show show;
	private Screen screen;
	private FileUtil fileUtil;
	private ScreenDAO screenDAO;

	@Before
	public void executeBeforeEach() {
		listOfActors.add("Salman Khan");
		listOfActors.add("Kareena Kapoor");
		fileUtil = new FileUtil();
		show = new Show(1, new Date(), 3);
		movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
		seat = new Seat("G-12", "Gold", 400);
		screen = new Screen(2, "AUDI-3", movie, seat, show);
		screenDAO = new ScreenDAOImpl(fileUtil);
	}

	@Test
	public void insert_ScreenObjectGiven_ShouldReturnOne() {
		int rowsAffected = screenDAO.insert(screen);
		assertEquals(1, rowsAffected);
	}

	@Test
	public void checkIfScreenObjectIsNull_ScreenObjectGiven_ShouldReturnFalseIfObjectIsNotNull() {
	boolean isScreenNull = screenDAO.checkIfScreenObjectIsNull(screen);
	assertFalse(isScreenNull);
	}
	
	@Test
	public void getByName_ScreenObjectGiven_ShouldReturnFalseIfScreenAlreadyExists() {
		String screenName = "AUDI-1";
		boolean isScreenFound = screenDAO.getByName(screenName);
		assertFalse(isScreenFound);
	}


}
