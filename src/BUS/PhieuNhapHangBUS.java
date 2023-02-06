/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.PhieuNhapHangDAO;
import DTO.PhieuNhapHangDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cmduc
 */
public class PhieuNhapHangBUS {
    private ArrayList<PhieuNhapHangDTO> listPN;
    private PhieuNhapHangDAO pnDAO;
    
    public void readDB() throws Exception {
        listPN = new ArrayList<>();
        pnDAO = new PhieuNhapHangDAO();
        listPN = pnDAO.readDB();
    }

    public PhieuNhapHangBUS() throws Exception {
        listPN = new ArrayList<>();
        pnDAO = new PhieuNhapHangDAO();
        listPN = pnDAO.readDB();
    }

    public ArrayList<PhieuNhapHangDTO> getListPN() {
        return listPN;
    }

    public void setListPN(ArrayList<PhieuNhapHangDTO> listPN) {
        this.listPN = listPN;
    }

    public ArrayList<PhieuNhapHangDTO> getListPNByDate(String tungay, String denngay) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<PhieuNhapHangDTO> list = new ArrayList<>();

        Date dFrom, dTo, ngaylap;
        dFrom = df.parse(tungay);
        dTo = df.parse(denngay);

        for (PhieuNhapHangDTO pn : this.getListPN()) {
            ngaylap = df.parse(pn.getNgayLap());
            
            if (ngaylap.compareTo(dFrom) >= 0 && ngaylap.compareTo(dTo) <= 0) {
                list.add(pn);
            }
        }
        
        return list;
    }
    
    public PhieuNhapHangDTO getPN(String id) {
        for (PhieuNhapHangDTO pn : listPN) {
            if (pn.getMaPN().equals(id)) {
                return pn;
            }
        }
        return null;
    }
    public boolean checkPrimary(PhieuNhapHangDTO pn1) {
        for (PhieuNhapHangDTO sp2 : this.getListPN()) {
            if (pn1.getMaPN().equals(sp2.getMaPN())) {
                return false;
            }
        }
        return true;
    }
    public boolean addPN(PhieuNhapHangDTO pn) throws Exception {
        if (checkPrimary(pn)) {
            if (pnDAO.addPN(pn)) {
                this.getListPN().add(pn);
                return true;
            }
        }
    
        return false;
    }
    
    public boolean update(PhieuNhapHangDTO sp1) throws Exception {
        if (pnDAO.update(sp1)) {
            for (PhieuNhapHangDTO sp2 : this.getListPN()) {
                if (sp1.getMaPN().equals(sp2.getMaPN())) {
                    sp2.setTongTien(sp1.getTongTien());                   
                    return true;
                }
            }
        }
        return false;
    }
   
}
