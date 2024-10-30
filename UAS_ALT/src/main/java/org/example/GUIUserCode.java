package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUIUserCode extends JFrame implements ActionListener {

    JFrame frame;
    JPanel panel;

    JPasswordField code;

    GUIlogin gLog;


    public GUIUserCode( GUIlogin guiLogin) {
        this.frame = new JFrame();
        this.gLog = guiLogin;

        //Membuat Panel
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(251,236,93));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal resizing
        constraints.weightx = 0.5; // Allow the text field to grow in width

        // Menambahkan gambar ke dalam JFrame
        ImageIcon logo = new ImageIcon("images/logo.png");
        JLabel imageLabel = new JLabel(logo);
        constraints.gridy = 0;
        panel.add(imageLabel, constraints);

        //Membuat Button Order
        code = new JPasswordField();
        code.setEditable(true);
        code.setFocusable(true);
        code.setHorizontalAlignment(SwingConstants.CENTER);
        code.setBackground(new Color(246,246,246));
        code.setFont(new Font("", Font.BOLD, 14));

        JButton mEnter = new JButton("Login");
        mEnter.setFocusable(false);
        mEnter.setBackground(new Color(38, 74, 77));
        mEnter.setForeground(new Color(246, 246, 246));
        mEnter.setPreferredSize(new Dimension(200, 30));
        mEnter.addActionListener(this);
        mEnter.setActionCommand("entLog");

        constraints.gridy = 1; // Set the position for the first button
        panel.add(code, constraints);

        constraints.gridy = 2; // Set the position for the second button
        panel.add(mEnter,constraints);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu Awal");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loginDB lDB = new loginDB();
        //Untuk action button
        String ac = e.getActionCommand();

        if ("entLog".equals(ac)){
            if (lDB.cekLogin(code.getText())) {
                new GUIAwal();
                frame.dispose();
                gLog.frame.dispose();
            } else if (!lDB.cekLogin(code.getText())) {
                new GUIlogin();
            }
        }
    }
}
