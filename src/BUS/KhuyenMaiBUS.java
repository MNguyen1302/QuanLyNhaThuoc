/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;
import java.util.HashMap;

public class KhuyenMaiBUS {
    private ArrayList<KhuyenMaiDTO> listKM;
    private KhuyenMaiDAO kmDAO;
    
    public KhuyenMaiBUS() throws Exception {
        listKM = new ArrayList<>();
        kmDAO = new KhuyenMaiDAO();
        listKM = kmDAO.readDB();
    }
    
    public void readDB() throws Exception {
        listKM = new ArrayList<>();
        kmDAO = new KhuyenMaiDAO();
        listKM = kmDAO.readDB();
    }

    public ArrayList<KhuyenMaiDTO> getListKM() {
        return listKM;
    }

    public void setListKM(ArrayList<KhuyenMaiDTO> listKM) {
        this.listKM = listKM;
    }

    public KhuyenMaiDTO getKM(String id) {
        for (KhuyenMaiDTO km : listKM) {
            if (km.getMaKM().equals(id)) {
                return km;
            }
        }
        return null;
    }
    
    public boolean checkPrimary(KhuyenMaiDTO km1) {
        for (KhuyenMaiDTO km2 : this.getListKM()) {
            if (km1.getMaKM().equals(km2.getMaKM())) {
                return false;
            }
        }
        return true;
    }
    
    
    public ArrayList<String> getListMaKM(){
        ArrayList<String> ds = new ArrayList<>();
        for(KhuyenMaiDTO km : listKM){
            ds.add(km.getMaKM());
        }
        return ds;
    }
    
    public boolean checkHopLe(String makm){
        for(KhuyenMaiDTO km : this.getListKM()){
            if(km.getMaKM().equals(makm))
                return true;
        }
        return false;
    }
    
    

    public boolean addKhuyenMai(KhuyenMaiDTO km) throws Exception {
        if(checkPrimary(km))
        {
           if(kmDAO.addKhuyenMai(km))
               this.getListKM().add(km);
               return true;
        }
        return false;
    }
    
    
    public boolean updateKhuyenMai(KhuyenMaiDTO km1) throws Exception {
        if (kmDAO.updateKhuyenMai(km1)) {
            for (KhuyenMaiDTO km2 : this.getListKM()) {
                if (km1.getMaKM().equals(km2.getMaKM())) {
                    km2.setTenKM(km1.getTenKM());
                    km2.setNgayBatDau(km1.getNgayBatDau());
                    km2.setNgayKetThuc(km1.getNgayKetThuc());
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deleteKhuyenMai(String id) throws Exception {
        for (KhuyenMaiDTO  km: this.getListKM()) {
            if (km.getMaKM().equals(id)) {
                if (kmDAO.deleteKhuyenMai(km)) {
                    this.getListKM().remove(km);
                    return true;
                }
            }
        }
        
        return false;
    }
}

