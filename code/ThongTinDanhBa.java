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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;

/**
 *
 * @author pc
 */
public class ThongTinDanhBa extends JDialog{
    private JTextField tfSDT, tfTenLH, tfGioiTinh, tfEmail, tfNgayLuu, tfNhomLienHe;
    private JButton btnQuayLai,btnLuu;

    public ThongTinDanhBa(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        xuLiSuKien();
    }

    private void initComponents() {
        this.setSize(500,400);
        this.setTitle("Thông tin danh bạ");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(this);

        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        
        Dimension sizeBoxInput = new Dimension(200, 30);
        
        tfTenLH = new JTextField();
        tfSDT = new JTextField();
        tfGioiTinh = new JTextField();
        tfNgayLuu = new JTextField();
        tfEmail = new JTextField();
        tfNhomLienHe = new JTextField();
        
        tfSDT.setPreferredSize(sizeBoxInput);
        tfTenLH.setPreferredSize(sizeBoxInput);
        tfGioiTinh.setPreferredSize(sizeBoxInput);
        tfNgayLuu.setPreferredSize(sizeBoxInput);
        tfEmail.setPreferredSize(sizeBoxInput);
        tfNhomLienHe.setPreferredSize(sizeBoxInput);
        
        btnQuayLai = new JButton("Quay Lại");
        btnLuu = new JButton("   Lưu   ");
        btnLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnQuayLai.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JPanel pnTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnTitle.setPreferredSize(new Dimension(0, 50));
        pnTitle.setBackground(Color.WHITE);
        JLabel lbTitle = new JLabel("Thông Tin Danh Bạ");
        lbTitle.setForeground(Color.blue);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 22));
        pnTitle.add(lbTitle);
        
        Font fontThongTin = new Font("Arial", Font.BOLD, 16);
        JPanel pnThongTin = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLUE);
        pnThongTin.setBorder(border);
        JPanel pnHienThiThongTin = new JPanel(new GridLayout(6, 2, 0, 15));
        
        JLabel lbSDT = new JLabel("Số điện thoại: ");
        JLabel lbTenLH = new JLabel("Tên liên hệ: ");
        JLabel lbGioiTinh = new JLabel("Giới  tính: ");
        JLabel lbNgayLuu = new JLabel("Ngày lưu: ");
        JLabel lbEmail = new JLabel("Email: ");
        JLabel lbNhomLienHe = new JLabel("Nhóm liên hệ: ");
        
        lbSDT.setFont(fontThongTin);
        lbTenLH.setFont(fontThongTin);
        lbGioiTinh.setFont(fontThongTin);
        lbNgayLuu.setFont(fontThongTin);
        lbEmail.setFont(fontThongTin);
        lbNhomLienHe.setFont(fontThongTin);
        
        JPanel pnSDT = new JPanel();
        pnSDT.setLayout(new BoxLayout(pnSDT, BoxLayout.Y_AXIS));
        
        JPanel pnTenLH = new JPanel();
        pnTenLH.setLayout(new BoxLayout(pnTenLH, BoxLayout.Y_AXIS));
        
        JPanel pnGT = new JPanel();
        pnGT.setLayout(new BoxLayout(pnGT, BoxLayout.Y_AXIS));
        
        JPanel pnEmail = new JPanel();
        pnEmail.setLayout(new BoxLayout(pnEmail, BoxLayout.Y_AXIS));
        
        JPanel pnNgayLuu = new JPanel();
        pnNgayLuu.setLayout(new BoxLayout(pnNgayLuu, BoxLayout.Y_AXIS));
        
        JPanel pnNhomLH = new JPanel();
        pnNhomLH.setLayout(new BoxLayout(pnNhomLH, BoxLayout.Y_AXIS));
        
        pnSDT.add(tfSDT);
        pnTenLH.add(tfTenLH);
        pnGT.add(tfGioiTinh);
        pnNgayLuu.add(tfNgayLuu);
        pnEmail.add(tfEmail);
        pnNhomLH.add(tfNhomLienHe);
        
        pnHienThiThongTin.add(lbSDT);
        pnHienThiThongTin.add(pnSDT);
        pnHienThiThongTin.add(lbTenLH);
        pnHienThiThongTin.add(pnTenLH);
        pnHienThiThongTin.add(lbGioiTinh);
        pnHienThiThongTin.add(pnGT);
        pnHienThiThongTin.add(lbNgayLuu);
        pnHienThiThongTin.add(pnNgayLuu);
        pnHienThiThongTin.add(lbEmail);
        pnHienThiThongTin.add(pnEmail);
        pnHienThiThongTin.add(lbNhomLienHe);
        pnHienThiThongTin.add(pnNhomLH);
        
        pnThongTin.add(pnHienThiThongTin);  
        
        JPanel pnNut = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnNut.add(btnLuu);
        pnNut.add(btnQuayLai);
        
        
        con.add(pnTitle, BorderLayout.PAGE_START);
        con.add(pnThongTin,BorderLayout.CENTER);
        con.add(pnNut,BorderLayout.PAGE_END);
    }

    private void xuLiSuKien() {
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int n = JOptionPane.showConfirmDialog(null,"Quay Lại ?","Message",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
                if(n == JOptionPane.OK_OPTION)
                    System.exit(0);
            }
        });
        
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               tfSDT.getText();
               tfTenLH.getText();
               tfGioiTinh.getText();
               tfNgayLuu.getText();
               tfEmail.getText();
               tfNhomLienHe.getText();
            }
        });
    }
}
