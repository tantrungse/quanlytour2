package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myclass.connector.JDBCConnection;
import com.myclass.dto.KHTourDTO;
import com.myclass.dto.TourDTO;

public class KHTourDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public KHTourDTO getById(String maKHTour) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<KHTourDTO> getAll() throws SQLException {
		ArrayList<KHTourDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection();
			String sql = "SELECT * FROM KeHoachTour";
			dtos = new ArrayList<KHTourDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				KHTourDTO dto = new KHTourDTO();
				
				dto.setMaKeHoach(rs.getString("MaKeHoach"));
				dto.setNgayBatDau(rs.getString("NgayBatDau"));
				dto.setNgayKetThuc(rs.getString("NgayKetThuc"));
				dto.setMaCTKH(rs.getString("MaCTKH"));
				dtos.add(dto);
			}
			
			return dtos;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return null;
	}
	
	public void add(KHTourDTO dto) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection();
			String sql = "INSERT INTO "
					+ "KeHoachTour(`MaKeHoach`, `NgayBatDau`, `NgayKetThuc`, `MaCTKH`)"
					+ "VALUES (?, ?, ?, ?,)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaKeHoach());
			pstmt.setString(2, dto.getNgayBatDau());
			pstmt.setString(3, dto.getNgayKetThuc());
			pstmt.setString(4, dto.getMaCTKH());
			
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void update(KHTourDTO dto) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection();
			String sql = "UPDATE KeHoachTour SET "
					+ "NgayBatDau = ?, NgayKetThuc = ?, MaCTKH = ?"
					+ "WHERE MaKeHoach = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNgayBatDau());
			pstmt.setString(2, dto.getNgayKetThuc());
			pstmt.setString(3, dto.getMaCTKH());
			pstmt.setString(4, dto.getMaKeHoach());
			
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void deteleById(String maKeHoach) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection();
			String sql = "DELETE FROM KeHoachTour WHERE MaKeHoach = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maKeHoach);
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}
