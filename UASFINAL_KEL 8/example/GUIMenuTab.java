package org.example;

import javax.swing.*;
import java.awt.*;

public class GUIMenuTab extends JFrame {
    JFrame window;
    GUIMinumanAdd minumanSpek;
    public GUIMenuTab() {
        GUIMenuMakanan menuMak = new GUIMenuMakanan();
        GUIMenuMinuman menuMin = new GUIMenuMinuman(minumanSpek); // Pass the MinumanSpek object

        window = new JFrame();

        window.setTitle("Cafe Nico Boba");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(new Color(80, 139, 152));

        // Tabbed Pane
        JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);

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
