/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CTThuChiDAO;
import DTO.CTThuChiDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thin
 */
public class CTThuChiBUS {
    
    static List<CTThuChiDTO> cttcList = new ArrayList<>();
    
    public static List<CTThuChiDTO> xemDSCT(){
         cttcList = CTThuChiDAO.xemDSCT();
         return  cttcList;
    }
    
    public static void XoaCTTC(String MaCTThuChi){
        CTThuChiDAO.XoaCTTC(MaCTThuChi);
    }
    
    public static void LuuTTDD(CTThuChiDTO cttcDTO){
        CTThuChiDAO.LuuCTTC(cttcDTO);
    }
    
    public static List<CTThuChiDTO> findByMaCT(String MaCTThuChi) {
        cttcList = CTThuChiDAO.findByMaCT(MaCTThuChi);
        return cttcList;
    }
    
    
    public static void CapNhatCTTC(CTThuChiDTO cttcDTO){
        CTThuChiDAO.CapNhatCTTC(cttcDTO);
    }
}
