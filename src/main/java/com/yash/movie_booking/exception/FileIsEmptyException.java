package com.yash.movie_booking.exception;

@SuppressWarnings("serial")
public class FileIsEmptyException extends Exception {
	public FileIsEmptyException(String msg) {
		super(msg);
	}
}
