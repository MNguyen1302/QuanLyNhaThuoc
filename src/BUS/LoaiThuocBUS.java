/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiThuocDAO;
import DTO.LoaiThuocDTO;
import java.util.ArrayList;

/**
 *
 * @author mynguyen
 */
public class LoaiThuocBUS {
    private ArrayList<LoaiThuocDTO> listLT;
    private LoaiThuocDAO loaiDAO;
    
    public void readDB() throws Exception {
        listLT = new ArrayList<>();
        loaiDAO = new LoaiThuocDAO();
        listLT = loaiDAO.readDB();
    }

    public LoaiThuocBUS() throws Exception {
        listLT = new ArrayList<>();
        loaiDAO = new LoaiThuocDAO();
        listLT = loaiDAO.readDB();
    }

    public ArrayList<LoaiThuocDTO> getListLT() {
        return listLT;
    }

    public void setListLT(ArrayList<LoaiThuocDTO> listLT) {
        this.listLT = listLT;
    }
    
    public ArrayList<LoaiThuocDTO> searchById(ArrayList<LoaiThuocDTO> list, String keyword) {
        ArrayList<LoaiThuocDTO> tmp = new ArrayList<>();
        
        for (LoaiThuocDTO l : list) {
            if (l.getMaLoai().toLowerCase().contains(keyword.toLowerCase())) {
                tmp.add(l);
            }
        }
        
        return tmp;
    }
    
    public ArrayList<LoaiThuocDTO> searchByName(ArrayList<LoaiThuocDTO> list, String keyword) {
        ArrayList<LoaiThuocDTO> tmp = new ArrayList<>();
        
        for (LoaiThuocDTO l : list) {
            if (l.getTenLoai().toLowerCase().contains(keyword.toLowerCase())) {
                tmp.add(l);
            }
        }
        
        return tmp;
    }
    
    public boolean checkPrimary(LoaiThuocDTO l1) {
        for (LoaiThuocDTO l2 : this.getListLT()) {
            if (l1.getMaLoai().equals(l2.getMaLoai())) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean add(LoaiThuocDTO loai) throws Exception {
        if (checkPrimary(loai)) {
            if (loaiDAO.add(loai)) {
                this.getListLT().add(loai);
                return true;
            }
        }
        return false;
    }
    
    public boolean delete(LoaiThuocDTO loai1) throws Exception {
        if (loaiDAO.delete(loai1)) {
            for (LoaiThuocDTO loai2: this.getListLT()) {
                if (loai1.getMaLoai().equals(loai2.getMaLoai())) {
                    this.getListLT().remove(loai1);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean update(LoaiThuocDTO loai1) throws Exception {
        if (loaiDAO.update(loai1)) {
            for (LoaiThuocDTO loai2 : this.getListLT()) {
                if (loai1.getMaLoai().equals(loai2.getMaLoai())) {
                    loai2.setMaLoai(loai1.getMaLoai());
                    loai2.setTenLoai(loai1.getTenLoai());
                    
                    return true;
                }
            }
        }
        return false;
    }
}
