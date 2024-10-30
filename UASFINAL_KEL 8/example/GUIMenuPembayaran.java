package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class GUIMenuPembayaran extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;
    String metode;
    PemesananDB pDB = new PemesananDB();

    GUIMemberLogin mL;

    MemberConstructor mC;

    public GUIMenuPembayaran(MemberConstructor mC){

        this.mC = mC;

        panel = new JPanel();
        panel.setBackground(new Color(80, 139, 152));
        Border border = new LineBorder(new Color(38, 74, 77), 20, false);
        panel.setBorder(border);
        panel.setLayout(null);

        JLabel judul = new JLabel("Pilih Pembayaran");
        judul.setFont(new Font("", Font.BOLD, 40));
        judul.setForeground(Color.white);
        judul.setBounds(170, 225, 500, 100);
        panel.add(judul);

        ImageIcon qris = new ImageIcon("images/qris.png");
        int width = (int) (qris.getIconWidth() * 0.6);
        int height = (int) (qris.getIconHeight() * 0.6);
        Image scaledImage = qris.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledQris = new ImageIcon(scaledImage);
        JLabel imageQris = new JLabel(scaledQris);
        imageQris.setBounds(55, 325, width, height);
        panel.add(imageQris);

        JButton qrisButton = new JButton("QRIS");
        qrisButton.setFocusable(false);
        qrisButton.setBackground(new Color(255,255,255));
        qrisButton.setFont(new Font("", Font.BOLD, 18));
        qrisButton.setActionCommand("qris");
        qrisButton.addActionListener(this);
        qrisButton.setBounds(55, 625, width, 60);
        qrisButton.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.WHITE, 1),
                new EmptyBorder(50, 50, 50, 50)
        ));
        panel.add(qrisButton);

        ImageIcon bank = new ImageIcon("images/bank.png");
        Image scaledImage2 = bank.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledBank = new ImageIcon(scaledImage2);
        JLabel imageBank = new JLabel(scaledBank);
        imageBank.setBounds(355, 325, width, height);
        panel.add(imageBank);

        JButton bankButton = new JButton("TRANSFER BANK");
        bankButton.setFocusable(false);
        bankButton.setBackground(new Color(255,255,255));
        bankButton.setFont(new Font("", Font.BOLD, 18));
        bankButton.setActionCommand("bank");
        bankButton.addActionListener(this);
        bankButton.setBounds(355, 625, width, 60);
        bankButton.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.WHITE, 1),
                new EmptyBorder(50, 50, 50, 50)
        ));
        panel.add(bankButton);

        qrisButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                qrisButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                qrisButton.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                qrisButton.setCursor(Cursor.getDefaultCursor());
                qrisButton.setBackground(Color.WHITE);
            }
        });

        bankButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bankButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                bankButton.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bankButton.setCursor(Cursor.getDefaultCursor());
                bankButton.setBackground(Color.WHITE);
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
        if("qris".equals(ac)){
            pDB.updateMP("Qris", "PE" + String.valueOf(pDB.getRowCount()));
            frame.dispose();
            new GUIStruk(mC);
        } else if ("bank".equals(ac)) {
            pDB.updateMP("Transfer Bank", "PE" + String.valueOf(pDB.getRowCount()));
            frame.dispose();
            new GUIStruk(mC);
        }
    }
}
