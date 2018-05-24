package com.yash.movie_booking.pojo;

public class Movie {
	private Integer movieId;
	private Show show;
	private Integer duration;
	private String actors;
	private String production;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}



	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public Movie(Integer movieId, Show show, Integer duration, String actors, String production) {
		super();
		this.movieId = movieId;
		this.show = show;
		this.duration = duration;
		this.actors = actors;
		this.production = production;
	}
	
	

}
