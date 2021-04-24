use quanlytourdulich;

insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS001', 'Khach San 1', 'Unknow', '500');
insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS002', 'Khach San 2', 'Unknow', '600');
insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS003', 'Khach San 3', 'Unknow', '700');
insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS004', 'Khach San 4', 'Unknow', '800');
insert  into khachsan(MaKhachSan, TenKhachSan, DiaChi, ChiPhiTrenNguoi)
		values('KS005', 'Khach San 5', 'Unknow', '900');
        
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH001', 'Nha Hang 1', 'Unknow', '500');
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH002', 'Nha Hang 2', 'Unknow', '600');
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH003', 'Nha Hang 3', 'Unknow', '700');
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH004', 'Nha Hang 4', 'Unknow', '800');
insert  into nhahang(MaNhaHang, TenNhaHang, DiaChi, ChiPhiTrenNguoi)
		values('NH005', 'Nha Hang 5', 'Unknow', '900');
        
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT001', 'Phuong Tien 1', '500', 8);
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT002', 'Phuong Tien 2', '600', 12);
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT003', 'Phuong Tien 3', '700', 16);
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT004', 'Phuong Tien 4', '800', 24);
insert  into phuongtien(MaPhuongTien, TenPhuongTien, ChiPhi, SoChoNgoi)
		values('PT005', 'Phuong Tien 5', '900', 32);
        
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC001', null, null, null);
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC002', null, null, null);
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC003', null, null, null);
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC004', null, null, null);
insert  into ctthuchi(MaCTThuChi, TongThu, TongChi, DoanhThu)
		values('CTTC005', null, null, null);
        
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD001', 'Dia Diem 1', 'Unknow');
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD002', 'Dia Diem 2', 'Unknow');
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD003', 'Dia Diem 3', 'Unknow');
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD004', 'Dia Diem 4', 'Unknow');
insert  into diadiemthamquan(MaDiaDiem, TenDiaDiem, DiaChi)
		values('DD005', 'Dia Diem 5', 'Unknow');
        
insert  into ctkehoachtour(MaCTKeHoach, MaPhuongTien, MaNhaHang, MaKhachSan, MaDiaDiemThamQuan, MaCTThuChi)
		values('CTKH001', 'PT001', 'NH001', 'KS001', 'DD001', 'CTTC001');
insert  into ctkehoachtour(MaCTKeHoach, MaPhuongTien, MaNhaHang, MaKhachSan, MaDiaDiemThamQuan, MaCTThuChi)
		values('CTKH002', 'PT002', 'NH002', 'KS002', 'DD002', 'CTTC002');
insert  into ctkehoachtour(MaCTKeHoach, MaPhuongTien, MaNhaHang, MaKhachSan, MaDiaDiemThamQuan, MaCTThuChi)
		values('CTKH003', 'PT003', 'NH003', 'KS003', 'DD003', 'CTTC003');
insert  into ctkehoachtour(MaCTKeHoach, MaPhuongTien, MaNhaHang, MaKhachSan, MaDiaDiemThamQuan, MaCTThuChi)
		values('CTKH004', 'PT004', 'NH004', 'KS004', 'DD004', 'CTTC004');
insert  into ctkehoachtour(MaCTKeHoach, MaPhuongTien, MaNhaHang, MaKhachSan, MaDiaDiemThamQuan, MaCTThuChi)
		values('CTKH005', 'PT005', 'NH005', 'KS005', 'DD005', 'CTTC005');
        
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaCTKH)
	   values ('KH001','2021-04-13', '2021-04-21', 'CTKH001');
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaCTKH)
	   values ('KH002','2021-04-10', '2021-04-18', 'CTKH002');
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaCTKH)
	   values ('KH003','2021-04-13', '2021-04-17', 'CTKH003');
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaCTKH)
	   values ('KH004','2021-04-16', '2021-04-20', 'CTKH004');
insert into kehoachtour(MaKeHoach, NgayBatDau, NgayKetThuc, MaCTKH)
	   values ('KH005','2021-04-14', '2021-04-21', 'CTKH005');
       
insert into hopdong(MaHD, NgayLapHD, NoiDung)
	   values ('HD001', '2021-03-13', 'Day la hop dong cua Tour 1');
insert into hopdong(MaHD, NgayLapHD, NoiDung)
	   values ('HD002', '2021-03-10', 'Day la hop dong cua Tour 2');
insert into hopdong(MaHD, NgayLapHD, NoiDung)
	   values ('HD003', '2021-03-13', 'Day la hop dong cua Tour 3');
insert into hopdong(MaHD, NgayLapHD, NoiDung)
	   values ('HD004', '2021-03-16', 'Day la hop dong cua Tour 4');
insert into hopdong(MaHD, NgayLapHD, NoiDung)
	   values ('HD005', '2021-03-14', 'Day la hop dong cua Tour 5');
       
insert into tour(MaTour, TenTour, GiaVe, MaKHTour, MaHD)
	   values ('TOUR001', 'Tour 1', 100, 'KH001', 'HD001');
insert into tour(MaTour, TenTour, GiaVe, MaKHTour, MaHD)
	   values ('TOUR002', 'Tour 2', 100, 'KH002', 'HD002');
insert into tour(MaTour, TenTour, GiaVe, MaKHTour, MaHD)
	   values ('TOUR003', 'Tour 3', 100, 'KH003', 'HD003');
insert into tour(MaTour, TenTour, GiaVe, MaKHTour, MaHD)
	   values ('TOUR004', 'Tour 4', 100, 'KH004', 'HD004');
insert into tour(MaTour, TenTour, GiaVe, MaKHTour, MaHD)
	   values ('TOUR005', 'Tour 5', 100, 'KH005', 'HD005');