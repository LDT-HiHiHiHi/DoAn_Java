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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;

/**
 *
 * @author pc
 */
public class ThongTinDanhBa extends JDialog{
    private JTextField tfSDT, tfTenLH, tfGioiTinh, tfEmail, tfNgayLuu, tfNhomLienHe;
    private JMenuItem mniLuu,mniCS,mniQL;
    public ThongTinDanhBa(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        xuLiSuKien();
    }

    private void initComponents() {
        this.setSize(400,350);
        this.setTitle("Thông tin danh bạ");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(this);

        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menuTool = new JMenu("Tools");
        menuTool.setPreferredSize(new Dimension(50, 15));
        menuTool.setMnemonic(KeyEvent.VK_T); // Tạo phím tắt alt_T, Tổ hợp phím sẽ hiện cửa sổ lên và không cần bấm vào menu
        
        Dimension sizeMenu = new Dimension(160, 30);
        mniLuu = new JMenuItem("Lưu");
        mniLuu.setPreferredSize(sizeMenu);
        mniLuu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.ALT_MASK)); // Tạo phím tắt alt_L Tổ hơp phím này sẽ thực hiện mà không cần hiện menu lên
        mniLuu.setEnabled(false);
        menuTool.add(mniLuu);
        menuTool.addSeparator();
        
        mniCS = new JMenuItem("Chỉmh sửa");
        mniCS.setPreferredSize(sizeMenu);
        mniCS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.ALT_MASK)); // Tạo phím tắt alt_C Tổ hơp phím này sẽ thực hiện mà không cần hiện menu lên
        menuTool.add(mniCS);
        menuTool.addSeparator();
        
        mniQL = new JMenuItem("Quay Lại");
        mniQL.setPreferredSize(sizeMenu);
        mniQL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.ALT_MASK)); // Tạo phím tắt alt_Q Tổ hơp phím này sẽ thực hiện mà không cần hiện menu lên
        menuTool.add(mniQL);
        
        menuBar.add(menuTool);
        setJMenuBar(menuBar);
        
        JPanel pnTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnTitle.setPreferredSize(new Dimension(0, 40));
        pnTitle.setBackground(Color.WHITE);
        JLabel lbTitle = new JLabel("Thông Tin Danh Bạ");
        lbTitle.setForeground(Color.blue);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 20));
        pnTitle.add(lbTitle);
        
        Font fontThongTin = new Font("Arial", Font.PLAIN, 14);
        JPanel pnThongTin = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLUE);
        pnThongTin.setBorder(border);
        JPanel pnHienThiThongTin = new JPanel(new GridLayout(6, 2, 0, 15));
        pnThongTin.add(pnHienThiThongTin);  
        
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
        
        Dimension sizeBoxInput = new Dimension(180, 25);
        
        JPanel pnSDT = new JPanel();
        pnSDT.setLayout(new BoxLayout(pnSDT, BoxLayout.Y_AXIS));
        tfSDT = new JTextField();
        tfSDT.setPreferredSize(sizeBoxInput);
        pnSDT.add(tfSDT);
        
        JPanel pnTenLH = new JPanel();
        pnTenLH.setLayout(new BoxLayout(pnTenLH, BoxLayout.Y_AXIS));
        tfTenLH = new JTextField();
        tfTenLH.setPreferredSize(sizeBoxInput);
        pnTenLH.add(tfTenLH);
        
        JPanel pnGT = new JPanel();
        pnGT.setLayout(new BoxLayout(pnGT, BoxLayout.Y_AXIS));
        tfGioiTinh = new JTextField();
        tfGioiTinh.setPreferredSize(sizeBoxInput);
        pnGT.add(tfGioiTinh);
        
        JPanel pnEmail = new JPanel();
        pnEmail.setLayout(new BoxLayout(pnEmail, BoxLayout.Y_AXIS));
        tfEmail = new JTextField();
        tfEmail.setPreferredSize(sizeBoxInput);
        pnEmail.add(tfEmail);
        
        
        JPanel pnNgayLuu = new JPanel();
        pnNgayLuu.setLayout(new BoxLayout(pnNgayLuu, BoxLayout.Y_AXIS));
        tfNgayLuu = new JTextField();
        tfNgayLuu.setPreferredSize(sizeBoxInput);
        pnNgayLuu.add(tfNgayLuu);
        
        JPanel pnNhomLH = new JPanel();
        pnNhomLH.setLayout(new BoxLayout(pnNhomLH, BoxLayout.Y_AXIS));
        tfNhomLienHe = new JTextField();
        tfNhomLienHe.setPreferredSize(sizeBoxInput);
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
       
        con.add(pnTitle, BorderLayout.PAGE_START);
        con.add(pnThongTin,BorderLayout.CENTER);
    }

    private void xuLiSuKien() {
        tfSDT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(tfSDT.getText().equals("0123456789")){
                    tfSDT.setText("");
                    tfSDT.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if(tfSDT.getText().equals("")){
                    tfSDT.setText("0123456789");
                    tfSDT.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
        
        tfTenLH.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(tfTenLH.getText().equals("Tên liên hệ")){
                    tfTenLH.setText("");
                    tfTenLH.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if(tfTenLH.getText().equals("")){
                    tfTenLH.setText("Tên liên hệ");
                    tfTenLH.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
        
        tfGioiTinh.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(tfGioiTinh.getText().equals("Nam /  Nữ")){
                    tfGioiTinh.setText("");
                    tfGioiTinh.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                 if(tfGioiTinh.getText().equals("")){
                    tfGioiTinh.setText("Nam / Nữ");
                    tfGioiTinh.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
        
        tfNgayLuu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(tfNgayLuu.getText().equals("dd/mm/yyyy")){
                    tfNgayLuu.setText("");
                    tfNgayLuu.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
               if(tfNgayLuu.getText().equals("")){
                    tfNgayLuu.setText("dd/mm/yyyy");
                    tfNgayLuu.setForeground(Color.LIGHT_GRAY);
                    }
            }
        });
        
        tfEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(tfEmail.getText().equals("abc@example.com")){
                    tfEmail.setText("");
                    tfEmail.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if(tfEmail.getText().equals("")){
                    tfEmail.setText("abc@example.com");
                    tfEmail.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
        
        tfNhomLienHe.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                 if(tfNhomLienHe.getText().equals("Nhóm liên hệ")){
                    tfNhomLienHe.setText("");
                    tfNhomLienHe.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if(tfNhomLienHe.getText().equals("")){
                    tfNhomLienHe.setText("Nhóm liên hệ");
                    tfNhomLienHe.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
        mniLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mniLuu.setEnabled(false);
            }
        });
        
        mniCS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mniLuu.setEnabled(true);
                tfSDT.requestFocus();
                tfSDT.selectAll();
            }
        });
        
        mniQL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
     }   
}
