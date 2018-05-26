package com.yash.movie_booking.daoimpl;

import com.yash.movie_booking.dao.MovieDAO;
import com.yash.movie_booking.pojo.Movie;
import com.yash.movie_booking.util.FileUtil;
import com.yash.movie_booking.util.JsonUtil;

public class MovieDAOImpl extends JsonUtil implements MovieDAO {
	private FileUtil fileUtil;
	
	public MovieDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}
	public int insert(Movie movie) {
		String objectToBeWritten = convertToJson(movie);
		fileUtil.writeToFile(objectToBeWritten, "movie");
		return 1;
	}

	public boolean checkIfObjectIsNull(Movie movie) {
		boolean isMovieObjectEmpty = fileUtil.checkEmptyFile("movie");
		return isMovieObjectEmpty;
	}

	public boolean getByName(String movieName) {
		boolean isMovieAlreadyPresent = fileUtil.getStringInFile(movieName,"movie");
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
