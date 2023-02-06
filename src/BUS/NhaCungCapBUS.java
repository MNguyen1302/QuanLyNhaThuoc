/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.LoaiThuocDTO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author mynguyen
 */
public class NhaCungCapBUS {
    private ArrayList<NhaCungCapDTO> listNCC;
    private NhaCungCapDAO nccDAO;
    
    public void readDB() throws Exception {
        listNCC = new ArrayList<>();
        nccDAO = new NhaCungCapDAO();
        listNCC = nccDAO.readDB();
    }

    public NhaCungCapBUS() throws Exception {
        listNCC = new ArrayList<>();
        nccDAO = new NhaCungCapDAO();
        listNCC = nccDAO.readDB();
    }

    public ArrayList<NhaCungCapDTO> getListNCC() {
        return listNCC;
    }
public NhaCungCapDTO getNCC(String id) {
        for (NhaCungCapDTO ncc : listNCC) {
            if (ncc.getMaNCC().equals(id)) {
                return ncc;
            }
        }
        return null;
    }
    public void setListNCC(ArrayList<NhaCungCapDTO> listNCC) {
        this.listNCC = listNCC;
    }
    
    public boolean checkPrimary(NhaCungCapDTO ncc1) {
        for (NhaCungCapDTO ncc2 : this.getListNCC()) {
            if (ncc1.getMaNCC().equals(ncc2.getMaNCC())) {
                return false;
            }
        }
        
        return true;
    }
    
    public ArrayList<NhaCungCapDTO> searchById(ArrayList<NhaCungCapDTO> list, String keyword) {
        ArrayList<NhaCungCapDTO> tmp = new ArrayList<>();
        
        for (NhaCungCapDTO ncc : list) {
            if (ncc.getMaNCC().toLowerCase().contains(keyword.toLowerCase())) {
                tmp.add(ncc);
            }
        }
        
        return tmp;
    }
    
    public ArrayList<NhaCungCapDTO> searchByName(ArrayList<NhaCungCapDTO> list, String keyword) {
        ArrayList<NhaCungCapDTO> tmp = new ArrayList<>();
        
        for (NhaCungCapDTO ncc : list) {
            if (ncc.getTenNCC().toLowerCase().contains(keyword.toLowerCase())) {
                tmp.add(ncc);
            }
        }
        
        return tmp;
    }
    
    public boolean add(NhaCungCapDTO ncc) throws Exception {
        if (checkPrimary(ncc)) {
            if (nccDAO.add(ncc)) {
                this.getListNCC().add(ncc);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean deletencc(String id) throws Exception {
        for (NhaCungCapDTO  ncc: this.getListNCC()) {
            if (ncc.getMaNCC().equals(id)) {
                if (nccDAO.delete(ncc)) {
                    this.getListNCC().remove(ncc);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean updatencc(NhaCungCapDTO ncc1) throws Exception {
        if (nccDAO.update(ncc1)) {
            for (NhaCungCapDTO ncc2 : this.getListNCC()) {
                if (ncc1.getMaNCC().equals(ncc2.getMaNCC())) {
                    ncc2.setMaNCC(ncc1.getMaNCC());
                    ncc2.setTenNCC(ncc1.getTenNCC());
                    ncc2.setSDT(ncc1.getSDT());
                    ncc2.setDiaChi(ncc1.getDiaChi());
                    
                    return true;
                }
            }
        }
        return false;
    }
}
