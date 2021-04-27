/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

/**
 *
 * @author Admin
 */
public class Main {
    public static String iconImage = "icon.png";
    public static void main(String[] args) {
        try {
            java.io.FileInputStream fis = new java.io.FileInputStream("saoLuuDangNhap.txt");
            java.io.InputStreamReader isr = new java.io.InputStreamReader(fis, "UTF-8");
            java.io.BufferedReader br = new java.io.BufferedReader(isr);
            String thongTinDangNhap = br.readLine();
            if (thongTinDangNhap == "")
                new Login().setVisible(true);
            else {
                String[] splitThongTin = thongTinDangNhap.split("-");
                new DanhBa_GUI().setVisible(true);
            }
            br.close();
            isr.close();
            fis.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
