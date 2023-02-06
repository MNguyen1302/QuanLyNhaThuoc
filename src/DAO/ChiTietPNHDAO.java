/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ChiTietPNHDTO;
import database.MyConnectionInit;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;
/**
 *
 * @author cmduc
 */
public class ChiTietPNHDAO {
    MyConnectionInit conn;
    
    public ArrayList<ChiTietPNHDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        
        ResultSet rs = conn.select("ChiTietPNH", condition, orderBy);
        ArrayList<ChiTietPNHDTO> list = new ArrayList<>();
        while (rs.next()) {            
            ChiTietPNHDTO ctpnh = new ChiTietPNHDTO();
            
            ctpnh.setMaPN(rs.getString(1));
            ctpnh.setMaThuoc(rs.getString(2));
            ctpnh.setSoLuongNhap(rs.getInt(3));
            ctpnh.setDonGiaNhap(rs.getInt(4));
            ctpnh.setThanhTien(rs.getInt(5));
            
            list.add(ctpnh);
        }
        
        return list;
}
 public ArrayList<ChiTietPNHDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<ChiTietPNHDTO> readDB() throws Exception {
        return readDB(null);
    }   
    public boolean addCTPN(ChiTietPNHDTO ctpn) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaPNH", ctpn.getMaPN());
        value.put("MaThuoc", ctpn.getMaThuoc());
        value.put("SoLuongNhap", ctpn.getSoLuongNhap());
        value.put("DonGiaNhap",ctpn.getDonGiaNhap());
        value.put("ThanhTien",ctpn.getThanhTien());
        boolean check = conn.insert("ChiTietPNH", value);
  
        conn.Close();
        return check;
    }
    public boolean deleteDetail(ChiTietPNHDTO ctpn) throws Exception {
        conn = new MyConnectionInit();
        
        boolean check = conn.delete("ChiTietPNH", " MaThuoc = '" + ctpn.getMaThuoc() + "'");
        return check;
    }
}



