/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author mynguyen
 */
public class KhachHangDTO {
    private static int num = 0;
    private String MaKH, Ho, Ten, DiaChi, SDT;
    private int idNum;

    public KhachHangDTO() {
        this.idNum = ++num;
        String id = "KH";
        String number = String.valueOf(this.idNum);
        
        for (int i = 0; i < (3 - number.length()); i++) id += "0";
        this.MaKH = id + number;
    }

    public KhachHangDTO(String MaKH, String Ho, String Ten, String DiaChi, String SDT) {
        this.MaKH = MaKH;
        this.Ho = Ho;
        this.Ten = Ten;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
