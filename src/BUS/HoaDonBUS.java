/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Methods;

public class HoaDonBUS {
    private ArrayList<HoaDonDTO> listHD;
    private HoaDonDAO hdDAO;
    
    public void readDB() throws Exception {
        listHD = new ArrayList<>();
        hdDAO = new HoaDonDAO();
        listHD = hdDAO.readDB();
    }

    public HoaDonBUS() throws Exception {
        listHD = new ArrayList<>();
        hdDAO = new HoaDonDAO();
        listHD = hdDAO.readDB();
    }

    public ArrayList<HoaDonDTO> getListHD() {
        return listHD;
    }

    public void setListHD(ArrayList<HoaDonDTO> listHD) {
        this.listHD = listHD;
    }
    
    public HoaDonDTO getHD(String id) {
        for (HoaDonDTO sp : listHD) {
            if (sp.getMaHD().equals(id)) {
                return sp;
            }
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHDByDate(String tungay, String denngay) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<HoaDonDTO> list = new ArrayList<>();

        Date dFrom, dTo, ngaylap;
        dFrom = df.parse(tungay);
        dTo = df.parse(denngay);

        for (HoaDonDTO hd : this.getListHD()) {
            ngaylap = df.parse(hd.getNgayLap());

            if (ngaylap.compareTo(dFrom) >= 0 && ngaylap.compareTo(dTo) <= 0) {
                list.add(hd);
            }
        }
        
        return list;
    }
    
    public boolean checkPrimary(HoaDonDTO hd1) {
        for (HoaDonDTO hd2 : this.getListHD()) {
            if (hd1.getMaHD().equals(hd2.getMaHD())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean add(HoaDonDTO hd) throws Exception {
        if (checkPrimary(hd)) {
            if (hdDAO.add(hd)) {
                this.getListHD().add(hd);
                return true;
            }
        }
    
        return false;
    } 
    
    public boolean update(HoaDonDTO sp1) throws Exception {
        if (hdDAO.update(sp1)) {
            for (HoaDonDTO sp2 : this.getListHD()) {
                if (sp1.getMaHD().equals(sp2.getMaHD())) {
                    sp2.setTongTien(sp1.getTongTien());
                    
                    return true;
                }
            }
        }
        return false;
    }
    
    public int tongDoanhThuTheoQuy(int nam, int quy) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date[] dates = Methods.getNgayTheoQuy(nam, quy);
        Date ngayBD, ngayKT, ngaylap;
        ngayBD = dates[0];
        ngayKT = dates[1];
        int sum = 0;

        for (HoaDonDTO hd : this.getListHD()) {
            String[] d = hd.getNgayLap().split("-");
            ngaylap = df.parse(d[2] + "-" + d[1] + "-" + d[0]);

            if (ngaylap.compareTo(ngayBD) >= 0 && ngaylap.compareTo(ngayKT) < 0) {
                sum += hd.getTongTien();
            }
        }
        
        return sum;
    }
    
}
