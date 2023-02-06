/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.ChiTietPNHDAO;
import DTO.ChiTietPNHDTO;
import java.util.ArrayList;
/**
 *
 * @author cmduc
 */
public class ChiTietPNHBUS {
    private ArrayList<ChiTietPNHDTO> listCTPN;
    
    private ChiTietPNHDAO ctpnDAO;
    
    public void readDB() throws Exception {
        listCTPN = new ArrayList<>();
        ctpnDAO = new ChiTietPNHDAO();
        listCTPN = ctpnDAO.readDB();
    }

    public ChiTietPNHBUS() throws Exception {
        listCTPN = new ArrayList<>();
        ctpnDAO = new ChiTietPNHDAO();
        listCTPN = ctpnDAO.readDB();
    }

    public ArrayList<ChiTietPNHDTO> getListCTPN() {
        return listCTPN;
    }

    public void setListCTPN(ArrayList<ChiTietPNHDTO> listCTPN) {
        this.listCTPN = listCTPN;
    }
    
    
    
        public boolean checkPrimary(ChiTietPNHDTO ctpn1) {
        for (ChiTietPNHDTO ctpn2 : this.getListCTPN()) {
            if (ctpn1.getMaPN().equals(ctpn2.getMaPN())){
                return true;
            }
        }
        return false;
        }

        public boolean deleteDetail(String id,String idsp) throws Exception {
        for (ChiTietPNHDTO  ctpn: this.getListCTPN()) {
            if (ctpn.getMaThuoc().equals(id) && ctpn.getMaPN().equals(idsp)) {
                if (ctpnDAO.deleteDetail(ctpn)) {
                    this.getListCTPN().remove(ctpn);
                    return true;
                }
            }
        }
        
        return false;
    }
      
    
    public boolean addCTPN(ChiTietPNHDTO pn) throws Exception {
        if (ctpnDAO.addCTPN(pn)) {
            this.getListCTPN().add(pn);
            return true;
        }
    
        return false;
    } 
    
}
