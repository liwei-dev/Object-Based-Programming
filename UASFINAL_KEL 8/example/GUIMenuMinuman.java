package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUIMenuMinuman extends JFrame implements ActionListener {

    private JPanel drinkPanel;
    JLabel namaMin;
    JLabel top;
    JTextField kuantitasD;
    private String minumN;
    private String idMin;
    GUIMinumanAdd mSInstance;
    JLabel hargaMin;
    int drinkLoc;

    public GUIMenuMinuman(GUIMinumanAdd mA){
        //mSInstance ini untuk menyimpan state minuman Gui
        this.mSInstance = mA;

        //Panel Minuman
        drinkPanel = new JPanel();
        drinkPanel.setLayout(new BoxLayout(drinkPanel, BoxLayout.PAGE_AXIS));
        drinkPanel.setOpaque(false);

        //Panel Display Minuman
        JPanel dispDrink1 = new JPanel();
        dispDrink1.setLayout(new GridLayout(1, 3));
        dispDrink1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        // Ini untuk nmembuat agar terdapat warna bg
        dispDrink1.setOpaque(false);

        //Minuman 1
        JPanel d1 = new JPanel();
        d1.setLayout(new BoxLayout(d1, BoxLayout.PAGE_AXIS));
        d1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Judul
        //Disini grid layout untuk fill layoutnya
        JPanel dT1 = new JPanel(new GridBagLayout());
        dT1.setOpaque(false);
        JLabel drink1 = new JLabel("Signature nicoBoba");
        dT1.add(drink1);
        //Panel Image
        JPanel dI1 = new JPanel(new GridBagLayout());
        dI1.setOpaque(false);
        //Buat masukin image
        ImageIcon imageD1 = new ImageIcon("images/boba.png");
        Image imgD1 = imageD1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imageDrink1 = new JButton(new ImageIcon(imgD1));
        imageDrink1.setFocusable(false);
        imageDrink1.setContentAreaFilled(false);
        imageDrink1.setBorderPainted(false);
        imageDrink1.addActionListener(this);
        imageDrink1.setActionCommand("bButton");
        //Untuk add
        dI1.add(imageDrink1);
        d1.add(dI1);
        d1.add(dT1);
        d1.setOpaque(false);

        //Minuman 2
        JPanel d2 = new JPanel();
        d2.setLayout(new BoxLayout(d2, BoxLayout.PAGE_AXIS));
        d2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Judul
        JPanel dT2 = new JPanel(new GridBagLayout());
        dT2.setOpaque(false);
        JLabel drink2 = new JLabel("Milkshake");
        dT2.add(drink2);
        //Panel Image
        JPanel dI2 = new JPanel(new GridBagLayout());
        dI2.setOpaque(false);
        ImageIcon imageD2 = new ImageIcon("images/milkshake.png");
        Image imgD2 = imageD2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imageDrink2 = new JButton(new ImageIcon(imgD2));
        imageDrink2.setFocusable(false);
        imageDrink2.setContentAreaFilled(false);
        imageDrink2.setBorderPainted(false);
        imageDrink2.addActionListener(this);
        imageDrink2.setActionCommand("msButton");
        dI2.add(imageDrink2);
        d2.add(dI2);
        d2.add(dT2);
        d2.setOpaque(false);

        //Minuman 3
        JPanel d3 = new JPanel();
        d3.setLayout(new BoxLayout(d3, BoxLayout.PAGE_AXIS));
        d3.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Judul
        JPanel dT3 = new JPanel(new GridBagLayout());
        dT3.setOpaque(false);
        JLabel drink3 = new JLabel("Matcha Latte");
        dT3.add(drink3);
        //Panel Image
        JPanel dI3 = new JPanel(new GridBagLayout());
        dI3.setOpaque(false);
        ImageIcon imageD3 = new ImageIcon("images/matchaLatte.png");
        Image imgD3 = imageD3.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imageDrink3 = new JButton(new ImageIcon(imgD3));
        imageDrink3.setFocusable(false);
        imageDrink3.setContentAreaFilled(false);
        imageDrink3.setBorderPainted(false);
        imageDrink3.addActionListener(this);
        imageDrink3.setActionCommand("mlButton");
        dI3.add(imageDrink3);
        d3.add(dI3);
        d3.add(dT3);
        d3.setOpaque(false);

        JPanel dispDrink2 = new JPanel(new GridLayout(1, 3));
        dispDrink2.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        dispDrink2.setOpaque(false);

        //Minuman 4
        JPanel d4 = new JPanel();
        d4.setLayout(new BoxLayout(d4, BoxLayout.PAGE_AXIS));
        d4.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Judul
        JPanel dT4 = new JPanel(new GridBagLayout());
        dT4.setOpaque(false);
        JLabel drink4 = new JLabel("Juice");
        dT4.add(drink4);
        //Panel Image
        JPanel dI4 = new JPanel(new GridBagLayout());
        dI4.setOpaque(false);
        ImageIcon imageD4 = new ImageIcon("images/juice.png");
        Image imgD4 = imageD4.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imageDrink4 = new JButton(new ImageIcon(imgD4));
        imageDrink4.setFocusable(false);
        imageDrink4.setContentAreaFilled(false);
        imageDrink4.setBorderPainted(false);
        imageDrink4.addActionListener(this);
        imageDrink4.setActionCommand("juButton");
        dI4.add(imageDrink4);
        d4.add(dI4);
        d4.add(dT4);
        d4.setOpaque(false);

        //Minuman 5
        JPanel d5 = new JPanel();
        d5.setLayout(new BoxLayout(d5, BoxLayout.PAGE_AXIS));
        d5.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Judul
        JPanel dT5 = new JPanel(new GridBagLayout());
        dT5.setOpaque(false);
        JLabel drink5 = new JLabel("Cocktail");
        dT5.add(drink5);
        //Panel Image
        JPanel dI5 = new JPanel(new GridBagLayout());
        dI5.setOpaque(false);
        ImageIcon imageD5 = new ImageIcon("images/cocktail.png");
        Image imgD5 = imageD5.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JButton imageDrink5 = new JButton(new ImageIcon(imgD5));
        imageDrink5.setFocusable(false);
        imageDrink5.setContentAreaFilled(false);
        imageDrink5.setBorderPainted(false);
        imageDrink5.addActionListener(this);
        imageDrink5.setActionCommand("cButton");
        dI5.add(imageDrink5);
        d5.add(dI5);
        d5.add(dT5);
        d5.setOpaque(false);

        JPanel d6 = new JPanel();
        d6.setLayout(new BoxLayout(d6, BoxLayout.PAGE_AXIS));
        d6.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        d6.setOpaque(false);

        JPanel dispDrink3 = new JPanel();
        dispDrink3.setLayout(new GridLayout(1, 3));
        dispDrink3.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        dispDrink3.setOpaque(false);

        dispDrink1.add(d1);
        dispDrink1.add(d2);
        dispDrink1.add(d3);
        dispDrink2.add(d4);
        dispDrink2.add(d5);
        dispDrink2.add(d6);

        JPanel allDrink = new JPanel(new GridLayout(4, 1));
        allDrink.add(dispDrink1);
        allDrink.add(dispDrink2);
        allDrink.setBackground(new Color(246,246,246));
        allDrink.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JScrollPane scrollDrink = new JScrollPane(allDrink);
        scrollDrink.setBackground(new Color(246,246,246));
        scrollDrink.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel infDrink3 = new JPanel();
        infDrink3.setLayout(new GridLayout(1, 2));
        infDrink3.setBackground(new Color(38, 74, 77));

        //Label Makanan
        JPanel infoD = new JPanel(new GridBagLayout());
        infoD.setOpaque(false);

        namaMin = new JLabel("Pilih Minuman");
        namaMin.setForeground(new Color(246,246,246));
        namaMin.setFont(new Font("", Font.BOLD, 24));

        top = new JLabel();
        top.setForeground(new Color(246,246,246));

        hargaMin = new JLabel("CafeNicoBoba");
        hargaMin.setForeground(new Color(246,246,246));

        // GridBagConstraints Untuk Set Lokasi Label Info Makanan
        GridBagConstraints gbcD = new GridBagConstraints();
        gbcD.fill = GridBagConstraints.CENTER;
        gbcD.gridx = 0;
        gbcD.gridy = 0;
        gbcD.insets = new Insets(0, 40, 10, 0);

        // Add label ke panel infoMak
        infoD.add(namaMin, gbcD);

        gbcD.gridy = 1;
        infoD.add(top, gbcD);

        gbcD.gridy = 2;
        infoD.add(hargaMin, gbcD);

        JPanel infoKananD = new JPanel(new GridBagLayout());
        infoKananD.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        infoKananD.setOpaque(false);

        JPanel infoBeliD = new JPanel();
        infoBeliD.setLayout(new BoxLayout(infoBeliD, BoxLayout.PAGE_AXIS));
        infoBeliD.setOpaque(false);
        infoKananD.add(infoBeliD);

        JPanel buttonAddD = new JPanel();
        buttonAddD.setLayout(new BoxLayout(buttonAddD, BoxLayout.LINE_AXIS));
        buttonAddD.setOpaque(false);

        kuantitasD = new JTextField("0", 3);
        kuantitasD.setEditable(false);
        kuantitasD.setFocusable(false);
        kuantitasD.setHorizontalAlignment(SwingConstants.CENTER);
        kuantitasD.setMaximumSize(new Dimension(80, 40));
        kuantitasD.setBackground(new Color(246,246,246));
        kuantitasD.setFont(new Font("", Font.BOLD, 14));

        JButton tambahD = new JButton("+");
        tambahD.setMaximumSize(new Dimension(50, 40));
        tambahD.setFocusable(false);
        tambahD.setBackground(new Color(80, 139, 152));
        tambahD.setForeground(new Color(246,246,246));
        tambahD.setFont(new Font("", Font.BOLD, 14));
        tambahD.addActionListener(this);
        tambahD.setActionCommand("plusButton");

        JButton delD = new JButton("-");
        delD.setMaximumSize(new Dimension(50, 40));
        delD.setFocusable(false);
        delD.setBackground(new Color(80, 139, 152));
        delD.setForeground(new Color(246,246,246));
        delD.setFont(new Font("", Font.BOLD, 14));
        delD.addActionListener(this);
        delD.setActionCommand("minusButton");

        JPanel buttonBot1D = new JPanel();
        buttonBot1D.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        buttonBot1D.setLayout(new GridLayout(1,1));
        buttonBot1D.setOpaque(false);
        JButton resetD = new JButton("Batalkan Pesanan");
        resetD.setFocusable(false);
        resetD.setBackground(new Color(80, 139, 152));
        resetD.setForeground(new Color(246,246,246));
        resetD.setFont(new Font("", Font.BOLD, 14));
        resetD.addActionListener(this);
        resetD.setActionCommand("resetD");

        JPanel buttonBot2D = new JPanel();
        buttonBot2D.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        buttonBot2D.setLayout(new GridLayout(1,1));
        buttonBot2D.setOpaque(false);
        JButton cekPd = new JButton("Cek Pesanan");
        cekPd.setFocusable(false);
        cekPd.setBackground(new Color(80, 139, 152));
        cekPd.setForeground(new Color(246,246,246));
        cekPd.setFont(new Font("", Font.BOLD, 14));
        cekPd.addActionListener(this);
        cekPd.setActionCommand("cekPd");

        buttonAddD.add(kuantitasD);
        buttonAddD.add(tambahD);
        buttonAddD.add(delD);

        buttonBot1D.add(resetD);
        buttonBot2D.add(cekPd);

        infoBeliD.add(buttonAddD);
        infoBeliD.add(buttonBot1D);
        infoBeliD.add(buttonBot2D);

        infDrink3.add(infoD);
        infDrink3.add(infoKananD);

        drinkPanel.add(scrollDrink);
        drinkPanel.add(infDrink3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        MinumanDB minDB = new MinumanDB();
        PemesananDB pDB = new PemesananDB();

        List<MinumanConstructor> minuman = minDB.drinkList();

        if("bButton".equals(actionCommand)){
            this.mSInstance = new GUIMinumanAdd(this);
            minumN = minuman.get(0).getNama_minuman();
            idMin = minuman.get(0).getId_minuman();
            drinkLoc = minuman.get(0).getHarga_minuman();
            hargaMin.setText("Rp " + Integer.toString(minuman.get(0).getHarga_minuman()));

        } else if ("msButton".equals(actionCommand)) {
            this.mSInstance = new GUIMinumanAdd(this);
            minumN = minuman.get(1).getNama_minuman();
            idMin = minuman.get(1).getId_minuman();
            drinkLoc = minuman.get(1).getHarga_minuman();
            hargaMin.setText("Rp " + Integer.toString(minuman.get(1).getHarga_minuman()));
        } else if ("mlButton".equals(actionCommand)) {
            this.mSInstance = new GUIMinumanAdd(this);
            minumN = minuman.get(2).getNama_minuman();
            idMin = minuman.get(2).getId_minuman();
            drinkLoc = minuman.get(2).getHarga_minuman();
            hargaMin.setText("Rp " + Integer.toString(minuman.get(2).getHarga_minuman()));
        } else if ("juButton".equals(actionCommand)) {
            this.mSInstance = new GUIMinumanAdd(this);
            minumN = minuman.get(3).getNama_minuman();
            idMin = minuman.get(3).getId_minuman();
            drinkLoc = minuman.get(3).getHarga_minuman();
            hargaMin.setText("Rp " + Integer.toString(minuman.get(3).getHarga_minuman()));
        } else if ("cButton".equals(actionCommand)) {
            this.mSInstance = new GUIMinumanAdd(this);
            minumN = minuman.get(4).getNama_minuman();
            idMin = minuman.get(4).getId_minuman();
            drinkLoc = minuman.get(4).getHarga_minuman();
            hargaMin.setText("Rp " + Integer.toString(minuman.get(4).getHarga_minuman()));

        } else if ("plusButton".equals(actionCommand)) {
            if ("D01".equals(idMin)){
                minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + 1);
                kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                if(mSInstance.getKodeT().equals("T00")) {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(0).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(0).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                } else {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(0).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(0).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                }
            }
            else if ("D02".equals(idMin)){
                minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + 1);
                kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                if(mSInstance.getKodeT().equals("T00")) {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(1).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(1).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                } else {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(1).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(1).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                }
            }
            else if ("D03".equals(idMin)){
                minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + 1);
                kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                if(mSInstance.getKodeT().equals("T00")) {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(2).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(2).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                } else {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(2).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(2).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                }
            }
            else if ("D04".equals(idMin)){
                minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + 1);
                kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                if(mSInstance.getKodeT().equals("T00")) {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(3).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(3).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                } else {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(3).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(3).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                }
            }
            else if ("D05".equals(idMin)){
                minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + 1);
                kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                if(mSInstance.getKodeT().equals("T00")) {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(4).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(4).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                } else {
                    minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(4).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                    hargaMin.setText("Rp " + Integer.toString(minuman.get(4).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                }
            }
        } else if ("minusButton".equals(actionCommand)) {
            if("D01".equals(idMin)){
                if(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) == 0){
                    kuantitasD.setText("0");
                } else {
                    minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) - 1);
                    kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    if(mSInstance.getKodeT().equals("T00")) {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(0).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(0).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    } else {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(0).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(0).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                    }
                }
            } else if ("D02".equals(idMin)) {
                if(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) == 0){
                    kuantitasD.setText("0");
                } else {
                    minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) - 1);
                    kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    if(mSInstance.getKodeT().equals("T00")) {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(1).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(1).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    } else {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(1).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(1).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                    }
                }
            } else if ("D03".equals(idMin)) {
                if(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) == 0){
                    kuantitasD.setText("0");
                } else {
                    minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) - 1);
                    kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    if(mSInstance.getKodeT().equals("T00")) {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(2).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(2).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    } else {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(2).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(2).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                    }
                }
            } else if ("D04".equals(idMin)) {
                if(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) == 0){
                    kuantitasD.setText("0");
                } else {
                    minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) - 1);
                    kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    if(mSInstance.getKodeT().equals("T00")) {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(3).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(3).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    } else {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(3).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(3).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                    }
                }
            } else if ("D05".equals(idMin)) {
                if(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) == 0){
                    kuantitasD.setText("0");
                } else {
                    minDB.updateDrinkK(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) - 1);
                    kuantitasD.setText(Integer.toString(minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    if(mSInstance.getKodeT().equals("T00")) {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(4).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()));
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(4).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())));
                    } else {
                        minDB.updateDrinkPrice(idMin, mSInstance.getKodeR(), mSInstance.getKodeT(), minuman.get(4).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT()) + mSInstance.getHargaT());
                        hargaMin.setText("Rp " + Integer.toString(minuman.get(4).getHarga_minuman() * minDB.getKuantitas(idMin, mSInstance.getKodeR(), mSInstance.getKodeT())) + mSInstance.getHargaT());
                    }
                }
            }
        }

        if ("resetD".equals(actionCommand)) {
            minDB.deleteDrinkOrder();
            minDB.deleteDrink("PE" + Integer.toString(pDB.getRowCount()));
            pDB.deleteOrder("PE" + Integer.toString(pDB.getRowCount()));
            new GUIAwal();
            SwingUtilities.getWindowAncestor(drinkPanel).dispose();
        }
        else if ("cekPd".equals(actionCommand)) {
            new GUICekPesanan();
            SwingUtilities.getWindowAncestor(drinkPanel).dispose();
        }
    }

    public String getIdMin() {
        return idMin;
    }
    public String getMinumN() {
        return minumN;
    }
    public int getDrinkLoc() {
        return drinkLoc;
    }
    public JPanel getDrinkPanel() {
        return drinkPanel;
    }
    public void updateDrink(String drinkInfo) {
        namaMin.setText(drinkInfo);
    }
    public void updateTop(String topInfo) {
        top.setText(topInfo);
    }


}

