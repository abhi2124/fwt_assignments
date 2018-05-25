package com.yash.movie_booking.pojo;

import java.util.Date;

public class Show {
	private Integer showId;
	private Date date;
	private Integer duration;

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Show(Integer showId, Date date,  Integer duration) {
		super();
		this.showId = showId;
		this.date = date;
	
		this.duration = duration;
	}

	public Show() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", date=" + date + ", duration=" + duration + "]";
	}

}
