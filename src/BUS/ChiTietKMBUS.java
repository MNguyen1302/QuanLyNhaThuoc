/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietKMDAO;
import DTO.ChiTietKMDTO;
import java.util.ArrayList;

/**
 *
 * @author mynguyen
 */
public class ChiTietKMBUS {
    private ArrayList<ChiTietKMDTO> listCTKM;
    
    private ChiTietKMDAO ctkmDAO;
    
    public void readDB() throws Exception {
        listCTKM = new ArrayList<>();
        ctkmDAO = new ChiTietKMDAO();
        listCTKM = ctkmDAO.readDB();
    }

    public ChiTietKMBUS() throws Exception {
        listCTKM = new ArrayList<>();
        ctkmDAO = new ChiTietKMDAO();
        listCTKM = ctkmDAO.readDB();
    }
    
    public ArrayList<ChiTietKMDTO> getListCTKM() {
        return listCTKM;
    }

    public void setListCTKM(ArrayList<ChiTietKMDTO> listCTKM) {
        this.listCTKM = listCTKM;
    }
    
    
    public boolean addCTKM(ChiTietKMDTO ctkm) throws Exception{
        if(checkMa(ctkm)){
            if(ctkmDAO.addCTKM(ctkm)){
                this.listCTKM.add(ctkm);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteCTKM(String maKM, String maProduct) throws Exception{
        for(ChiTietKMDTO ct : listCTKM){
            if(ct.getMaKM().equals(maKM)  &&  ct.getMaThuoc().equals(maProduct))
            {
                if(ctkmDAO.deleteCTKM(ct)){
                    this.listCTKM.remove(ct);
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayList<String> getListMaProductByMaKM(String maKM){
        ArrayList<String> ds = new ArrayList<>();
        for(ChiTietKMDTO ctkm : listCTKM){
            if(maKM.equals(ctkm.getMaKM()))
                ds.add(ctkm.getMaThuoc());
        }
        return ds;
    }
    
    public boolean checkMa(ChiTietKMDTO ctkm){
        for(ChiTietKMDTO ct : listCTKM){
            if(ctkm.getMaKM().equals(ct.getMaKM())  &&  ctkm.getMaThuoc().equals(ct.getMaThuoc()))
                return false;
        }
        return true;
    }
    
        public boolean updateCTKM(ChiTietKMDTO ctkm1) throws Exception {
        if (ctkmDAO.updateCTKM(ctkm1)) {
            for (ChiTietKMDTO ctkm2 : this.getListCTKM()) {
                if (ctkm1.getMaKM().equals(ctkm2.getMaKM())  &&  ctkm1.getMaThuoc().equals(ctkm2.getMaThuoc())) {
                    ctkm2.setTiLeKM(ctkm1.getTiLeKM());
                    
                    return true;
                }
            }
        }
        return false;
    }
}

