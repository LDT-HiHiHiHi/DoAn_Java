/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author pc
 */
public class NguoiDung {
    private String tenND, email;
    private Date ngaySinh;
    private SQLServerProvider provider = new SQLServerProvider();
   
    /**
     * @return the tenND
     */
    public String getTenND() {
        return tenND;
    }

    /**
     * @param tenND the tenND to set
     */
    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public NguoiDung() {
    }

    public NguoiDung(String tenND, String email, String gioiTinh, Date ngaySinh) {
        this.tenND = tenND;
        this.email = email;
        this.ngaySinh = ngaySinh;
    }
    
    public void DAO_NguoiDung() {
        try {
            provider.open();
            String getThongTinCaNhan = "SELECT * FROM THONGTIN_NGUOIDUNG WHERE MANDN='"+ provider.getMaNDN(DanhBa_GUI.username) +"'";
            ResultSet res = provider.executeQuery(getThongTinCaNhan);
            res.next();
            this.tenND = res.getNString("TENND");
            this.ngaySinh = res.getDate("NGAYSINH");
            this.email = res.getString("EMAIL");
            provider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public String toString() {
        return this.tenND; //To change body of generated methods, choose Tools | Templates.
    }
}
