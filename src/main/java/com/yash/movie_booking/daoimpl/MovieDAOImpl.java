package com.yash.movie_booking.daoimpl;

import org.apache.log4j.Logger;

import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.serviceimpl.MovieServiceImpl;
import com.yash.movie_booking.util.FileUtil;
import com.yash.movie_booking.util.JsonUtil;

public class MovieDAOImpl extends JsonUtil implements MovieDAO {
	private static final Logger logger = Logger.getLogger(MovieDAOImpl.class);

	private FileUtil fileUtil;
	
	public MovieDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}
	public int insert(Movie movie) {
		logger.info("Entered in insert method of MovieDAOImpl");
		String objectToBeWritten = convertToJson(movie);
		fileUtil.writeToFile(objectToBeWritten, "movie");
		logger.info("Out of insert method of MovieDAOImpl");

		return 1;
	}

	public boolean checkIfObjectIsNull(Movie movie) {
		logger.info("Entered in checkIfObjectIsNull method of MovieDAOImpl");
		boolean isMovieObjectEmpty = fileUtil.checkEmptyFile("movie");
		logger.info("Out of checkIfObjectIsNull method of MovieDAOImpl");
		return isMovieObjectEmpty;
	}

	public boolean getByName(String movieName) {
		logger.info("Entered in getByName method of MovieDAOImpl");
		boolean isMovieAlreadyPresent = fileUtil.getStringInFile(movieName,"movie");
		logger.info("Out of getByName method of MovieDAOImpl");
		return isMovieAlreadyPresent;
	}

	public boolean checkListSize(Movie movie) {
		
		return false;
	}

	public boolean checkDuration(Movie movie) {
		// TODO Auto-generated method stub
		return false;
	}

}
