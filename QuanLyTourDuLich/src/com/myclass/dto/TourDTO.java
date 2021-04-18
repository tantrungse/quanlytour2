package com.myclass.dto;

public class TourDTO {
	private String maTour;
	private String tenTour;
	private double giaVe;
	private String maKHTour;
	
	public TourDTO() {}
	
	public TourDTO(String maTour, String tenTour, double giaVe, String maKHTour) {
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.giaVe = giaVe;
		this.maKHTour = maKHTour;
	}

	public String getMaTour() {
		return maTour;
	}

	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}

	public String getTenTour() {
		return tenTour;
	}

	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}

	public double getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}

	public String getMaKHTour() {
		return maKHTour;
	}

	public void setMaKHTour(String maKHTour) {
		this.maKHTour = maKHTour;
	}
	
}
