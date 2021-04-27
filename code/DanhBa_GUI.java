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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 *
 * @author Admin
 */
public class DanhBa_GUI extends JFrame {

    public DanhBa_GUI() {
        super("Chương trình quản lý danh bạ");
        initComponents();
    }

    public void initComponents() {
        this.setSize(600, 450);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(Main.iconImage));
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());

        JMenuBar mnuBar = new JMenuBar();
        JMenu mnufile = new JMenu("File");
        JMenuItem mnuISave
        con.setJMenuBar(mnuBar);

        JPanel pnTitle = new JPanel(new FlowLayout());
        pnTitle.setPreferredSize(new Dimension(0, 50));
        JLabel lbTitle = new JLabel("Danh Bạ");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pnTitle.add(lbTitle);

        con.add(pnTitle, BorderLayout.PAGE_START);
    }
}
