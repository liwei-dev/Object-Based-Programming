package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAkhir extends JFrame implements ActionListener{
    JFrame frame;
    JPanel panel;
    public GUIAkhir(){

        panel = new JPanel();
        panel.setBackground(new Color(80, 139, 152));
        Border border = new LineBorder(new Color(38, 74, 77), 20, false);
        panel.setBorder(border);
        panel.setLayout(null);

        JLabel judul = new JLabel("TERIMA KASIH");
        judul.setFont(new Font("", Font.BOLD, 50));
        judul.setForeground(Color.white);
        judul.setBounds(160, 265, 500, 100);
        panel.add(judul);

        JLabel judul1 = new JLabel("SUDAH BELANJA");
        judul1.setFont(new Font("", Font.BOLD, 50));
        judul1.setForeground(Color.white);
        judul1.setBounds(125, 345, 500, 100);
        panel.add(judul1);

        JLabel judul2 = new JLabel("DI");
        judul2.setFont(new Font("", Font.BOLD, 50));
        judul2.setForeground(Color.white);
        judul2.setBounds(200, 435, 500, 100);
        panel.add(judul2);

        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel judul3 = new JLabel(logo);
        judul3.setFont(new Font("", Font.BOLD, 50));
        judul3.setForeground(Color.white);
        judul3.setBounds(130, 440, 500, 100);
        panel.add(judul3);

        JButton homeButton = new JButton("Home");
        homeButton.setFocusable(false);
        homeButton.setBackground(new Color(255,255,255));
        homeButton.setFont(new Font("", Font.BOLD, 15));
        homeButton.setActionCommand("Home");
        homeButton.addActionListener(this);
        homeButton.setBounds(500, 865, 150, 60);
        panel.add(homeButton);

        homeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                homeButton.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                homeButton.setCursor(Cursor.getDefaultCursor());
                homeButton.setBackground(Color.WHITE);
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
        if("Home".equals(ac)){
            frame.dispose();
            new GUIAwal();
        }
    }
}