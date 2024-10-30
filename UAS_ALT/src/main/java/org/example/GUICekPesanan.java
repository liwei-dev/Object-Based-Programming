package org.example;

import org.sql2o.data.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class GUICekPesanan extends JFrame implements ActionListener{
    JFrame frame;
    JPanel panel, panel1;
    PemesananDB pDB = new PemesananDB();
    MinumanDB minDB = new MinumanDB();
    MakananDB makDB = new MakananDB();
    int totalHarga = makDB.totalFoodOrder() + minDB.totalDrinkOrder();
    GUIStruk sT;
    MemberConstructor mC;
    public GUICekPesanan(){

        panel = new JPanel();
        panel.setBackground(new Color(80, 139, 152));
        Border border = new LineBorder(new Color(38, 74, 77), 20, false);
        panel.setBorder(border);
        panel.setLayout(null);

        JLabel judul = new JLabel("Periksa Kembali Pesanan Anda Disini");
        judul.setFont(new Font("", Font.BOLD, 32));
        judul.setForeground(Color.white);
        judul.setBounds(53, 190, 600, 100);
        panel.add(judul);

        panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(null);
        panel1.setBounds(43, 270, 600, 200);
        panel.add(panel1);

        pDB.StrukMakanan();
        pDB.StrukMinuman();

        String strukRows[][] = new String[pDB.getStrukList().size() / 3][3];
        int row = 0;

        for (int i = 0; i < pDB.getStrukList().size(); i += 3) {
            strukRows[row][0] = pDB.getStrukList().get(i);
            strukRows[row][1] = pDB.getStrukList().get(i + 1);
            strukRows[row][2] = pDB.getStrukList().get(i + 2);
            row++;
        }

        String column[] = {"Nama", "Kuantitas", "Harga"};
        JTable table = new JTable(strukRows, column);
        table.setBackground(Color.WHITE);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.WHITE);
        table.setBounds(0, 0, 600, 150);

        //Untuk buat text pada kolom centered
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        //Untuk kolom tertentu
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        //Untuk resize kolom
        TableColumn column0 = table.getColumnModel().getColumn(0);
        column0.setPreferredWidth(150);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 600, 150);
        panel1.add(scrollPane);

        JButton backButton = new JButton("Batal");
        backButton.setFocusable(false);
        backButton.setBackground(new Color(80, 139, 152));
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("", Font.BOLD, 14));
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);
        backButton.setBounds(488, 160, 100, 30);
        panel1.add(backButton);

        JButton loginButton = new JButton("Punya member?");
        loginButton.setFocusable(false);
        loginButton.setBackground(Color.WHITE);
        loginButton.setFont(new Font("", Font.BOLD, 14));
        loginButton.setActionCommand("Login");
        loginButton.addActionListener(this);
        loginButton.setBounds(43, 480, 150, 30);
        panel.add(loginButton);

        JButton regisButton = new JButton("Buat Member?");
        regisButton.setFocusable(false);
        regisButton.setBackground(Color.WHITE);
        regisButton.setFont(new Font("", Font.BOLD, 14));
        regisButton.setActionCommand("Regis");
        regisButton.addActionListener(this);
        regisButton.setBounds(43, 520, 150, 30);
        panel.add(regisButton);

        JButton cekButton = new JButton("Checkout");
        cekButton.setFocusable(false);
        cekButton.setBackground(new Color(255,255,255));
        cekButton.setFont(new Font("", Font.BOLD, 15));
        cekButton.setActionCommand("Cekout");
        cekButton.addActionListener(this);
        cekButton.setBounds(500, 865, 150, 60);
        panel.add(cekButton);

        JLabel total = new JLabel("Total: Rp. " + totalHarga);
        total.setFont(new Font("", Font.BOLD, 32));
        total.setForeground(Color.white);
        total.setBounds(40, 845, 600, 100);
        panel.add(total);

        cekButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cekButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cekButton.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cekButton.setCursor(Cursor.getDefaultCursor());
                cekButton.setBackground(Color.WHITE);
            }
        });

        frame = new JFrame();
        frame.add(panel);
        frame.setSize(700, 1000);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Cafe Nico Boba");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if("Cekout".equals(ac)){
            new GUIMenuPembayaran(mC);
            frame.setVisible(false);
        }
        else if("Back".equals(ac)){
            new GUIMenuTab();
            frame.dispose();
            minDB.deleteDrinkOrder();
            makDB.deleteFoodOrder();
        }
        else if("Login".equals(ac)){
            GUIMemberLogin memberLogin = new GUIMemberLogin(sT, GUICekPesanan.this);
        }
        else if("Regis".equals(ac)){
            new GUIMemberRegis();
        }
    }
}