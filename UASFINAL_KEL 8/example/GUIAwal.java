package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIAwal extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;

    private int idP = 0;

    public GUIAwal() {
        this.frame = new JFrame();

        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(80, 139, 152));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 10, 10, 10);

        // Menambahkan gambar ke dalam JFrame
        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel imageLabel = new JLabel(logo);
        constraints.gridy = 0;
        panel.add(imageLabel, constraints);

        JButton order = new JButton("Pesan");
        order.setFocusable(false);
        order.setBackground(new Color(38, 74, 77));
        order.setForeground(new Color(246, 246, 246));
        order.setPreferredSize(new Dimension(200, 30));

        order.addActionListener(this);
        order.setActionCommand("pMak");

        constraints.gridy = 1;
        panel.add(order, constraints);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu Awal");
        frame.setSize(600, 1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if ("pMak".equals(ac)) {
            PemesananDB pDB = new PemesananDB();
            idP = pDB.getRowCount() + 1;
            String idPesan = "PE" + Integer.toString(idP);

            pDB.createOrder(idPesan);
            new GUIMenuTab();
            frame.dispose();
        }
    }
}
