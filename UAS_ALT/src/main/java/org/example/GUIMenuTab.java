package org.example;

import javax.swing.*;
import java.awt.*;

public class GUIMenuTab extends JFrame {
    JFrame window;
    GUIMinumanAdd mA;
    public GUIMenuTab() {
        //Memanggil Class Untuk Menu Makanan Dan Minuman
        GUIMenuMakanan menuMak = new GUIMenuMakanan();
        GUIMenuMinuman menuMin = new GUIMenuMinuman(mA);

        //Membuat Frame GUI
        window = new JFrame();
        window.setTitle("Cafe Nico Boba");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(new Color(80, 139, 152));

        //Membuat TabbedPane
        JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);

        //Memanggil Panel Yang Ada Di Menu Makanan Dan Minuman
        tab.addTab("Makanan", menuMak.getFoodPanel());
        tab.addTab("Minuman", menuMin.getDrinkPanel());

        tab.setBackground(new Color(38, 74, 77));
        tab.setForeground(new Color(246, 246, 246));
        tab.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        window.add(tab);
        window.setSize(700, 1000);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
