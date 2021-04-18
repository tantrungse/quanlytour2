package com.myclass.dto;

public class HuongDanVienDTO {
	private String maNV;
	private String hoTenNV;
	private String ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	private String maDoan;
	
	public HuongDanVienDTO() {}

	public HuongDanVienDTO(String maNV, String hoTenNV, String ngaySinh, String gioiTinh, String diaChi, String sdt,
			String maDoan) {
		super();
		this.maNV = maNV;
		this.hoTenNV = hoTenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.maDoan = maDoan;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTenNV;
	}

	public void setHoTen(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMaDoan() {
		return maDoan;
	}

	public void setMaDoan(String maDoan) {
		this.maDoan = maDoan;
	}
	
}
