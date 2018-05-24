package com.yash.movie_booking.exception;

@SuppressWarnings("serial")
public class AlreadyExistsException extends Exception {
	public AlreadyExistsException(String msg) {
		super(msg);
	}
}
