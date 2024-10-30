package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMenuM extends JFrame implements ActionListener {

    JFrame frame;
    JPanel panel;

    private int idP = 0;

    public GUIMenuM() {
        this.frame = new JFrame();

        //Membuat Panel
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(251,236,93));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 10, 10, 10);

        // Menambahkan gambar ke dalam JFrame
        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel imageLabel = new JLabel(logo);
        constraints.gridy = 0;
        panel.add(imageLabel, constraints);

        //Membuat Button Order
        JButton mLogin = new JButton("M-Banking Login");
        mLogin.setFocusable(false);
        mLogin.setBackground(new Color(38, 74, 77));
        mLogin.setForeground(new Color(246, 246, 246));
        mLogin.setPreferredSize(new Dimension(200, 30));
        mLogin.addActionListener(this);
        mLogin.setActionCommand("pMak");

        JButton mNewAcc = new JButton("M-Banking New Account");
        mNewAcc.setFocusable(false);
        mNewAcc.setBackground(new Color(38, 74, 77));
        mNewAcc.setForeground(new Color(246, 246, 246));
        mNewAcc.setPreferredSize(new Dimension(200, 30));
        mNewAcc.addActionListener(this);
        mNewAcc.setActionCommand("pMak");

        constraints.gridy = 1; // Set the position for the first button
        panel.add(mLogin, constraints);

        constraints.gridy = 2; // Set the position for the second button
        panel.add(mNewAcc, constraints);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu Awal");
        frame.setSize(600, 1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Untuk action button
        String ac = e.getActionCommand();
        if ("pMak".equals(ac)) {
            PemesananDB pDB = new PemesananDB();
            //Membuat ID Pemesanan
            idP = pDB.getRowCount() + 1;
            String idPesan = "PE" + Integer.toString(idP);
            pDB.createOrder(idPesan);

            //Membuka GUIMenuTab Dan Menutup GUIAwal
            new GUIMenuTab();
            frame.dispose();
        }
    }
}

