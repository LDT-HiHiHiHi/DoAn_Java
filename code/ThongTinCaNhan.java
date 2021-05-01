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
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author pc
 */
public class ThongTinCaNhan extends JDialog{
    private JTextField tfTen, tfEmail, tfNgaySinh;
    private JMenuItem mniLuu,mniCS,mniDX;
    private SQLServerProvider provider = new SQLServerProvider();
    private JFrame frameParent;
    private JButton btnQuayLai;
    
    public ThongTinCaNhan(JFrame parent, boolean modal) {
        super(parent, modal);
        frameParent = parent;
        initComponents();
        loadData();
        xuLiSuKien();
    }

    private void initComponents() {
        this.setSize(400,270);
        this.setTitle("Thông tin cá nhân");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(Main.iconImage));
        this.setResizable(false);

        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menuTool = new JMenu("Tools");
        menuTool.setPreferredSize(new Dimension(50, 15));
        menuTool.setMnemonic(KeyEvent.VK_T);
        
        Dimension sizeMenu = new Dimension(160, 30);
        mniLuu = new JMenuItem("Lưu");
        mniLuu.setPreferredSize(sizeMenu);
        mniLuu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); 
        mniLuu.setEnabled(false);
        menuTool.add(mniLuu);
        menuTool.addSeparator();
        
        mniCS = new JMenuItem("Chỉmh sửa");
        mniCS.setPreferredSize(sizeMenu);
        mniCS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK)); 
        menuTool.add(mniCS);
        menuTool.addSeparator();
        
        mniDX = new JMenuItem("Đăng xuất");
        mniDX.setPreferredSize(sizeMenu);
        mniDX.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK)); 
        menuTool.add(mniDX);
        
        menuBar.add(menuTool);
        setJMenuBar(menuBar);
        
        JPanel pnTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnTitle.setPreferredSize(new Dimension(0, 40));
        pnTitle.setBackground(Color.WHITE);
        JLabel lbTitle = new JLabel("Thông Tin Cá Nhân");
        lbTitle.setForeground(Color.blue);
        lbTitle.setFont(new Font("Arial", Font.BOLD, 20));
        pnTitle.add(lbTitle);
        
        Font fontThongTin = new Font("Arial", Font.PLAIN, 14);
        JPanel pnThongTin = new JPanel();
        pnThongTin.setBackground(Color.WHITE);
        JPanel pnHienThiThongTin = new JPanel(new GridLayout(3, 2, 0, 15));
        pnHienThiThongTin.setBackground(Color.WHITE);
        pnThongTin.add(pnHienThiThongTin);  
        
        JLabel lbTen = new JLabel("Tên người dùng: ");
        JLabel lbNgaySinh = new JLabel("Ngày sinh: ");
        JLabel lbEmail = new JLabel("Email: ");

        
        lbTen.setFont(fontThongTin);
        lbEmail.setFont(fontThongTin);
        lbNgaySinh.setFont(fontThongTin);
        
        Dimension sizeBoxInput = new Dimension(180, 25);
        
        JPanel pnTen = new JPanel();
        pnTen.setLayout(new BoxLayout(pnTen, BoxLayout.Y_AXIS));
        tfTen = new JTextField();
        tfTen.setPreferredSize(sizeBoxInput);
        pnTen.add(tfTen);
        
        JPanel pnEmail = new JPanel();
        pnEmail.setLayout(new BoxLayout(pnEmail, BoxLayout.Y_AXIS));
        tfEmail = new JTextField();
        tfEmail.setPreferredSize(sizeBoxInput);
        pnEmail.add(tfEmail);
        
        JPanel pnNgaySinh = new JPanel();
        pnNgaySinh.setLayout(new BoxLayout(pnNgaySinh, BoxLayout.Y_AXIS));
        tfNgaySinh = new JTextField();
        tfNgaySinh.setPreferredSize(sizeBoxInput);
        pnNgaySinh.add(tfNgaySinh);
        
        pnHienThiThongTin.add(lbTen);
        pnHienThiThongTin.add(pnTen);
        pnHienThiThongTin.add(lbNgaySinh);
        pnHienThiThongTin.add(pnNgaySinh);
        pnHienThiThongTin.add(lbEmail);
        pnHienThiThongTin.add(pnEmail);
        
        JPanel pnFooter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnFooter.setBackground(Color.WHITE);
        btnQuayLai = new JButton("Quay lại");
        btnQuayLai.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnFooter.add(btnQuayLai);
        
        con.add(pnTitle, BorderLayout.PAGE_START);
        con.add(pnThongTin,BorderLayout.CENTER);
        con.add(pnFooter,BorderLayout.PAGE_END);
    }

    private void xuLiSuKien() {
        tfTen.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(tfTen.getText().equals("Tên người dùng")){
                    tfTen.setText("");
                    tfTen.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if(tfTen.getText().equals("")){
                    tfTen.setText("Tên người dùng");
                    tfTen.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
        
       tfNgaySinh.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if(tfNgaySinh.getText().equals("dd/mm/yyyy")){
                    tfNgaySinh.setText("");
                    tfNgaySinh.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                 if(tfNgaySinh.getText().equals("")){
                    tfNgaySinh.setText("dd/mm/yyyy");
                    tfNgaySinh.setForeground(Color.LIGHT_GRAY);
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
       
        mniLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    // kiểm tra nhập ngày sinh
                String kieuDinhDang = "dd/MM/yyyy";
                SimpleDateFormat df = new SimpleDateFormat(kieuDinhDang);
                df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....

                provider.open();
                boolean kt = true;

                // kiểm tra nhập email
                if(!isValidEmail(tfEmail.getText())) {
                    kt = false;
                    tfEmail.selectAll();
                    tfEmail.requestFocus();
                }


                try {
                    df.parse(tfNgaySinh.getText());
                } catch(Exception ex) {
                    kt = false;
                    tfNgaySinh.selectAll();
                    tfNgaySinh.requestFocus();
                }  

                // kiểm tra nhập họ tên
                if(tfTen.getText().trim().equals("") || tfTen.getText().equals("Nhập họ tên")){
                    kt = false;
                    tfTen.selectAll();
                    tfTen.requestFocus();
                }

                if(kt == true) {
                    String updateThongTinCaNhan = "UPDATE THONGTIN_NGUOIDUNG SET TENND="+
                                                  "N'"+tfTen.getText().trim()+"', EMAIL='"+tfEmail.getText().trim()+"', NGAYSINH='"+tfNgaySinh.getText().trim()+"' "+
                                                  "WHERE MANDN='"+provider.getMaNDN(DanhBa_GUI.username)+"'";

                    provider.executeUpdate(updateThongTinCaNhan);
                }
                mniLuu.setEnabled(false);
                tfEmail.setEditable(false);           
                tfNgaySinh.setEditable(false);
                tfTen.setEditable(false);
            }
        });
        
        mniCS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfEmail.setEditable(true);           
                tfNgaySinh.setEditable(true);
                tfTen.setEditable(true);
                
                mniLuu.setEnabled(true);
                tfTen.requestFocus();
                tfTen.selectAll();
            }
        });
        
        mniDX.addActionListener(new ActionListener() {
            String updateTT = "UPDATE DANGNHAP SET TRANGTHAI='DISCONNECT' WHERE TENDANGNHAP='" + DanhBa_GUI.username +"'";
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileOutputStream fos = new FileOutputStream(Main.saoLuuDangNhap);
                    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write("");
                    bw.close();
                    osw.close();
                    fos.close();
                    provider.open();
                    provider.executeUpdate(updateTT);
                    provider.close();
                    new Login().setVisible(true);
                    frameParent.dispose();
                } catch (Exception e) {
                }
                
            }
        });
        btnQuayLai.addActionListener(ae -> {
            dispose();
        });
     }   

    private void loadData() {
        try {
            String kieuDinhDang = "dd/MM/yyyy";
            SimpleDateFormat df = new SimpleDateFormat(kieuDinhDang);
            df.setLenient(false);
            
            NguoiDung nd = new NguoiDung();
            nd.DAO_NguoiDung();
            
            tfTen.setText(nd.getTenND());
            tfNgaySinh.setText(df.format(nd.getNgaySinh()));
            tfEmail.setText(nd.getEmail());
            
            tfEmail.setEditable(false);           
            tfNgaySinh.setEditable(false);
            tfTen.setEditable(false);

        } catch (Exception e) {
            
        }
    }
    private boolean isValidEmail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
    }
}
