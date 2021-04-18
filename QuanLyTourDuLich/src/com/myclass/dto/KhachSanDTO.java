package com.myclass.dto;

public class KhachSanDTO {
	private String maKhachSan;
	private String tenKhachSan;
	private String diaChi;
	private String chiPhiTrenNguoi;
	
	public KhachSanDTO() {}

	public KhachSanDTO(String maKhachSan, String tenKhachSan, String diaChi, String chiPhiTrenNguoi) {
		super();
		this.maKhachSan = maKhachSan;
		this.tenKhachSan = tenKhachSan;
		this.diaChi = diaChi;
		this.chiPhiTrenNguoi = chiPhiTrenNguoi;
	}

	public String getMaKhachSan() {
		return maKhachSan;
	}

	public void setMaKhachSan(String maKhachSan) {
		this.maKhachSan = maKhachSan;
	}

	public String getTenKhachSan() {
		return tenKhachSan;
	}

	public void setTenKhachSan(String tenKhachSan) {
		this.tenKhachSan = tenKhachSan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getChiPhiTrenNguoi() {
		return chiPhiTrenNguoi;
	}

	public void setChiPhiTrenNguoi(String chiPhiTrenNguoi) {
		this.chiPhiTrenNguoi = chiPhiTrenNguoi;
	}
	
}
