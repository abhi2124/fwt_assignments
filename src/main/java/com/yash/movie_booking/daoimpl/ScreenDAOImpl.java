package com.yash.movie_booking.daoimpl;

import org.apache.log4j.Logger;

import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.exception.AlreadyExistsException;
import com.yash.movie_booking.exception.NullObjectProvidedException;
import com.yash.movie_booking.exception.SizeExceededExeption;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.serviceimpl.MovieServiceImpl;
import com.yash.movie_booking.util.FileUtil;
import com.yash.movie_booking.util.JsonUtil;

public class ScreenDAOImpl extends JsonUtil implements ScreenDAO {
	private static final Logger logger = Logger.getLogger(MovieServiceImpl.class);

	private FileUtil fileUtil;

	public ScreenDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public int insert(Screen screen) {
		logger.info("Entered in insert method of ScreenDAOImpl");
		String dataToBeWrittenInFile = convertToJson(screen);
		fileUtil.writeToFile(dataToBeWrittenInFile, "screen");
		logger.info("Out of insert method of ScreenDAOImpl");
		return 1;
	}

	public boolean checkIfScreenObjectIsNull(Screen screen) {
		logger.info("Entered in checkIfScreenObjectIsNull method of ScreenDAOImpl");
		boolean isScreenObjectEmpty = fileUtil.checkEmptyFile("screen");
		logger.info("Out of checkIfScreenObjectIsNull method of ScreenDAOImpl");
		return isScreenObjectEmpty;
	}

	public boolean getByName(String screenName) {
		logger.info("Entered in getByName method of ScreenDAOImpl");
		boolean isScreenAlreadyPresent = fileUtil.getStringInFile(screenName, "screen");
		logger.info("Out of getByName method of ScreenDAOImpl");
		return isScreenAlreadyPresent;
	}

	public boolean getId(Integer screenId) {
		logger.info("Entered in getId method of ScreenDAOImpl");
		String idToSearch = screenId.toString();
		boolean isScreenSizeExceeded = fileUtil.getStringInFile(idToSearch, "screen");
		logger.info("Out of getId method of ScreenDAOImpl");
		return isScreenSizeExceeded;
	}

}
