package com.myclass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.myclass.dto.TaiKhoanDTO;

public class TaiKhoanDAO {
	public static Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			String url = "jdbc:mysql://localhost:3306/doan";
			String user = "root";
			String password = "";

			// create a connection to the database
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static ArrayList<TaiKhoanDTO> logindaonhanvien()
	{
		ArrayList<TaiKhoanDTO> list=new ArrayList<TaiKhoanDTO>();
		TaiKhoanDTO acc=new TaiKhoanDTO();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		try {
			conn = TaiKhoanDAO.getConnection();
			String query = "SELECT * FROM datalogin\n" + "WHERE`Quyen`=1 ";
			pstm = conn.prepareStatement(query);
	
			
			resultSet = pstm.executeQuery();
			
			if(resultSet.next()) {
				acc.setTenTK(resultSet.getString("Username"));
				acc.setMatKhau(resultSet.getString("Password"));
				acc.setQuyen(resultSet.getInt("Quyen"));
				list.add(acc);
			   
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
	return list;
		}
	public static ArrayList<TaiKhoanDTO>  logindao()
	{
		ArrayList<TaiKhoanDTO> list=new ArrayList<TaiKhoanDTO>();
		TaiKhoanDTO acc=new TaiKhoanDTO();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet resultSet = null;
		try {
			conn = TaiKhoanDAO.getConnection();
			String query = "SELECT * FROM datalogin" ;
			pstm = conn.prepareStatement(query);
			
			
			
			resultSet = pstm.executeQuery();
			
		if(resultSet.next()) {
			acc.setTenTK(resultSet.getString("Username"));
			acc.setMatKhau(resultSet.getString("Password"));
			acc.setQuyen(resultSet.getInt("Quyen"));
			list.add(acc);
		   //JOptionPane.showMessageDialog(null,"Báº¡n Ä‘Ã£ Ä‘Äƒng nháº­p vá»›i quyá»�n admin");
		}
		}catch (Exception e) {
		e.printStackTrace();
		}
      return list;
		}
}
