package com.yash.movie_booking.util;

import com.google.gson.Gson;

public class JsonUtil {

	public static String convertToJson(Object object) {
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
	}
}
