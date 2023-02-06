/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.PhieuNhapHangDTO;
import database.MyConnectionInit;
import java.net.CookieStore;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.management.Query;
/**
 *
 * @author cmduc
 */
public class PhieuNhapHangDAO {
    MyConnectionInit conn;
    
    public ArrayList<PhieuNhapHangDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        
        ResultSet rs = conn.select("PhieuNhapHang", condition, orderBy);
        ArrayList<PhieuNhapHangDTO> list = new ArrayList<>();
        while (rs.next()) {            
            PhieuNhapHangDTO pn = new PhieuNhapHangDTO();
            
            pn.setMaPN(rs.getString(1));
            pn.setMaNV(rs.getString(2));
            pn.setMaNCC(rs.getString(3));
            pn.setNgayLap(rs.getString(4));
            pn.setTongTien(rs.getInt(5));
            
            list.add(pn);
        }
        
        return list;
    }
    public ArrayList<PhieuNhapHangDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    public ArrayList<PhieuNhapHangDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean addPN(PhieuNhapHangDTO pn) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaPNH", pn.getMaPN());
        value.put("MaNV", pn.getMaNV());
        value.put("MaNCC", pn.getMaNCC());
        value.put("NgayLap",pn.getNgayLap());
        value.put("TongTien",pn.getTongTien());
        boolean check = conn.insert("PhieuNhapHang", value);
  
        conn.Close();
        return check;
    }
   
    
    public boolean update(PhieuNhapHangDTO pn) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("MaPNH", pn.getMaPN());
        value.put("MaNV", pn.getMaNV());
        value.put("MaNCC", pn.getMaNCC());
        value.put("NgayLap",pn.getNgayLap());
        value.put("TongTien",pn.getTongTien());
        String condition = " MaPNH = '" + pn.getMaPN() + "'";
        boolean check = conn.update("PhieuNhapHang", value, condition);
        
        conn.Close();
        return check;
    }
   

}
