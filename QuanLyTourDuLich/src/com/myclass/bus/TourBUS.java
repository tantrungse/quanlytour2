package com.myclass.bus;

import java.sql.SQLException;
import java.util.ArrayList;

import com.myclass.dao.TourDAO;
import com.myclass.dto.TourDTO;

public class TourBUS {
	public static ArrayList<TourDTO> listTour;
	private TourDAO tourDAO;
	
	public TourBUS() {
		tourDAO = new TourDAO();
	}
	
	public TourDTO getById(String maTour) {
		
		return tourDAO.getById(maTour);
	}
	
	
	public void add(TourDTO dto) throws SQLException {
		tourDAO.add(dto);
	}
	
	public void update(TourDTO dto) throws SQLException {
		tourDAO.update(dto);
	}
	
	public void deleteById(String maTour) {
		tourDAO.deleteById(maTour);
	}
}
