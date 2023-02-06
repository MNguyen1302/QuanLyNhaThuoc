/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author mynguyen
 */
public class ChiTietKMDTO {
    private String MaKM, MaThuoc, TiLeKM;

    public ChiTietKMDTO() {
    }

    public ChiTietKMDTO(String MaKM, String MaThuoc, String TiLeKM) {
        this.MaKM = MaKM;
        this.MaThuoc = MaThuoc;
        this.TiLeKM = TiLeKM;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(String MaThuoc) {
        this.MaThuoc = MaThuoc;
    }

    public String getTiLeKM() {
        return TiLeKM;
    }

    public void setTiLeKM(String TiLeKM) {
        this.TiLeKM = TiLeKM;
    }
    
    
}
