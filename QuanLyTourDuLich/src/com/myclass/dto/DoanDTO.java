package com.myclass.dto;

public class DoanDTO {
	private String maDoan;
	private int soNguoi;
	private String maHuongDanVien;
	private String maTour;
	
	public DoanDTO() {}

	public DoanDTO(String maDoan, int soNguoi, String maHuongDanVien, String maTour) {
		super();
		this.maDoan = maDoan;
		this.soNguoi = soNguoi;
		this.maHuongDanVien = maHuongDanVien;
		this.maTour = maTour;
	}

	public String getMaDoan() {
		return maDoan;
	}

	public void setMaDoan(String maDoan) {
		this.maDoan = maDoan;
	}

	public int getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}

	public String getMaHuongDanVien() {
		return maHuongDanVien;
	}

	public void setMaHuongDanVien(String maHuongDanVien) {
		this.maHuongDanVien = maHuongDanVien;
	}

	public String getMaTour() {
		return maTour;
	}

	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	
}
