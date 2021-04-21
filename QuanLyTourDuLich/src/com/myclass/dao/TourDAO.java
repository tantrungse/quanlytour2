package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.myclass.bus.TourBUS;
import com.myclass.connector.JDBCConnection;
import com.myclass.dto.TourDTO;

public class TourDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public TourDAO() {
		
	}
	
	public TourDTO getById(String maTour) {
		
		return null;
	}
	
	public ArrayList<TourDTO> getAll() throws SQLException {
		ArrayList<TourDTO> dtos;
		try {
			conn = JDBCConnection.getJDBCConnection();
			String sql = "SELECT * FROM tour";
			dtos = new ArrayList<TourDTO>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TourDTO dto = new TourDTO();
				
				dto.setMaTour(rs.getString("MaTour"));
				dto.setTenTour(rs.getString("TenTour"));
				dto.setGiaVe(rs.getDouble("GiaVe"));
				dto.setMaKHTour(rs.getString("MaKHTour"));
				dto.setMaHD(rs.getString("MaHD"));
				dto.setTenTK(rs.getString("TenTK"));
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
	
	public void add(TourDTO dto) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection();
			String sql = "INSERT INTO "
					+ "Tour(`MaTour`, `TenTour`, `GiaVe`, `MaKHTour`, `MaHD`, `TenTK`)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMaTour());
			pstmt.setString(2, dto.getTenTour());
			pstmt.setDouble(3, dto.getGiaVe());
			pstmt.setString(4, dto.getMaKHTour());
			pstmt.setString(5, dto.getMaHD());
			pstmt.setString(6, dto.getTenTK());
			
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	public void update(TourDTO dto) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection();
			String sql = "UPDATE Tour SET "
					+ "TenTour = ?, GiaVe = ?, MaKHTour = ?, "
					+ "MaHD = ?, TenTK = ?"
					+ "WHERE MaTour = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTenTour());
			pstmt.setDouble(2, dto.getGiaVe());
			pstmt.setString(3, dto.getMaKHTour());
			pstmt.setString(4, dto.getMaHD());
			pstmt.setString(5, dto.getTenTK());
			pstmt.setString(6, dto.getMaTour());
			
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	public void deteleById(String id) throws SQLException {
		try {
			conn = JDBCConnection.getJDBCConnection();
			String sql = "DELETE FROM Tour WHERE MaTour = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int rowEffects = pstmt.executeUpdate();
			System.out.println("Row effects: " + rowEffects);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
