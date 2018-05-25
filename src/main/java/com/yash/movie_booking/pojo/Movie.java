package com.yash.movie_booking.pojo;

import java.util.List;

public class Movie {
	private Integer movieId;
	private String movieName;
	private Show show;
	private Integer duration;
	private List<String> actors;
	private String production;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
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

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public Movie(Integer movieId, String movieName, Show show, Integer duration, List<String> actors,
			String production) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.show = show;
		this.duration = duration;
		this.actors = actors;
		this.production = production;
	}

}
