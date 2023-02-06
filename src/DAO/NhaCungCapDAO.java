/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.NhaCungCapDTO;
import database.MyConnectionInit;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mynguyen
 */
public class NhaCungCapDAO {
    MyConnectionInit conn;
    
    public ArrayList<NhaCungCapDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        
        ResultSet rs = conn.select("NCC", condition, orderBy);
        ArrayList<NhaCungCapDTO> list = new ArrayList<>();
        while (rs.next()) {            
            NhaCungCapDTO ncc = new NhaCungCapDTO();
            
            ncc.setMaNCC(rs.getString(1));
            ncc.setTenNCC(rs.getString(2));
            ncc.setSDT(rs.getString(3));
            ncc.setDiaChi(rs.getString(4));
            
            list.add(ncc);
        }
        
        return list;
    }
    
    public ArrayList<NhaCungCapDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<NhaCungCapDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean add(NhaCungCapDTO ncc) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaNCC", ncc.getMaNCC());
        value.put("TenNCC", ncc.getTenNCC());
        value.put("SDT", ncc.getSDT());
        value.put("DiaChi", ncc.getDiaChi());
        
        boolean check = conn.insert("NCC", value);
        
        conn.Close();
        return check;
    }
    
    public boolean update(NhaCungCapDTO ncc) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("TenNCC", ncc.getTenNCC());
        value.put("SDT", ncc.getSDT());
        value.put("DiaChi", ncc.getDiaChi());
        
        String condition = " MaNCC = '" + ncc.getMaNCC()+ "'";
        boolean check = conn.update("NCC", value, condition);
        
        conn.Close();
        return check;
    }
    
    public boolean delete(NhaCungCapDTO ncc) throws Exception {
        conn = new MyConnectionInit();
        
        boolean check = conn.delete("NCC", " MaNCC = '" + ncc.getMaNCC()+ "'");
        return check;
    }
    
    
}
