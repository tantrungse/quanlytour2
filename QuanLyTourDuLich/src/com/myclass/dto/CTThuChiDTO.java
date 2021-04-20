/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Thin
 */
public class CTThuChiDTO {
    private String maCTTC;  //mã chi tiết thu chi
    private String maCTKH; //mã chi tiết kế hoạch tour
    private int tongChi;
    private int tongThu;
    private int doanhThu;

    public CTThuChiDTO() {
    }

    public CTThuChiDTO(String maCTKH, int tongChi, int tongThu, int doanhThu) {
        this.maCTKH = maCTKH;
        this.tongChi = tongChi;
        this.tongThu = tongThu;
        this.doanhThu = doanhThu;
    }

    public CTThuChiDTO(String maCTTC, String maCTKH, int tongChi, int tongThu, int doanhThu) {
        this.maCTTC = maCTTC;
        this.maCTKH = maCTKH;
        this.tongChi = tongChi;
        this.tongThu = tongThu;
        this.doanhThu = doanhThu;
    }

    public String getMaCTTC() {
        return maCTTC;
    }

    public void setMaCTTC(String maCTTC) {
        this.maCTTC = maCTTC;
    }

    public String getMaCTKH() {
        return maCTKH;
    }

    public void setMaCTKH(String maCTKH) {
        this.maCTKH = maCTKH;
    }

    public int getTongChi() {
        return tongChi;
    }

    public void setTongChi(int tongChi) {
        this.tongChi = tongChi;
    }

    public int getTongThu() {
        return tongThu;
    }

    public void setTongThu(int tongThu) {
        this.tongThu = tongThu;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }
    
}
