CREATE SCHEMA IF NOT EXISTS quanlytourdulich CHARACTER SET utf8 COLLATE utf8_bin ;
USE quanlytourdulich;

-- TaiKhoan(TenTK, MatKhau, Quyen)
CREATE TABLE IF NOT EXISTS TaiKhoan (
	TenTK VARCHAR(30) NOT NULL,
    MatKhau VARCHAR(30) NOT NULL,
    Quyen INT NOT NULL, -- 0:Admin , 1:NhanVien
    PRIMARY KEY (TenTK)
);

-- HuongDanVien (MaNV, HoNV, TenNV, NgaySinh, GioiTinh, DiaChi, SDT, MaDoan)
CREATE TABLE IF NOT EXISTS HuongDanVien (
	MaHDV VARCHAR(10) NOT NULL,
    Ho VARCHAR(10) NOT NULL,
    Ten VARCHAR(30) NOT NULL,
    NgaySinh DATE NOT NULL,
    GioiTinh VARCHAR(10),
    DiaChi TEXT,
    SDT VARCHAR(20),
    PRIMARY KEY (MaHDV)
);
ALTER TABLE HuongDanVien ADD MaDoan VARCHAR(10) NOT NULL;

-- Doan (MaDoan, SoNguoi, MaHuongDanVien, MaTour)
CREATE TABLE IF NOT EXISTS Doan (
	MaDoan VARCHAR(10) NOT NULL,
	SoNguoi INT,
    PRIMARY KEY (MaDoan)
);
ALTER TABLE Doan ADD MaHuongDanVien VARCHAR(10) NOT NULL;
ALTER TABLE Doan ADD MaTour VARCHAR(10) NOT NULL;

-- KhachHang (MaKH, HoKH, TenKH, DiaChi, SDT, MaDoan)
CREATE TABLE IF NOT EXISTS KhachHang (
	MaKH VARCHAR(10) NOT NULL,
	HoKH VARCHAR(30),
	TenKH VARCHAR(30),
    DiaChi TEXT,
    SDT VARCHAR(11),
    PRIMARY KEY (MaKH)
);
ALTER TABLE KhachHang ADD MaDoan VARCHAR(10) NOT NULL;

-- HopDong (MaHD, NgayLapHD, NoiDung, MaTour)
CREATE TABLE IF NOT EXISTS HopDong (
	MaHD VARCHAR(10) NOT NULL,
    NgayLapHD DATE,
	NoiDung TEXT,
    -- ThanhTien --
    PRIMARY KEY (MaHD)
);
ALTER TABLE HopDong ADD MaTour VARCHAR(10) NOT NULL;
ALTER TABLE HopDong Drop MaTour;

-- Tour (MaTour, TenTour, GiaVe, MaKHTour)
CREATE TABLE IF NOT EXISTS Tour (
	MaTour VARCHAR(10) NOT NULL,
    TenTour VARCHAR(50),
    GiaVe DOUBLE,
    PRIMARY KEY (MaTour)
);
ALTER TABLE Tour ADD MaKHTour VARCHAR(10) NOT NULL;
ALTER TABLE Tour ADD MaHD VARCHAR(10) NOT NULL;
ALTER TABLE Tour ADD TenTK VARCHAR(30) NOT NULL;

-- KeHoachTour (MaKeHoach, NgayBatDau, NgayKetThuc, SoNgay, MaTour, MaCTKH)
CREATE TABLE IF NOT EXISTS KeHoachTour (
	MaKeHoach VARCHAR(10) NOT NULL,
	NgayBatDau DATE,
    NgayKetThuc DATE,
    SoNgay INT,
    PRIMARY KEY (MaKeHoach)
);
ALTER TABLE KeHoachTour ADD MaCTKH VARCHAR(10) NOT NULL;
ALTER TABLE KeHoachTour DROP SoNgay;

-- CTKeHoachTour (MaCTKeHoach, KeHoachTheoNgay(list), MaPhuongTien, MaNhaHang, MaKhachSan, MaDiaDiemThamQuan, MaCTThuChi)
CREATE TABLE IF NOT EXISTS CTKeHoachTour (
	MaCTKeHoach VARCHAR(10) NOT NULL,
    PRIMARY KEY (MaCTKeHoach)
);
ALTER TABLE CTKeHoachTour ADD MaPhuongTien VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoachTour ADD MaNhaHang VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoachTour ADD MaKhachSan VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoachTour ADD MaDiaDiemThamQuan VARCHAR(10) NOT NULL;
ALTER TABLE CTKeHoachTour ADD MaCTThuChi VARCHAR(10) NOT NULL;

-- DiaDiemThamQuan (MaDiaDiem, TenDiaDiem, NoiDung(list), DiaChi)
CREATE TABLE IF NOT EXISTS DiaDiemThamQuan (
	MaDiaDiem VARCHAR(10) NOT NULL,
    TenDiaDiem VARCHAR(50),
    DiaChi TEXT,
    PRIMARY KEY (MaDiaDiem)
);

-- PhuongTien (MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
CREATE TABLE IF NOT EXISTS PhuongTien (
	MaPhuongTien VARCHAR(10) NOT NULL,
    TenPhuongTien VARCHAR(50),
    ChiPhi DOUBLE,
    SoChoNgoi INT,
    PRIMARY KEY (MaPhuongTien)
);

-- NhaHang (MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
CREATE TABLE IF NOT EXISTS NhaHang (
	MaNhaHang VARCHAR(10) NOT NULL,
    TenNhaHang VARCHAR(50),
    DiaChi TEXT,
    ChiPhiTrenNguoi DOUBLE,
    PRIMARY KEY (MaNhaHang)
);

-- KhachSan (MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
CREATE TABLE IF NOT EXISTS KhachSan (
	MaKhachSan VARCHAR(10) NOT NULL,
    TenKhachSan VARCHAR(50),
    DiaChi TEXT,
    ChiPhiTrenNguoi DOUBLE,
    PRIMARY KEY (MaKhachSan)
);

-- CTThuChi (MaCTThuChi, TongThu, TongChi, DoanThu, MaCTKH)
CREATE TABLE IF NOT EXISTS CTThuChi (
	MaCTThuChi VARCHAR(10) NOT NULL,
	TongThu DOUBLE,
    TongChi DOUBLE,
    DoanhThu DOUBLE,
    PRIMARY KEY (MaCTThuChi)
);

-- TAO KHOA NGOAI    
ALTER TABLE HuongDanVien ADD CONSTRAINT fk_HuongDanVien_Doan
	FOREIGN KEY (MaDoan) REFERENCES Doan(MaDoan);

ALTER TABLE Doan ADD CONSTRAINT fk_Doan_Tour
	FOREIGN KEY (MaTour) REFERENCES Tour(MaTour);

ALTER TABLE KhachHang ADD CONSTRAINT fk_KhachHang_Doan
	FOREIGN KEY (MaDoan) REFERENCES Doan(MaDoan);
    
ALTER TABLE HopDong ADD CONSTRAINT fk_HopDong_Tour
	FOREIGN KEY (MaTour) REFERENCES Tour(MaTour);
ALTER TABLE HopDong DROP FOREIGN KEY fk_HopDong_Tour;
    
ALTER TABLE Tour ADD CONSTRAINT fk_Tour_KeHoachTour
	FOREIGN KEY (MaKHTour) REFERENCES KeHoachTour(MaKeHoach);
ALTER TABLE Tour ADD CONSTRAINT fk_Tour_HopDong
	FOREIGN KEY (MaHD) REFERENCES HopDong(MaHD);
ALTER TABLE Tour ADD CONSTRAINT fk_Tour_TaiKhoan
	FOREIGN KEY (TenTK) REFERENCES TaiKhoan(TenTK);
    
ALTER TABLE KeHoachTour ADD CONSTRAINT fk_KeHoachTour_CTKeHoachTour
	FOREIGN KEY (MaCTKH) REFERENCES CTKeHoachTour(MaCTKeHoach);
    
ALTER TABLE CTKeHoachTour ADD CONSTRAINT fk_CTKeHoachTour_PhuongTien
	FOREIGN KEY (MaPhuongTien) REFERENCES PhuongTien(MaPhuongTien);
ALTER TABLE CTKeHoachTour ADD CONSTRAINT fk_CTKeHoachTour_NhaHang
	FOREIGN KEY (MaNhaHang) REFERENCES NhaHang(MaNhaHang);
ALTER TABLE CTKeHoachTour ADD CONSTRAINT fk_CTKeHoachTour_KhachSan
	FOREIGN KEY (MaKhachSan) REFERENCES KhachSan(MaKhachSan);
ALTER TABLE CTKeHoachTour ADD CONSTRAINT fk_CTKeHoachTour_DiaDiemThamQuan
	FOREIGN KEY (MaDiaDiemThamQuan) REFERENCES DiaDiemThamQuan(MaDiaDiem);
ALTER TABLE CTKeHoachTour ADD CONSTRAINT fk_CTKeHoachTour_CTThuChi
	FOREIGN KEY (MaCTThuChi) REFERENCES CTThuChi(MaCTThuChi);