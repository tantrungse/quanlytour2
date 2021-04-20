/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTThuChiDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thin
 */
public class CTThuChiDAO {
    
    public static List<CTThuChiDTO> xemDSCT() {
        List<CTThuChiDTO> chitietTCList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from ctthuchi";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                CTThuChiDTO cttcDTO = new CTThuChiDTO(resultSet.getString("MaCTThuChi"), resultSet.getString("MaCTKeHoach"), resultSet.getInt("TongThu"), resultSet.getInt("TongChi"), resultSet.getInt("DoanhThu"));
                chitietTCList.add(cttcDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
        return chitietTCList;
    }
    
    public static void XoaCTTC(String MaCTThuChi) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "delete from ctthuchi where MaCTThuChi = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, MaCTThuChi);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }
    
    public static void LuuCTTC(CTThuChiDTO cttcDTO) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "insert into ctthuchi( MaCTThuChi, MaCTKeHoach, TongThu, TongChi, DoanhThu) values(?,?,?,?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, cttcDTO.getMaCTTC());
            statement.setString(2, cttcDTO.getMaCTKH());
            statement.setInt(3, cttcDTO.getTongThu());
            statement.setInt(4, cttcDTO.getTongChi()); 
            statement.setInt(5, cttcDTO.getDoanhThu());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }
    
    public static List<CTThuChiDTO> findByMaCT(String MaCTThuChi) {
        List<CTThuChiDTO> chitietTCList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "select* from ctthuchi where MaCTThuChi = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, MaCTThuChi);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CTThuChiDTO cttcDTO = new CTThuChiDTO(resultSet.getString("MaCTThuChi"), resultSet.getString("MaCTKeHoach"), resultSet.getInt("TongThu"), resultSet.getInt("TongChi"), resultSet.getInt("DoanhThu"));
                chitietTCList.add(cttcDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
        return chitietTCList;
    }
    
    
    public static void CapNhatCTTC(CTThuChiDTO cttcDTO) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lấy tất cả danh sách khách sạn
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydulich", "root", "");
            //Query
            String sql = "update ctthuchi set MaCTKeHoach=?, TongThu=?, TongChi=?, DoanhThu=? where MaCTThuChi =? ";
            statement = connection.prepareCall(sql);

            statement.setString(1, cttcDTO.getMaCTKH());
            statement.setInt(2, cttcDTO.getTongThu());
            statement.setInt(3, cttcDTO.getTongChi());
            statement.setInt(4, cttcDTO.getDoanhThu());
            statement.setString(5, cttcDTO.getMaCTTC());
            

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTThuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ketthuc.
    }
}
