package com.yash.movie_booking.exception;

@SuppressWarnings("serial")
public class EmptyFieldException extends Exception{
	public EmptyFieldException(String msg) {
		super(msg);
	}
}
