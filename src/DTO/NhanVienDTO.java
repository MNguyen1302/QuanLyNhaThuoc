/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author mynguyen
 */
public class NhanVienDTO {
    private String MaNV, Ho, Ten, SDT, GioiTinh, ViTri;
    
    public NhanVienDTO() {
    }

    public NhanVienDTO(String MaNV, String Ho, String Ten, String SDT, String GioiTinh, String ViTri) {
        this.MaNV = MaNV;
        this.Ho = Ho;
        this.Ten = Ten;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.ViTri = ViTri;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    public void setMaNV(int index) {
        String id = "NV";
        String number = String.valueOf(index);
        
        for (int i = 0; i < (3 - number.length()); i++) id += "0";
        this.MaNV = id + number;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }
}
