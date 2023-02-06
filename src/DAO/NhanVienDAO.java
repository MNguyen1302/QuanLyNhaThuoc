/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import database.MyConnectionInit;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author mynguyen
 */
public class NhanVienDAO {
    MyConnectionInit conn;
    
    public ArrayList<NhanVienDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        ResultSet rs = conn.select("NhanVien", condition, orderBy);
        ArrayList<NhanVienDTO> employees = new ArrayList<>();
        
        while (rs.next()) {            
            NhanVienDTO nv = new NhanVienDTO();
            nv.setMaNV(rs.getString(1));
            nv.setHo(rs.getString(2));
            nv.setTen(rs.getString(3));
            nv.setSDT(rs.getString(4));
            nv.setGioiTinh(rs.getString(5));
            nv.setViTri(rs.getString(6));
            
            employees.add(nv);
        }
        
        conn.Close();
        return employees;
    }
    
    public ArrayList<NhanVienDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<NhanVienDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean add(NhanVienDTO nv) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaNV", nv.getMaNV());
        value.put("Ho", nv.getHo());
        value.put("Ten", nv.getTen());
        value.put("SDT", nv.getSDT());
        value.put("GioiTinh", nv.getGioiTinh());
        value.put("ViTri", nv.getViTri());
        
        boolean check = conn.insert("NhanVien", value);
        
        conn.Close();
        return check;
    }
    
    public boolean update(NhanVienDTO nv) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("Ho", nv.getHo());
        value.put("Ten", nv.getTen());
        value.put("SDT", nv.getSDT());
        value.put("GioiTinh", nv.getGioiTinh());
        value.put("ViTri", nv.getViTri());
        
        String condition = " MaNV = '" + nv.getMaNV()+ "'";
        boolean check = conn.update("NhanVien", value, condition);
        
        conn.Close();
        return check;
    }
    
    public boolean delete(NhanVienDTO nv) throws Exception {
        conn = new MyConnectionInit();
        
        boolean check = conn.delete("NhanVien", " MaNV = '" + nv.getMaNV() + "'");
        return check;
    }
}
