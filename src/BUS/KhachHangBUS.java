/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author mynguyen
 */
public class KhachHangBUS {
    private ArrayList<KhachHangDTO> listKH;
    private KhachHangDAO khDAO;
    
    public KhachHangBUS() throws Exception {
        listKH = new ArrayList<>();
        khDAO = new KhachHangDAO();
        listKH = khDAO.readDB();
    }
    
    public void readDB() throws Exception {
        listKH = new ArrayList<>();
        khDAO = new KhachHangDAO();
        listKH = khDAO.readDB();
    }

    public ArrayList<KhachHangDTO> getListKH() {
        return listKH;
    }

    public void setListKH(ArrayList<KhachHangDTO> listKH) {
        this.listKH = listKH;
    }
    
    public boolean checkPrimary(KhachHangDTO kh1) {
        for (KhachHangDTO kh2 : this.getListKH()) {
            if (kh1.getMaKH().equals(kh2.getMaKH())) {
                return false;
            }
        }
        return true;
    }
    
    public KhachHangDTO getKH(String id) {
        for (KhachHangDTO kh : listKH) {
            if (kh.getMaKH().equals(id)) {
                return kh;
            }
        }
        return null;
    }
    
    public ArrayList<KhachHangDTO> searchByName(String keyword) {
        ArrayList<KhachHangDTO> tmp = new ArrayList<>();
        
        for (KhachHangDTO kh : this.getListKH()) {
            if (kh.getTen().toLowerCase().contains(keyword.toLowerCase())) {
                tmp.add(kh);
            }
        }
        
        return tmp;
    }
    
    public boolean add(KhachHangDTO kh) throws Exception {
        if (checkPrimary(kh)) {
            if (khDAO.add(kh)) {
                this.getListKH().add(kh);
                return true;
            }
        }
    
        return false;
    }
    
    public boolean delete(String id) throws Exception {
        for (KhachHangDTO  kh: this.getListKH()) {
            if (kh.getMaKH().equals(id)) {
                khDAO.delete(kh);
                this.getListKH().remove(kh);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean update(String id, String ho, String ten, String sdt, String diachi) throws Exception {
        for (KhachHangDTO kh : this.getListKH()) {
            if (kh.getMaKH().equals(id)) {
                kh.setHo(ho);
                kh.setTen(ten);
                kh.setSDT(sdt);
                kh.setDiaChi(diachi);

                khDAO.update(kh);
                return true;
            }
        }
        
        return false;
    }
}
