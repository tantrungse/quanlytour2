package com.myclass.dto;

public class HopDongDTO {
	private String maHD;
	private String ngayLap;
	private String noiDung;
	private String maTour;
	
	public HopDongDTO() {}

	public HopDongDTO(String maHD, String ngayLap, String noiDung, String maTour) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.noiDung = noiDung;
		this.maTour = maTour;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getMaTour() {
		return maTour;
	}

	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	
}
