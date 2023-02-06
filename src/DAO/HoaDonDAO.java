/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDonDTO;
import database.MyConnectionInit;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author mynguyen
 */
public class HoaDonDAO {
    MyConnectionInit conn;
    
    public ArrayList<HoaDonDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        
        ResultSet rs = conn.select("HoaDon", condition, orderBy);
        ArrayList<HoaDonDTO> list = new ArrayList<>();
        while (rs.next()) {            
            HoaDonDTO hd = new HoaDonDTO();
            
            hd.setMaHD(rs.getString(1));
            hd.setMaKH(rs.getString(2));
            hd.setMaNV(rs.getString(3));
            hd.setNgayLap(rs.getString(4));
            hd.setTongTien(rs.getInt(5));
            
            list.add(hd);
        }
        
        return list;
    }
    
    public ArrayList<HoaDonDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<HoaDonDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean add(HoaDonDTO hd) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaHD", hd.getMaHD());
        value.put("MaKH", hd.getMaHD());
        value.put("MaNV", hd.getMaNV());
        value.put("NgayLap", hd.getNgayLap());
        value.put("TongTien", hd.getTongTien());
        
        boolean check = conn.insert("HoaDon", value);
        
        conn.Close();
        return check;
    }
    
    public boolean update(HoaDonDTO hd) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("TongTien", hd.getTongTien());
        
        String condition = " MaHD = '" + hd.getMaHD()+ "'";
        boolean check = conn.update("HoaDon", value, condition);
        
        conn.Close();
        return check;
        
    }

          
}
