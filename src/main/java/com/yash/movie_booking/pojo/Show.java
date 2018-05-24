package com.yash.movie_booking.pojo;

import java.util.Date;

public class Show {
	private Integer showId;
	private Date showDateTime;
	private Integer duration;
	

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Date getShowDateTime() {
		return showDateTime;
	}

	public void setShowDateTime(Date showDateTime) {
		this.showDateTime = showDateTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}



	public Show(Integer showId, Date showDateTime, Integer duration) {
		super();
		this.showId = showId;
		this.showDateTime = showDateTime;
		this.duration = duration;
		
	}
	
	public Show() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showDateTime=" + showDateTime + ", duration=" + duration  + "]";
	}

}
