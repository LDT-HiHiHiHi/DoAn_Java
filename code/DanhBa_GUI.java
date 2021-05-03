/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qldb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Event;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.KeyStroke;

/**
 *
 * @author Admin
 */
public class DanhBa_GUI extends JFrame {
    private JComboBox cboNhomLH;
    private JList lstDanhBa;
    private JMenu mnuLogout;
    private JMenuItem mnuISaoLuu, mnuIKhoiPhuc, mnuIThemDanhBa;
    private JLabel lbFooter;
    public static String username;
    private DefaultComboBoxModel<NhomLienHe> dfcmb;
    private DefaultListModel<DanhBa> dflst;
    private SQLServerProvider provider = new SQLServerProvider();
    private ResultSet res;

    public DanhBa_GUI(String uid) {
        super("Chương trình quản lý danh bạ");
        provider.open();
        username = uid;
        provider.close();
        initComponents();
        handle();
        
    }

    private void initComponents() {
        this.setSize(400, 450);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(Main.iconImage));
        this.setResizable(false);

        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());

        JMenuBar mnuBar = new JMenuBar();

        JMenu mnuTools = new JMenu("Tools");

        mnuLogout = new JMenu("Logout");

        mnuISaoLuu = new JMenuItem("Sao Lưu       ");
        mnuISaoLuu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | Event.SHIFT_MASK));

        mnuIKhoiPhuc = new JMenuItem("Khôi Phục       ");
        mnuIKhoiPhuc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK | Event.SHIFT_MASK));
        
        mnuIThemDanhBa = new JMenuItem("Thêm danh bạ       ");
        mnuIThemDanhBa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        
        mnuTools.add(mnuIThemDanhBa);
        mnuTools.add(new JSeparator());
        mnuTools.add(mnuISaoLuu);
        mnuTools.add(new JSeparator());
        mnuTools.add(mnuIKhoiPhuc);

        mnuBar.add(mnuTools);
        mnuBar.add(mnuLogout);
        this.setJMenuBar(mnuBar);
        
        provider.open();
        try {
            String selectDanhBa = "SELECT * FROM THONGTINDANHBA INNER JOIN DANHBA ON THONGTINDANHBA.MADB=DANHBA.MADB WHERE MANDN='"+provider.getMaNDN(username)+"'";
            res = provider.executeQuery(selectDanhBa);
            while(res.next()) {
                vDB.add(new DanhBa(res.getString("SDT"), res.getString("TENDANHBA"), res.getString("GHICHU"), res.getString("EMAIL"), res.getDate("NGAYLUU")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        provider.close();
        
        
        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(new BoxLayout(pnTitle, BoxLayout.Y_AXIS));
        pnTitle.setPreferredSize(new Dimension(0, 75));
        pnTitle.setBackground(Color.WHITE);

        JLabel lbTitle = new JLabel("Danh Bạ");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel pnNhomLH = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnNhomLH.setBackground(Color.WHITE);
        cboNhomLH = new JComboBox(nhomLH);
        cboNhomLH.setSelectedIndex(0);
        pnNhomLH.add(cboNhomLH);

        pnTitle.add(lbTitle);
        pnTitle.add(pnNhomLH);

        String[] danhBa = {
            "Nguyễn Văn A",
            "Trần Văn C",
            "Gia Cát Lượng"
        };
        JPanel pnContent = new JPanel();
        pnContent.setBackground(Color.WHITE);
        lstDanhBa = new JList(danhBa);
        lstDanhBa.setCellRenderer(new PhoneBookListRenderer());
        JScrollPane scrollLstDanhBa = new JScrollPane(lstDanhBa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollLstDanhBa.setPreferredSize(new Dimension(392, 270));
        scrollLstDanhBa.setBorder(new EmptyBorder(0, 5, 0, 5));
        pnContent.add(scrollLstDanhBa);

        JPanel pnFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbFooter = new  JLabel(username+" |");
        pnFooter.add(lbFooter);

        con.add(pnTitle, BorderLayout.PAGE_START);
        con.add(pnContent, BorderLayout.CENTER);
        con.add(pnFooter, BorderLayout.PAGE_END);
    }
    private void handle() {
        JFrame thisFrame = this;

        mnuLogout.addMouseListener(new MouseAdapter() {
            String updateTT = "UPDATE DANGNHAP SET TRANGTHAI='DISCONNECT' WHERE TENDANGNHAP='" + username +"'";
            public void mouseClicked(MouseEvent evt) {
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
                    thisFrame.dispose();
                } catch(Exception e) {

                }
            }
        });
        
        mnuIThemDanhBa.addActionListener(ae -> {
            new ThemDanhBa(thisFrame, true).setVisible(true);
        });

        lstDanhBa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                new ThongTinDanhBa(thisFrame, true).setVisible(true);
            }
        });

        lbFooter.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                new ThongTinCaNhan(thisFrame, true).setVisible(true);
            }
        });
    }
}
