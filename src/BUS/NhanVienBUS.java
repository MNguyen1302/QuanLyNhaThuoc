package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author mynguyen
 */
public class NhanVienBUS {
    private ArrayList<NhanVienDTO> listNV;
    private NhanVienDAO nvDAO;
    
    public NhanVienBUS() throws Exception {
        listNV = new ArrayList<>();
        nvDAO = new NhanVienDAO();
        listNV = nvDAO.readDB();
    }
    
    public void readDB() throws Exception {
        listNV = new ArrayList<>();
        nvDAO = new NhanVienDAO();
        listNV = nvDAO.readDB();
    }

    public ArrayList<NhanVienDTO> getListNV() {
        return listNV;
    }

    public void setListNV(ArrayList<NhanVienDTO> listNV) {
        this.listNV = listNV;
    }
    
    public boolean checkPrimary(NhanVienDTO nv1) {
        for (NhanVienDTO nv2 : this.getListNV()) {
            if (nv1.getMaNV().equals(nv2.getMaNV())) {
                return false;
            }
        }
        return true;
    }
    
    public NhanVienDTO getNV(String id) {
        for (NhanVienDTO nv : listNV) {
            if (nv.getMaNV().equals(id)) {
                return nv;
            }
        }
        return null;
    }
    
    public ArrayList<NhanVienDTO> searchByName(String keyword) {
        ArrayList<NhanVienDTO> tmp = new ArrayList<>();
        
        for (NhanVienDTO nv : this.getListNV()) {
            if (nv.getTen().toLowerCase().contains(keyword.toLowerCase())) {
                tmp.add(nv);
            }
        }
        
        return tmp;
    }
    
    public boolean add(NhanVienDTO nv) throws Exception {
        if (checkPrimary(nv)) {
            if (nvDAO.add(nv)) {
                this.getListNV().add(nv);
                return true;
            }
        }
    
        return false;
    }
    
    public boolean delete(String id) throws Exception {
        for (NhanVienDTO  nv: this.getListNV()) {
            if (nv.getMaNV().equals(id)) {
                nvDAO.delete(nv);
                this.getListNV().remove(nv);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean update(String id, String ho, String ten, String sdt, String gioitinh, String vitri) throws Exception {
        for (NhanVienDTO nv : this.getListNV()) {
            if (nv.getMaNV().equals(id)) {
                nv.setHo(ho);
                nv.setTen(ten);
                nv.setSDT(sdt);
                nv.setGioiTinh(gioitinh);
                nv.setViTri(vitri);
                
                nvDAO.update(nv);

                return true;
            }
        }
        
        return false;
    }
}
