package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.myclass.bus.TourBUS;
import com.myclass.connector.JDBCConnection;
import com.myclass.dto.TourDTO;

public class TourDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public TourDAO() {
		JDBCConnection con =new JDBCConnection();
		conn = con.getJDBCConnection();
		System.out.print("Yêu cầu kết nối database " + con.getDbname() + "... ");
		if(conn != null) {
			System.out.println("Thành công!");
		}
		else {
			System.out.println("Thất bại!");
		}
	}
	
	public TourDTO getById(String maTour) {
		
		return null;
	}
	
	public ArrayList<TourDTO> getAll() {
		
		return null;
	}
	
	public void add(TourBUS newTour) {
		
	}
	
	public void update(TourBUS updateTour) {
		
	}
	
	public void deteleById(String maTour) {
		
	}
}
