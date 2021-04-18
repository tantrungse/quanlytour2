package com.myclass.dto;

public class KeHoachTourDTO {
	private String maKeHoach;
	private String ngayBatDau;
	private String ngayKetThuc;
	private int soNgay;
	private String maTour;
	private String maCTKH;
	
	public KeHoachTourDTO() {}

	public KeHoachTourDTO(String maKeHoach, String ngayBatDau, String ngayKetThuc, int soNgay, String maTour,
			String maCTKH) {
		super();
		this.maKeHoach = maKeHoach;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.soNgay = soNgay;
		this.maTour = maTour;
		this.maCTKH = maCTKH;
	}

	public String getMaKeHoach() {
		return maKeHoach;
	}

	public void setMaKeHoach(String maKeHoach) {
		this.maKeHoach = maKeHoach;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	public String getMaTour() {
		return maTour;
	}

	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}

	public String getMaCTKH() {
		return maCTKH;
	}

	public void setMaCTKH(String maCTKH) {
		this.maCTKH = maCTKH;
	}
	
}
