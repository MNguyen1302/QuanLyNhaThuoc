/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
import database.MyConnectionInit;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author mynguyen
 */
public class SanPhamDAO {
    MyConnectionInit conn;
    
    public ArrayList<SanPhamDTO> readDB(String condition, String orderBy) throws Exception {
        conn = new MyConnectionInit();
        ResultSet rs = conn.select("Thuoc", condition, orderBy);
        ArrayList<SanPhamDTO> products = new ArrayList<>();
        
        while (rs.next()) {            
            SanPhamDTO product = new SanPhamDTO();
            product.setMaThuoc(rs.getString(1));
            product.setTenThuoc(rs.getString(2));
            product.setDonGia(rs.getInt(3));
            product.setDonViTinh(rs.getString(4));
            product.setSoLuong(rs.getInt(5));
            product.setNgaySanXuat(rs.getString(6));
            product.setHanSuDung(rs.getString(7));
            product.setMaLoaiThuoc(rs.getString(8));
            product.setTrangThai(rs.getString(9));
            product.setAnh(rs.getString(10));
            
            products.add(product);
        }
        
        conn.Close();
        return products;
    }
    
    public ArrayList<SanPhamDTO> readDB(String condition) throws Exception {
        return readDB(condition, null);
    }
    
    public ArrayList<SanPhamDTO> readDB() throws Exception {
        return readDB(null);
    }
    
    public boolean addProduct(SanPhamDTO product) throws Exception {
        conn = new MyConnectionInit();

        HashMap<String, Object> value = new HashMap<>();
        value.put("MaThuoc", product.getMaThuoc());
        value.put("TenThuoc", product.getTenThuoc());
        value.put("DonGia", product.getDonGia());
        value.put("DonViTinh", product.getDonViTinh());
        value.put("SoLuong", product.getSoLuong());
        value.put("NgaySanXuat", product.getNgaySanXuat());
        value.put("HanSuDung", product.getHanSuDung());
        value.put("MaLoaiThuoc", product.getMaLoaiThuoc());
        value.put("TrangThai", product.getTrangThai());
        value.put("Anh", product.getAnh());
        
        boolean check = conn.insert("Thuoc", value);
        
        conn.Close();
        return check;
    }
    
    public boolean updateProduct(SanPhamDTO product) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("TenThuoc", product.getTenThuoc());
        value.put("DonGia", product.getDonGia());
        value.put("DonViTinh", product.getDonViTinh());
        value.put("SoLuong", product.getSoLuong());
        value.put("NgaySanXuat", product.getNgaySanXuat());
        value.put("HanSuDung", product.getHanSuDung());
        value.put("MaLoaiThuoc", product.getMaLoaiThuoc());
        value.put("TrangThai", product.getTrangThai());
        value.put("Anh", product.getAnh());
        
        String condition = " MaThuoc = '" + product.getMaThuoc() + "'";
        boolean check = conn.update("Thuoc", value, condition);
        
        conn.Close();
        return check;
    }
    
    public boolean updateQty(String id, int qty) throws Exception {
        conn = new MyConnectionInit();
        
        HashMap<String, Object> value = new HashMap<>();
        value.put("SoLuong", qty);
        
        String condition = " MaThuoc = '" + id + "'";
        boolean check = conn.update("Thuoc", value, condition);
        
        conn.Close();
        return check;
    }
    
    public boolean deleteProduct(SanPhamDTO product) throws Exception {
        conn = new MyConnectionInit();
        
        boolean check = conn.delete("Thuoc", " MaThuoc = '" + product.getMaThuoc() + "'");
        return check;
    }
    
}
