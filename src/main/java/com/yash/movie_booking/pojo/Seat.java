package com.yash.movie_booking.pojo;

public class Seat {
	private String seatNo;
	private String seatCategory;
	private Integer seatPrice;



	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getSeatCategory() {
		return seatCategory;
	}

	public void setSeatCategory(String seatCategory) {
		this.seatCategory = seatCategory;
	}

	public Integer getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(Integer seatPrice) {
		this.seatPrice = seatPrice;
	}

	public Seat(String seatNo, String seatCategory, Integer seatPrice) {
		super();
		this.seatNo = seatNo;
		this.seatCategory = seatCategory;
		this.seatPrice = seatPrice;
	}

	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", seatCategory=" + seatCategory + ", seatPrice=" + seatPrice + "]";
	}

}
