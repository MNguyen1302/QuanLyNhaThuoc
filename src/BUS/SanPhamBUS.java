/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.HoaDonDTO;
import DTO.ChiTietHDDTO;
import DTO.SanPhamDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import utils.Methods;

public class SanPhamBUS {
    private ArrayList<SanPhamDTO> listSP;
    private SanPhamDAO spDAO;
    
    public SanPhamBUS() throws Exception {
        listSP = new ArrayList<>();
        spDAO = new SanPhamDAO();
        listSP = spDAO.readDB();
    }
    
    public void readDB() throws Exception {
        listSP = new ArrayList<>();
        spDAO = new SanPhamDAO();
        listSP = spDAO.readDB();
        
    }

    public ArrayList<SanPhamDTO> getListSP() {
        return listSP;
    }

    public void setListSP(ArrayList<SanPhamDTO> listSP) {
        this.listSP = listSP;
    }
    
    public SanPhamDTO getSP(String id) {
        for (SanPhamDTO sp : listSP) {
            if (sp.getMaThuoc().equals(id)) {
                return sp;
            }
        }
        return null;
    }
    
    public String getMa(String tenThuoc){
        for(SanPhamDTO sp : this.listSP){
            if(tenThuoc.equals(sp.getTenThuoc()))
                return sp.getMaThuoc();
        }
        return null;
    }
    
    public String getTenProduct(String id){
        for(SanPhamDTO sp : listSP){
            if(id.equals(sp.getMaThuoc()))
                return sp.getTenThuoc();
       }
        return null;
    }
    
    public boolean check(String mathuoc){
        for(SanPhamDTO sp : this.getListSP()){
            if(sp.getMaThuoc().equals(mathuoc))
                return true;
        }
        return false;
    }
    
    public boolean checkPrimary(SanPhamDTO sp1) {
        for (SanPhamDTO sp2 : this.getListSP()) {
            if (sp1.getMaThuoc().equals(sp2.getMaThuoc())) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<SanPhamDTO> searchByName(ArrayList<SanPhamDTO> list, String keyword) {
        ArrayList<SanPhamDTO> tmp = new ArrayList<>();
        
        for (SanPhamDTO product : list) {
            if (product.getTenThuoc().toLowerCase().contains(keyword.toLowerCase())) {
                tmp.add(product);
            }
        }
        
        return tmp;
    }
    
    public ArrayList<SanPhamDTO> searchByCategory(ArrayList<SanPhamDTO> list, String keyword) {
        ArrayList<SanPhamDTO> tmp = new ArrayList<>();

        for (SanPhamDTO product : list) {
            if (product.getMaLoaiThuoc().equals(keyword)) {
                tmp.add(product);
            }
        }
        return tmp;
    }
    
    public ArrayList<SanPhamDTO> searchByPrice(ArrayList<SanPhamDTO> list, String priceFrom, String priceTo) {
        ArrayList<SanPhamDTO> tmp = new ArrayList<>();

        for (SanPhamDTO product : list) {
            if (product.getDonGia() > Integer.parseInt(priceFrom) && product.getDonGia() < Integer.parseInt(priceTo)) {
                tmp.add(product);
            }
        }
        return tmp;
    }
    
    public ArrayList<SanPhamDTO> searchByStatus(ArrayList<SanPhamDTO> list, String status) {
        ArrayList<SanPhamDTO> tmp = new ArrayList<>();

        for (SanPhamDTO product : list) {
            if (product.getTrangThai().equals(status)) {
                tmp.add(product);
            }
        }
        return tmp;
    }
    
    public boolean addProduct(SanPhamDTO sp) throws Exception {
        if (checkPrimary(sp)) {
            if (spDAO.addProduct(sp)) {
                this.getListSP().add(sp);
                return true;
            }
        } else {
            
        }
    
        return false;
    }
    
    public boolean deleteProduct(String id) throws Exception {
        for (SanPhamDTO  sp: this.getListSP()) {
            if (sp.getMaThuoc().equals(id)) {
                if (spDAO.deleteProduct(sp)) {
                    this.getListSP().remove(sp);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean updateProduct(SanPhamDTO sp1) throws Exception {
        if (spDAO.updateProduct(sp1)) {
            for (SanPhamDTO sp2 : this.getListSP()) {
                if (sp1.getMaThuoc().equals(sp2.getMaThuoc())) {
                    sp2.setTenThuoc(sp1.getTenThuoc());
                    sp2.setDonGia(sp1.getDonGia());
                    sp2.setDonViTinh(sp1.getDonViTinh());
                    sp2.setNgaySanXuat(sp1.getNgaySanXuat());
                    sp2.setHanSuDung(sp1.getHanSuDung());
                    sp2.setSoLuong(sp1.getSoLuong());
                    sp2.setMaLoaiThuoc(sp1.getMaLoaiThuoc());
                    sp2.setTrangThai(sp2.getTrangThai());
                    sp2.setAnh(sp1.getAnh());
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean updateQty(String id, int qty) throws Exception {
        if (spDAO.updateQty(id, qty)) {
            for (SanPhamDTO sp : this.getListSP()) {
                if (sp.getMaThuoc().equals(id)) {
                    sp.setSoLuong(qty);
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[] tongDoanhThuTheoSP(int nam, int quy) throws Exception {
        ChiTietHDBUS cthdBUS = new ChiTietHDBUS();
        HoaDonBUS hdBUS = new HoaDonBUS();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date[] dates = Methods.getNgayTheoQuy(nam, quy);
        Date ngayBD, ngayKT, ngaylap;
        ngayBD = dates[0];
        ngayKT = dates[1];
        int sum = 0, i = 0;
        int[] result = new int[this.getListSP().size()];
        for (SanPhamDTO sp : this.getListSP()) {
            sum = 0;
            for (ChiTietHDDTO cthd : cthdBUS.getListCTHD()) {
                if (cthd.getMaThuoc().equals(sp.getMaThuoc())) {
                    HoaDonDTO hd = hdBUS.getHD(cthd.getMaHD());
                    String[] d = hd.getNgayLap().split("-");
                    ngaylap = df.parse(d[2] + "-" + d[1] + "-" + d[0]);
                    
                    if (ngaylap.compareTo(ngayBD) >= 0 && ngaylap.compareTo(ngayKT) < 0) {
                        sum += cthd.getThanhTien();
                    }
                }
            }

            result[i++] = (sum);
        }
        
        return result;
    }
    
}
