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
    public static String iconImage = "image/icon.png";
    public static String personImage = "/image/person.png";
    public static String saoLuuDangNhap = "saoLuuDangNhap.txt";

    public static void main(String[] args) {
        try {
            java.io.FileInputStream fis = new java.io.FileInputStream(Main.saoLuuDangNhap);
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
            new Login().setVisible(true);
            // e.printStackTrace();
        }
    }
}
