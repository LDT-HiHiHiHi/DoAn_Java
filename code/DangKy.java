/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.ParseException;

/**
 *
 * @author Admin
 */
public class DangKy extends JDialog{
    
    private JTextField tfUserName, tfHoTen, tfNgaySinh, tfEmail;
    private JPasswordField pwfPw, repwfPw;
    private JButton btnXacNhan, btnNhapLai;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public DangKy(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        handle();
    }

    private void initComponents() {
        
        Dimension sizeBoxInput = new Dimension(200, 30);
        tfUserName = new JTextField();
        pwfPw = new JPasswordField();
        repwfPw = new JPasswordField();
        tfHoTen = new JTextField();
        tfNgaySinh = new JTextField();
        tfEmail = new JTextField();
        btnXacNhan = new JButton("Xác nhận");
        btnNhapLai = new JButton("Nhập lại");
        btnXacNhan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNhapLai.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tfUserName.setPreferredSize(sizeBoxInput);
        pwfPw.setPreferredSize(sizeBoxInput);
        repwfPw.setPreferredSize(sizeBoxInput);
        tfHoTen.setPreferredSize(sizeBoxInput);
        tfNgaySinh.setPreferredSize(sizeBoxInput);
        tfEmail.setPreferredSize(sizeBoxInput);
        
        this.setSize(500, 450);
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
        JPanel pnDienThongTin = new JPanel(new GridLayout(6, 2, 0, 15));
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
        pnDienThongTin.add(lbHoten);
        pnDienThongTin.add(tfHoTen);
        pnDienThongTin.add(lbUserName);
        pnDienThongTin.add(tfUserName);
        pnDienThongTin.add(lbPw);
        pnDienThongTin.add(pwfPw);
        pnDienThongTin.add(lbRPw);
        pnDienThongTin.add(repwfPw);
        pnDienThongTin.add(lbNgaySinh);
        pnDienThongTin.add(tfNgaySinh);
        pnDienThongTin.add(lbEmail);
        pnDienThongTin.add(tfEmail);
        pnThongTin.add(pnDienThongTin);
        
        JPanel pnControl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnControl.setPreferredSize(new Dimension(0, 60));
        pnControl.add(btnXacNhan);
        pnControl.add(btnNhapLai);
        
        con.add(pnTitle, BorderLayout.PAGE_START);
        con.add(pnThongTin, BorderLayout.CENTER);
        con.add(pnControl, BorderLayout.PAGE_END);
    }

    private void handle() {
        btnXacNhan.addActionListener(ae -> {
            
            //mới thêm vào , nhớ test lại nha
            if("".equals(tfHoTen.getText())){
                tfHoTen.selectAll();
                tfHoTen.requestFocus();
                JOptionPane.showMessageDialog(null,"Nhập lại học tên", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            
            if("".equals(tfUserName.getText())){
                tfUserName.selectAll();
                tfUserName.requestFocus();
                JOptionPane.showMessageDialog(null,"Nhập lại tên đăng nhập", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            
            if("".equals(pwfPw.getText())){
                pwfPw.selectAll();
                pwfPw.requestFocus();
                JOptionPane.showMessageDialog(null,"Nhập lại mật khẩu", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            
            if(repwfPw.getText() == null ? pwfPw.getText() != null : !repwfPw.getText().equals(pwfPw.getText())){
                repwfPw.selectAll();
                repwfPw.requestFocus();
                JOptionPane.showMessageDialog(null,"Nhập lại xác nhận mật khẩu", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            
            df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
            try{
                df.parse(tfNgaySinh.getText());
            }catch(ParseException ex){
                tfNgaySinh.selectAll();
                tfNgaySinh.requestFocus();
                JOptionPane.showMessageDialog(null,"Ngày sinh không hợp lệ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            df.format(tfNgaySinh.getText());
            // hết
            
            this.dispose();
        });
        btnNhapLai.addActionListener(ae -> {
            tfUserName.setText("");
            pwfPw.setText("");
            repwfPw.setText("");
            tfHoTen.setText("");
            tfNgaySinh.setText("");
            tfEmail.setText("");
            tfHoTen.requestFocus();
        });
    }
    
}
