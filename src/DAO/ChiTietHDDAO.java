/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import database.MyConnectionInit;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;
/**
 *
 * @author mynguyen
 */
public class ChiTietHDDAO {
    MyConnectionInit conn;
    
    public ArrayList<ChiTietHDDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        
        ResultSet rs = conn.select("CTHD", condition, orderBy);
        ArrayList<ChiTietHDDTO> list = new ArrayList<>();
        while (rs.next()) {            
            ChiTietHDDTO cthd = new ChiTietHDDTO();
            
            cthd.setMaHD(rs.getString(1));
            cthd.setMaThuoc(rs.getString(2));
            cthd.setSoLuong(rs.getInt(3));
            cthd.setDonGia(rs.getInt(4));
            cthd.setThanhTien(rs.getInt(5));
            
            list.add(cthd);
        }
        
        return list;
    }
    
    public ArrayList<ChiTietHDDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<ChiTietHDDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean add(ChiTietHDDTO cthd) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaHD", cthd.getMaHD());
        value.put("MaThuoc", cthd.getMaThuoc());
        value.put("SoLuong", cthd.getSoLuong());
        value.put("DonGia", cthd.getDonGia());
        value.put("ThanhTien", cthd.getThanhTien());
        
        boolean check = conn.insert("CTHD", value);
        
        conn.Close();
        return check;
    }
    
    
}
