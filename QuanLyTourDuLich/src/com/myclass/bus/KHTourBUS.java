package com.myclass.bus;

import java.sql.SQLException;
import java.util.ArrayList;

import com.myclass.dao.KHTourDAO;
import com.myclass.dao.TourDAO;
import com.myclass.dto.KHTourDTO;
import com.myclass.dto.TourDTO;

public class KHTourBUS {
	public static ArrayList<KHTourDTO> listKHTour;
	private KHTourDAO khTourDAO;
	
	public KHTourBUS() {
		khTourDAO = new KHTourDAO();
	}
	
	public KHTourDTO getById(String maKHTour) {
		
		return khTourDAO.getById(maKHTour);
	}
	
	
	public void add(KHTourDTO dto) throws SQLException {
		khTourDAO.add(dto);
	}
	
	public void update(KHTourDTO dto) throws SQLException {
		khTourDAO.update(dto);
	}
	
	public void deteleById(String maKHTour) throws SQLException {
		khTourDAO.deteleById(maKHTour);
	}
}
