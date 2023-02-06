/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.LoaiThuocDTO;
import database.MyConnectionInit;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author mynguyen
 */
public class LoaiThuocDAO {
    MyConnectionInit conn;
    
    public ArrayList<LoaiThuocDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        
        ResultSet rs = conn.select("LoaiThuoc", condition, orderBy);
        ArrayList<LoaiThuocDTO> list = new ArrayList<>();
        while (rs.next()) {            
            LoaiThuocDTO loai = new LoaiThuocDTO();
            
            loai.setMaLoai(rs.getString(1));
            loai.setTenLoai(rs.getString(2));
            
            list.add(loai);
        }
        
        return list;
    }
    
    public ArrayList<LoaiThuocDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<LoaiThuocDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean add(LoaiThuocDTO loai) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaLoaiThuoc", loai.getMaLoai());
        value.put("TenLoaiThuoc", loai.getTenLoai());
        
        boolean check = conn.insert("LoaiThuoc", value);
        
        conn.Close();
        return check;
    }
    
    public boolean update(LoaiThuocDTO loai) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("TenLoaiThuoc", loai.getTenLoai());
        
        String condition = " MaLoaiThuoc = '" + loai.getMaLoai() + "'";
        boolean check = conn.update("LoaiThuoc", value, condition);
        
        conn.Close();
        return check;
    }
    
    public boolean delete(LoaiThuocDTO loai) throws Exception {
        conn = new MyConnectionInit();
        
        boolean check = conn.delete("LoaiThuoc", " MaLoaiThuoc = '" + loai.getMaLoai() + "'");
        return check;
    }
}
