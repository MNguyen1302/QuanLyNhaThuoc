/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.ChiTietHDDAO;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author mynguyen
 */
public class ChiTietHDBUS {
    private ArrayList<ChiTietHDDTO> listCTHD;
    
    private ChiTietHDDAO cthdDAO;
    
    public void readDB() throws Exception {
        listCTHD = new ArrayList<>();
        cthdDAO = new ChiTietHDDAO();
        listCTHD = cthdDAO.readDB();
    }

    public ChiTietHDBUS() throws Exception {
        listCTHD = new ArrayList<>();
        cthdDAO = new ChiTietHDDAO();
        listCTHD = cthdDAO.readDB();
    }

    public ArrayList<ChiTietHDDTO> getListCTHD() {
        return listCTHD;
    }

    public void setListCTHD(ArrayList<ChiTietHDDTO> listCTHD) {
        this.listCTHD = listCTHD;
    }
    
    public boolean add(ChiTietHDDTO hd) throws Exception {
        if (cthdDAO.add(hd)) {
            this.getListCTHD().add(hd);
            return true;
        }
    
        return false;
    } 
    
    public boolean checkMaThuoc(String MaHD, String MaSP) {
        for (ChiTietHDDTO cthd : this.getListCTHD()) {
            if (cthd.getMaHD().equals(MaHD) && cthd.getMaThuoc().equals(MaSP)) {
                return true;
            }
        }
        
        return false;
    }
    
}
