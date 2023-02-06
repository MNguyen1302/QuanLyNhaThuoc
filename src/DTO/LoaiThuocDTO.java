/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author mynguyen
 */
public class LoaiThuocDTO {
    private String MaLoai, TenLoai;

    public LoaiThuocDTO() {
    }

    public LoaiThuocDTO(String MaLoai, String TenLoai) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }
    
    public void setMaLoai(int index) {
        String id = "L";
        String number = String.valueOf(index);
        
        for (int i = 0; i < (3 - number.length()); i++) id += "0";
        this.MaLoai = id + number;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }
    
    
}
