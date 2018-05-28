package com.yash.movie_booking.daoimpl;

import com.yash.movie_booking.dao.ScreenDAO;
import com.yash.movie_booking.pojo.Screen;
import com.yash.movie_booking.util.FileUtil;
import com.yash.movie_booking.util.JsonUtil;

public class ScreenDAOImpl extends JsonUtil implements ScreenDAO {
	private FileUtil fileUtil;

	public ScreenDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public int insert(Screen screen) {

		String dataToBeWrittenInFile = convertToJson(screen);
		fileUtil.writeToFile(dataToBeWrittenInFile, "screen");
		return 1;
	}

	public boolean checkIfScreenObjectIsNull(Screen screen) {
		boolean isScreenObjectEmpty = fileUtil.checkEmptyFile("screen");
		return isScreenObjectEmpty;
	}

	public boolean getByName(String screenName) {
		boolean isScreenAlreadyPresent = fileUtil.getStringInFile(screenName, "screen");
		return isScreenAlreadyPresent;
	}

	public boolean getId(Integer screenId) {
		String idToSearch = screenId.toString();
		boolean isScreenSizeExceeded = fileUtil.getStringInFile(idToSearch, "screen");
		return isScreenSizeExceeded;
	}

}
