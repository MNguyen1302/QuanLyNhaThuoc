/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author mynguyen
 */
public class SanPhamDTO {
    private static int num = 0;
    private int idNum;
    private String MaThuoc;
    private String TenThuoc;
    private int DonGia;
    private int SoLuong;
    private String DonViTinh;
    private String NgaySanXuat;
    private String HanSuDung;
    private String MaLoaiThuoc;
    private String TrangThai;
    private String Anh;

    public SanPhamDTO() {
        this.idNum = ++num;
        String id = "TH";
        String number = String.valueOf(this.idNum);
        
        for (int i = 0; i < (3 - number.length()); i++) id += "0";
        this.MaThuoc = id + number;
    }

    public SanPhamDTO(String MaThuoc, String TenThuoc, int DonGia, int SoLuong, String DonViTinh, String NgaySanXuat, String HanSuDung, String MaLoaiThuoc, String TrangThai, String Anh) {
        this.MaThuoc = MaThuoc;
        this.TenThuoc = TenThuoc;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.DonViTinh = DonViTinh;
        this.NgaySanXuat = NgaySanXuat;
        this.HanSuDung = HanSuDung;
        this.MaLoaiThuoc = MaLoaiThuoc;
        this.TrangThai = TrangThai;
        this.Anh = Anh;
    }

    public String getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(String MaThuoc) {
        this.MaThuoc = MaThuoc;
    }

    public String getTenThuoc() {
        return TenThuoc;
    }

    public void setTenThuoc(String TenThuoc) {
        this.TenThuoc = TenThuoc;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public String getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(String NgaySanXuat) {
        this.NgaySanXuat = NgaySanXuat;
    }

    public String getHanSuDung() {
        return HanSuDung;
    }

    public void setHanSuDung(String HanSuDung) {
        this.HanSuDung = HanSuDung;
    }

    public String getMaLoaiThuoc() {
        return MaLoaiThuoc;
    }

    public void setMaLoaiThuoc(String MaLoaiThuoc) {
        this.MaLoaiThuoc = MaLoaiThuoc;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }
    
}
