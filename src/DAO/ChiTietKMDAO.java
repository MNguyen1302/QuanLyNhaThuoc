/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietKMDTO;
import database.MyConnectionInit;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;
/**
 *
 * @author mynguyen
 */
public class ChiTietKMDAO {
    MyConnectionInit conn;
    
    public ArrayList<ChiTietKMDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        
        ResultSet rs = conn.select("ChiTietKM", condition, orderBy);
        ArrayList<ChiTietKMDTO> list = new ArrayList<>();
        while (rs.next()) {            
            ChiTietKMDTO ctkm = new ChiTietKMDTO();
            
            ctkm.setMaKM(rs.getString(1));
            ctkm.setMaThuoc(rs.getString(2));
            ctkm.setTiLeKM(rs.getString(3));
            
            list.add(ctkm);
        }
        
        conn.Close();
        return list;
    }
    
    public ArrayList<ChiTietKMDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<ChiTietKMDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean addCTKM(ChiTietKMDTO ctkm) throws Exception{
        conn = new MyConnectionInit();
        HashMap<String, Object> value = new HashMap<>();
        value.put("MaKM", ctkm.getMaKM());
        value.put("MaThuoc", ctkm.getMaThuoc());
        value.put("TiLeKM", ctkm.getTiLeKM());
        boolean check = conn.insert("ChiTietKM", value);
        conn.Close();
        return check;
    }
    
    public boolean updateCTKM(ChiTietKMDTO ctkm) throws Exception{
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("MaKM", ctkm.getMaKM());
        value.put("MaThuoc", ctkm.getMaThuoc());
        value.put("TiLeKM", ctkm.getTiLeKM());
        String condition = " MaKM = '" + ctkm.getMaKM() + "' AND MaThuoc = '" + ctkm.getMaThuoc() + "'";
        boolean check = conn.update("ChiTietKM", value, condition);
        conn.Close();
        return check;
    }
    
    public boolean deleteCTKM(ChiTietKMDTO ctkm) throws Exception{
        conn = new MyConnectionInit();
        
        boolean check = conn.delete("ChiTietKM", " MaKM = '" + ctkm.getMaKM()+ "'", " MaThuoc = '" + ctkm.getMaThuoc()+"'");
        conn.Close();
        return check;
    }
}


