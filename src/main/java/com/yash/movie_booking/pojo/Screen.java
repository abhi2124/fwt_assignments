package com.yash.movie_booking.pojo;

public class Screen {
	private Integer screenId;
	private String screenName;
	private Movie movie;
	private Seat seat;
	private Show show;
	
	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + "]";
	}

	public Screen(Integer screenId, String screenName, Movie movie, Seat seat, Show show) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.movie = movie;
		this.seat = seat;
		this.show = show;
	}

	public Screen() {
		// TODO Auto-generated constructor stub
	}

}
