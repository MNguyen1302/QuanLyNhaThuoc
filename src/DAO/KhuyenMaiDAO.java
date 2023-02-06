/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhuyenMaiDTO;
import database.MyConnectionInit;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author mynguyen
 */
public class KhuyenMaiDAO {
    MyConnectionInit conn;
    
    public ArrayList<KhuyenMaiDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        ResultSet rs = conn.select("KhuyenMai", condition, orderBy);
        ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
        
        while (rs.next()) {            
            KhuyenMaiDTO km = new KhuyenMaiDTO();
            km.setMaKM(rs.getString(1));
            km.setTenKM(rs.getString(2));
            km.setNgayBatDau(rs.getString(3));
            km.setNgayKetThuc(rs.getString(4));
            
            dskm.add(km);
        }
        
        conn.Close();
        return dskm;
    }
    
    public ArrayList<KhuyenMaiDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<KhuyenMaiDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean addKhuyenMai(KhuyenMaiDTO km) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaKM", km.getMaKM());
        value.put("TenKM", km.getTenKM());
        value.put("NgayBatDau", km.getNgayBatDau());
        value.put("NgayKetThuc", km.getNgayKetThuc());
        
        boolean check = conn.insert("KhuyenMai", value);
        
        conn.Close();
        return check;
    }
    
    public boolean updateKhuyenMai(KhuyenMaiDTO km) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("MaKM", km.getMaKM());
        value.put("TenKM", km.getTenKM());
        value.put("NgayBatDau", km.getNgayBatDau());
        value.put("NgayKetThuc", km.getNgayKetThuc());
        
        String condition = " MaKM = '" + km.getMaKM()+ "'";
        boolean check = conn.update("KhuyenMai", value, condition);
        
        conn.Close();
        return check;
    }
    
    public boolean deleteKhuyenMai(KhuyenMaiDTO km) throws Exception {
        conn = new MyConnectionInit();
        
        boolean check = conn.delete("KhuyenMai", " MaKM = '" + km.getMaKM()+ "'");
        conn.Close();
        return check;
    }
    
}
