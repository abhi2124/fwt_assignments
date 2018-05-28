package com.yash.movie_booking.menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.daoimpl.MovieDAOImpl;
import com.yash.movie_booking.daoimpl.ScreenDAOImpl;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.pojo.Seat;
import com.yash.movie_booking.pojo.Show;
import com.yash.movie_booking.service.ScreenService;
import com.yash.movie_booking.serviceimpl.ScreenServiceImpl;
import com.yash.movie_booking.util.FileUtil;

public class Menu {
	FileUtil fileUtil = new FileUtil();

	public void menu() {
		fileUtil.readFromFile("menu");
	}

	public void menuChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		List<String> listOfActors = new ArrayList<String>();

		switch (choice) {

		case 1:

			ScreenDAO screenDAO = new ScreenDAOImpl(fileUtil);
			ScreenService screenService = new ScreenServiceImpl(screenDAO);
			listOfActors.add("Salman Khan");
			listOfActors.add("Kareena Kapoor");
			Show show = new Show(1, new Date(), 3);
			Movie movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
			Seat seat = new Seat("G-12", "Gold", 400);
			Screen screen = new Screen(1, "AUDI-2", movie, seat, show);
			screenService.add(screen);

		case 2:
			MovieDAO movieDAO = new MovieDAOImpl(fileUtil);
			listOfActors.add("Salman Khan");
			listOfActors.add("Kareena Kapoor");
			show = new Show(1, new Date(), 3);
			movie = new Movie(1, "Race", show, 3, listOfActors, "Dharma Production");
			movieDAO.insert(movie);

		}

	}
}
