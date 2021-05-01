/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.border.Border;

/**
 *
 * @author pc
 */
public class ThongTinCaNhan extends JDialog{
    private JTextField tfTen, tfEmail, tfNgaySinh;
    private JMenuItem mniLuu,mniCS,mniDX;
    public ThongTinCaNhan(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        xuLiSuKien();
    }

    private void initComponents() {
        this.setSize(400,250);
        this.setTitle("Thông tin cá nhân");
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
        
        mniDX = new JMenuItem("Đăng xuất");
        mniDX.setPreferredSize(sizeMenu);
        mniDX.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK)); // Tạo phím tắt alt_E Tổ hơp phím này sẽ thực hiện mà không cần hiện menu lên
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
        Border border = BorderFactory.createLineBorder(Color.BLUE);
        pnThongTin.setBorder(border);
        JPanel pnHienThiThongTin = new JPanel(new GridLayout(3, 2, 0, 15));
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

        con.add(pnTitle, BorderLayout.PAGE_START);
        con.add(pnThongTin,BorderLayout.CENTER);
    }

    private void xuLiSuKien() {
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
                tfTen.requestFocus();
                tfTen.selectAll();
            }
        });
        
        mniDX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
     }   
}
