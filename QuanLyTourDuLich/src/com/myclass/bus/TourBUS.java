package com.myclass.bus;

import java.sql.SQLException;
import java.util.ArrayList;

import com.myclass.dao.TourDAO;
import com.myclass.dto.TourDTO;

public class TourBUS {
	private static TourDAO tourDAO = new TourDAO(); 
	public static ArrayList<TourDTO> listTourDTO = tourDAO.getAll();
	
	public TourBUS() {}
	
	public TourDTO getById(String maTour) {
		
		return tourDAO.getById(maTour);
	}
	
	
	public void add(TourDTO dto) {
		tourDAO.add(dto);
	}
	
	public void update(TourDTO dto) {
		tourDAO.update(dto);
	}
	
	public void deleteById(String maTour) {
		tourDAO.deleteById(maTour);
	}
}
