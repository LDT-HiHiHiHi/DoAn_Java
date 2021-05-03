/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.util.Date;

/**
 *
 * @author pc
 */
public class DanhBa {
   private String sdt, tenLH, ghiChu, Email;
   private Date NgayLuu;
   

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the tenLH
     */
    public String getTenLH() {
        return tenLH;
    }

    /**
     * @param tenLH the tenLH to set
     */
    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }


    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    /**
     * @return the NgayLuu
     */
    public Date getNgayLuu() {
        return NgayLuu;
    }

    /**
     * @param NgayLuu the NgayLuu to set
     */
    public void setNgayLuu(Date NgayLuu) {
        this.NgayLuu = NgayLuu;
    }

        /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public DanhBa() {
    }

    public DanhBa(String sdt, String tenLH, String ghiChu, String Email, Date NgayLuu) {
        this.sdt = sdt;
        this.tenLH = tenLH;
        this.ghiChu = ghiChu;
        this.Email = Email;
        this.NgayLuu = NgayLuu;
    }


    @Override
    public String toString() {
        return this.tenLH; //To change body of generated methods, choose Tools | Templates.
    }


}
