/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import database.MyConnectionInit;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mynguyen
 */
public class KhachHangDAO {
    MyConnectionInit conn;
    
    public ArrayList<KhachHangDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        ResultSet rs = conn.select("KhachHang", condition, orderBy);
        ArrayList<KhachHangDTO> customers = new ArrayList<>();
        
        while (rs.next()) {            
            KhachHangDTO kh = new KhachHangDTO();
            kh.setMaKH(rs.getString(1));
            kh.setHo(rs.getString(2));
            kh.setTen(rs.getString(3));
            kh.setSDT(rs.getString(4));
            kh.setDiaChi(rs.getString(5));
            
            customers.add(kh);
        }
        
        conn.Close();
        return customers;
    }
    
    public ArrayList<KhachHangDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<KhachHangDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean add(KhachHangDTO kh) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaKH", kh.getMaKH());
        value.put("Ho", kh.getHo());
        value.put("Ten", kh.getTen());
        value.put("SDT", kh.getSDT());
        value.put("DiaChi", kh.getDiaChi());
        
        boolean check = conn.insert("KhachHang", value);
        
        conn.Close();
        return check;
    }
    
    public boolean update(KhachHangDTO kh) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("Ho", kh.getHo());
        value.put("Ten", kh.getTen());
        value.put("SDT", kh.getSDT());
        value.put("DiaChi", kh.getDiaChi());
        
        String condition = " MaKH = '" + kh.getMaKH()+ "'";
        boolean check = conn.update("KhachHang", value, condition);
        
        conn.Close();
        return check;
    }
    
    public boolean delete(KhachHangDTO kh) throws Exception {
        conn = new MyConnectionInit();
        
        boolean check = conn.delete("KhachHang", " MaKH = '" + kh.getMaKH()+ "'");
        return check;
    }
}
