package com.myclass.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	 String username = "root";
	 String password = "12345678";
	 String URL = "jdbc:mysql://localhost:3306/";
	 
	public static Connection getJDBCConnection() { // kết nối bằng cách tạo đối tượng mới vì ko còn là phương thức static
		String username = "root";
		String password = "12345678";
		String URL = "jdbc:mysql://localhost:3306/quanlytourdulich";
		
		try {
			System.out.print("Đang kết nối đến cơ sở dữ liệu...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, username, password);
			if(conn != null) {
				System.out.println("KẾT NỐI THÀNH CÔNG!");
				return conn;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("KẾT NỐI THẤT BẠI!");
		return null;
	}
}
