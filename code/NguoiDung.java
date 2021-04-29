/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.util.Date;

public class NguoiDung {
    private String maNguoiDung, tenDN, hoTen, email;
    private Date ngaySinh;

    public NguoiDung() {
      this.maNguoiDung = "";
      this.tenDN = "";
      this.ngaySinh = "1/1/1990";
      this.hoTen = "";
      this.email = "";
    }
    

    @Override
    public String toString() {
        return this.hoTen; //To change body of generated methods, choose Tools | Templates.
    }
}
