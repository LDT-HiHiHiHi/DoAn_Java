/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class DangKy extends JDialog {
    private JTextField tfUserName, tfHoTen, tfNgaySinh, tfEmail;
    private JPasswordField pwfPw, repwfPw;
    private JButton btnXacNhan, btnNhapLai, btnQuayLai;
    private JLabel lbErrUserName,lbErrHoten,lbErrPw,lbErrRepPw,lbErrNgaySinh,lbErrEmail;

    public DangKy(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        handle();
    }

    private void initComponents() {

        Dimension sizeBoxInput = new Dimension(200, 30);
        tfUserName = new JTextField("username");
        pwfPw = new JPasswordField("password");
        repwfPw = new JPasswordField("password");
        tfHoTen = new JTextField("Nhập họ tên");
        tfNgaySinh = new JTextField("Nhập ngày sinh: dd/mm/yyyy");
        tfEmail = new JTextField("Nhập email: abc@example.com");

        tfUserName.setForeground(Color.LIGHT_GRAY);
        tfHoTen.setForeground(Color.LIGHT_GRAY);
        tfNgaySinh.setForeground(Color.LIGHT_GRAY);
        tfEmail.setForeground(Color.LIGHT_GRAY);
        pwfPw.setForeground(Color.LIGHT_GRAY);
        repwfPw.setForeground(Color.LIGHT_GRAY);

        btnXacNhan = new JButton("Xác nhận");
        btnNhapLai = new JButton("Nhập lại");
        btnQuayLai = new JButton("Quay lại");

        btnXacNhan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNhapLai.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnQuayLai.setCursor(new Cursor(Cursor.HAND_CURSOR));

        tfUserName.setPreferredSize(sizeBoxInput);
        pwfPw.setPreferredSize(sizeBoxInput);
        repwfPw.setPreferredSize(sizeBoxInput);
        tfHoTen.setPreferredSize(sizeBoxInput);
        tfNgaySinh.setPreferredSize(sizeBoxInput);
        tfEmail.setPreferredSize(sizeBoxInput);

        this.setSize(500,400);
        this.setTitle("Đăng Ký");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(this);

        Container con = getContentPane();
        con.setLayout(new BorderLayout());

        JPanel pnTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnTitle.setPreferredSize(new Dimension(0, 50));
        JLabel lbTitle = new JLabel("Đăng ký thông tin");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 22));
        pnTitle.add(lbTitle);

        Font fontThongTin = new Font("Arial", Font.BOLD, 16);
        JPanel pnThongTin = new JPanel();
        JPanel pnDienThongTin = new JPanel(new GridLayout(6, 2, 0, 5));
        JLabel lbHoten = new JLabel("Họ và tên: ");
        JLabel lbUserName = new JLabel("Tài khoản: ");
        JLabel lbPw = new JLabel("Mật khẩu: ");
        JLabel lbRPw = new JLabel("Nhập lại mật khẩu: ");
        JLabel lbNgaySinh = new JLabel("Ngày sinh: ");
        JLabel lbEmail = new JLabel("Email: ");
        lbHoten.setFont(fontThongTin);
        lbUserName.setFont(fontThongTin);
        lbPw.setFont(fontThongTin);
        lbRPw.setFont(fontThongTin);
        lbNgaySinh.setFont(fontThongTin);
        lbEmail.setFont(fontThongTin);

        Font fontErr = new Font("Arial", Font.PLAIN, 9);
        Dimension sizePInfoAndErr = new Dimension(200, 35);
        JPanel pnHoTen = new JPanel();
        pnHoTen.setLayout(new BoxLayout(pnHoTen, BoxLayout.Y_AXIS));
        pnHoTen.setPreferredSize(sizePInfoAndErr);
        lbErrHoten = new JLabel(" ");
        lbErrHoten.setForeground(Color.RED);
        lbErrHoten.setFont(fontErr);
        pnHoTen.add(tfHoTen);
        pnHoTen.add(lbErrHoten);

        JPanel pnUserName = new JPanel();
        pnUserName.setLayout(new BoxLayout(pnUserName, BoxLayout.Y_AXIS));
        pnUserName.setPreferredSize(sizePInfoAndErr);
        lbErrUserName = new JLabel(" ");
        lbErrUserName.setForeground(Color.RED);
        lbErrUserName.setFont(fontErr);
        pnUserName.add(tfUserName);
        pnUserName.add(lbErrUserName);

        JPanel pnPw = new JPanel();
        pnPw.setLayout(new BoxLayout(pnPw, BoxLayout.Y_AXIS));
        pnPw.setPreferredSize(sizePInfoAndErr);
        lbErrPw = new JLabel(" ");
        lbErrPw.setForeground(Color.RED);
        lbErrPw.setFont(fontErr);
        pnPw.add(pwfPw);
        pnPw.add(lbErrPw);

        JPanel pnRepPw = new JPanel();
        pnRepPw.setLayout(new BoxLayout(pnRepPw, BoxLayout.Y_AXIS));
        pnRepPw.setPreferredSize(sizePInfoAndErr);
        lbErrRepPw = new JLabel(" ");
        lbErrRepPw.setForeground(Color.RED);
        lbErrRepPw.setFont(fontErr);
        pnRepPw.add(repwfPw);
        pnRepPw.add(lbErrRepPw);

        JPanel pnNgaySinh = new JPanel();
        pnNgaySinh.setLayout(new BoxLayout(pnNgaySinh, BoxLayout.Y_AXIS));
        pnNgaySinh.setPreferredSize(sizePInfoAndErr);
        lbErrNgaySinh = new JLabel(" ");
        lbErrNgaySinh.setForeground(Color.RED);
        lbErrNgaySinh.setFont(fontErr);
        pnNgaySinh.add(tfNgaySinh);
        pnNgaySinh.add(lbErrNgaySinh);

        JPanel pnEmail = new JPanel();
        pnEmail.setLayout(new BoxLayout(pnEmail, BoxLayout.Y_AXIS));
        pnEmail.setPreferredSize(sizePInfoAndErr);
        lbErrEmail = new JLabel(" ");
        lbErrEmail.setForeground(Color.RED);
        lbErrEmail.setFont(fontErr);
        pnEmail.add(tfEmail);
        pnEmail.add(lbErrEmail);

        pnDienThongTin.add(lbHoten);
        pnDienThongTin.add(pnHoTen);
        pnDienThongTin.add(lbUserName);
        pnDienThongTin.add(pnUserName);
        pnDienThongTin.add(lbPw);
        pnDienThongTin.add(pnPw);
        pnDienThongTin.add(lbRPw);
        pnDienThongTin.add(pnRepPw);
        pnDienThongTin.add(lbNgaySinh);
        pnDienThongTin.add(pnNgaySinh);
        pnDienThongTin.add(lbEmail);
        pnDienThongTin.add(pnEmail);
        pnThongTin.add(pnDienThongTin);

        JPanel pnControl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnControl.setPreferredSize(new Dimension(0, 50));
        pnControl.add(btnXacNhan);
        pnControl.add(btnNhapLai);
        pnControl.add(btnQuayLai);

        con.add(pnTitle, BorderLayout.PAGE_START);
        con.add(pnThongTin, BorderLayout.CENTER);
        con.add(pnControl, BorderLayout.PAGE_END);
    }

    private boolean isValidEmail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
    }

    private void handle() {
        tfUserName.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent e) {
              if(tfUserName.getText().equals("")) {
                  tfUserName.setText("username");
                  tfUserName.setForeground(Color.LIGHT_GRAY);
              }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(tfUserName.getText().equals("username")) {
                    tfUserName.setText("");
                    tfUserName.setForeground(Color.BLACK);
                }
            }
        });
        tfHoTen.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent e) {
              if(tfHoTen.getText().equals("")) {
                  tfHoTen.setText("Nhập họ tên");
                  tfHoTen.setForeground(Color.LIGHT_GRAY);
              }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(tfHoTen.getText().equals("Nhập họ tên")) {
                    tfHoTen.setText("");
                    tfHoTen.setForeground(Color.BLACK);
                }
            }
        });
        tfEmail.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent e) {
              if(tfEmail.getText().equals("")) {
                  tfEmail.setText("Nhập email: abc@example.com");
                  tfEmail.setForeground(Color.LIGHT_GRAY);
              }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(tfEmail.getText().equals("Nhập email: abc@example.com")) {
                    tfEmail.setText("");
                    tfEmail.setForeground(Color.BLACK);
                }
            }
        });
        tfNgaySinh.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent e) {
              if(tfNgaySinh.getText().equals("")) {
                  tfNgaySinh.setText("Nhập ngày sinh: dd/mm/yyyy");
                  tfNgaySinh.setForeground(Color.LIGHT_GRAY);
              }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(tfNgaySinh.getText().equals("Nhập ngày sinh: dd/mm/yyyy")) {
                    tfNgaySinh.setText("");
                    tfNgaySinh.setForeground(Color.BLACK);
                }
            }
        });
        pwfPw.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent e) {
              if(pwfPw.getText().equals("")) {
                  pwfPw.setText("password");
                  pwfPw.setForeground(Color.LIGHT_GRAY);
              }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(pwfPw.getText().equals("password")) {
                    pwfPw.setText("");
                    pwfPw.setForeground(Color.BLACK);
                }
            }
        });
        repwfPw.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent e) {
              if(repwfPw.getText().equals("")) {
                  repwfPw.setText("password");
                  repwfPw.setForeground(Color.LIGHT_GRAY);
              }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(repwfPw.getText().equals("password")) {
                    repwfPw.setText("");
                    repwfPw.setForeground(Color.BLACK);
                }
            }
        });
        btnXacNhan.addActionListener(ae -> {
            // kiểm tra nhập ngày sinh
            String kieuDinhDang = "dd/MM/yyyy";
            SimpleDateFormat df = new SimpleDateFormat(kieuDinhDang);
            df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
            
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            boolean kt = true;
            
            // kiểm tra nhập email
            if(!isValidEmail(tfEmail.getText())) {
                kt = false;
                lbErrEmail.setText("Email không hợp lệ");
                tfEmail.selectAll();
                tfEmail.requestFocus();
            } else lbErrEmail.setText(" ");

            
            try {
                df.parse(tfNgaySinh.getText());
                lbErrNgaySinh.setText(" ");
            } catch(ParseException ex) {
                kt = false;
                lbErrNgaySinh.setText("Ngày sinh không hợp lệ ("+ kieuDinhDang +").");
                tfNgaySinh.selectAll();
                tfNgaySinh.requestFocus();
            }

            // kiểm tra nhập mật khẩu
            if(pwfPw.getText().trim().equals("")) {
                kt = false;
                lbErrPw.setText("Vui lòng nhập mật khẩu");
                pwfPw.selectAll();
                pwfPw.requestFocus();
            }
            else {
                lbErrPw.setText(" ");
                if(repwfPw.getText().trim().equals("")){
                    kt = false;
                    lbErrRepPw.setText("Vui lòng nhập xác nhập lại mật khẩu");
                    repwfPw.selectAll();
                    repwfPw.requestFocus();
                }
                else {
                    if(!repwfPw.getText().equals(pwfPw.getText())) {
                        kt = false;
                        lbErrRepPw.setText("Xác nhập mật khẩu sai");
                        repwfPw.selectAll();
                        repwfPw.requestFocus();
                    }
                    else
                        lbErrRepPw.setText(" ");
                }
            }

            // kiểm tra nhập username
            if(tfUserName.getText().trim().equals("") || tfUserName.getText().equals("username")){
                kt = false;
                lbErrUserName.setText("Vui lòng điền tên đăng nhập");
                tfUserName.selectAll();
                tfUserName.requestFocus();
            }
            else {
                if(provider.isUId(tfUserName.getText().trim())) {
                    kt = false;
                    lbErrUserName.setText("Tên đăng nhập đã tồn tại");
                    tfUserName.selectAll();
                    tfUserName.requestFocus();
                } else                    
                    lbErrUserName.setText(" ");
            }
                

            // kiểm tra nhập họ tên
            if(tfHoTen.getText().trim().equals("") || tfHoTen.getText().equals("Nhập họ tên")){
                kt = false;
                lbErrHoten.setText("Vui lòng điền họ tên");
                tfHoTen.selectAll();
                tfHoTen.requestFocus();
            } else
                lbErrHoten.setText(" ");

            if(kt == true) {
                String insertThongTinCaNhan = "INSERT INTO THONGTIN_NGUOIDUNG(TENND,EMAIL,NGAYSINH)"+
                                          "VALUES(N'"+tfHoTen.getText().trim()+"','"+tfEmail.getText().trim()+"','"+tfNgaySinh.getText().trim()+"')";
                String insertDN = "INSERT INTO DANGNHAP(TENDANGNHAP,MATKHAU)"+
                                              "VALUES('"+tfUserName.getText().trim()+"','"+pwfPw.getText().trim()+"')";
                
                provider.executeUpdate(insertThongTinCaNhan);
                provider.executeUpdate(insertDN);
                String updateMaNDN_CaNhan = "UPDATE THONGTIN_NGUOIDUNG SET MANDN='"+provider.getMaNDN(tfUserName.getText().trim())+"'"+
                                            " WHERE MAND=(SELECT TOP(1) MAND FROM THONGTIN_NGUOIDUNG ORDER BY MAND DESC)";
                provider.executeUpdate(updateMaNDN_CaNhan);
                this.dispose();
            }
        });
        btnNhapLai.addActionListener(ae -> {
            tfUserName.setText("");
            pwfPw.setText("");
            repwfPw.setText("");
            tfHoTen.setText("");
            tfNgaySinh.setText("");
            tfEmail.setText("");

            lbErrRepPw.setText(" ");
            lbErrPw.setText(" ");
            lbErrEmail.setText(" ");
            lbErrHoten.setText(" ");
            lbErrNgaySinh.setText(" ");
            lbErrUserName.setText(" ");

            tfHoTen.requestFocus();
        });
        btnQuayLai.addActionListener(ae -> {
            this.dispose();
        });
    }
}
