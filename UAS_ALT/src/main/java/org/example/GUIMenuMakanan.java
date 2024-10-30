package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class GUIMenuMakanan extends JFrame implements ActionListener {

    private JTextField kuantitas;
    private JPanel foodPanel;
    private JLabel namaMak;
    private JLabel hargaMak;
    private int kBurg = 0;
    private int kSF = 0;
    private int kCP = 0;
    private int kRoti = 0;
    private int kWaffle = 0;
    private int clickCountF1 = 0;
    private int clickCountF2 = 0;
    private int clickCountF3 = 0;
    private int clickCountF4 = 0;
    private int clickCountF5 = 0;
    private String idMak = "";

    public GUIMenuMakanan() {

        //Food Panel Tab
        foodPanel = new JPanel();
        foodPanel.setLayout(new BoxLayout(foodPanel, BoxLayout.PAGE_AXIS));
        foodPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Food Display 1
        JPanel dispFood1 = new JPanel();
        dispFood1.setLayout(new GridLayout(1, 3));
        dispFood1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        dispFood1.setOpaque(false);

        //Food 1
        JPanel f1 = new JPanel();
        f1.setLayout(new BoxLayout(f1, BoxLayout.PAGE_AXIS));
        f1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Image
        JPanel fI1 = new JPanel(new GridBagLayout());
        fI1.setOpaque(false);
        ImageIcon image1 = new ImageIcon("images/burgertest.png");
        Image img1 = image1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imgF1 = new JButton(new ImageIcon(img1));
        imgF1.setFocusable(false);
        imgF1.setContentAreaFilled(false);
        imgF1.setBorderPainted(false);
        imgF1.addActionListener(this);
        imgF1.setActionCommand("burgButton");
        //Panel Title
        JPanel fT1 = new JPanel(new GridBagLayout());
        JLabel food1 = new JLabel("NicoBugBurgerss");
        fT1.setOpaque(false);
        fT1.add(food1);
        fI1.add(imgF1);
        f1.add(fI1);
        f1.add(fT1);
        f1.setOpaque(false);

        //Food 2
        JPanel f2 = new JPanel();
        f2.setLayout(new BoxLayout(f2, BoxLayout.PAGE_AXIS));
        f2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Image
        JPanel fI2 = new JPanel(new GridBagLayout());
        fI2.setOpaque(false);
        ImageIcon image2 = new ImageIcon("images/sauf.png");
        Image img2 = image2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imgF2 = new JButton(new ImageIcon(img2));
        imgF2.setFocusable(false);
        imgF2.setContentAreaFilled(false);
        imgF2.setBorderPainted(false);
        imgF2.addActionListener(this);
        imgF2.setActionCommand("sfButton");
        fI2.add(imgF2);
        //Panel Title
        JPanel fT2 = new JPanel(new GridBagLayout());
        JLabel food2 = new JLabel("Sausage Fries");
        fT2.setOpaque(false);
        fT2.add(food2);
        f2.add(fI2);
        f2.add(fT2);
        f2.setOpaque(false);

        //Food 3
        JPanel f3 = new JPanel();
        f3.setLayout(new BoxLayout(f3, BoxLayout.PAGE_AXIS));
        f3.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Image
        JPanel fI3 = new JPanel(new GridBagLayout());
        fI3.setOpaque(false);
        ImageIcon image3 = new ImageIcon("images/chickenpop.png");
        Image img3 = image3.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imgF3 = new JButton(new ImageIcon(img3));
        imgF3.setFocusable(false);
        imgF3.setContentAreaFilled(false);
        imgF3.setBorderPainted(false);
        imgF3.addActionListener(this);
        imgF3.setActionCommand("cpButton");
        fI3.add(imgF3);
        //Panel Title
        JPanel fT3 = new JPanel(new GridBagLayout());
        JLabel food3 = new JLabel("Chick Pop");
        fT3.setOpaque(false);
        fT3.add(food3);
        f3.add(fI3);
        f3.add(fT3);
        f3.setOpaque(false);

        //Food Display 2
        JPanel dispFood2 = new JPanel(new GridLayout(1, 3));
        dispFood2.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        dispFood2.setOpaque(false);

        //Food 4
        JPanel f4 = new JPanel();
        f4.setLayout(new BoxLayout(f4, BoxLayout.PAGE_AXIS));
        f4.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Image
        JPanel fI4 = new JPanel(new GridBagLayout());
        fI4.setOpaque(false);
        ImageIcon image4 = new ImageIcon("images/indianbread.png");
        Image img4 = image4.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imgF4 = new JButton(new ImageIcon(img4));
        imgF4.setFocusable(false);
        imgF4.setContentAreaFilled(false);
        imgF4.setBorderPainted(false);
        imgF4.addActionListener(this);
        imgF4.setActionCommand("rotiButton");
        fI4.add(imgF4);
        //Panel Title
        JPanel fT4 = new JPanel(new GridBagLayout());
        JLabel food4 = new JLabel("Indian Bread");
        fT4.setOpaque(false);
        fT4.add(food4);
        f4.add(fI4);
        f4.add(fT4);
        f4.setOpaque(false);

        //Food 5
        JPanel f5 = new JPanel();
        f5.setLayout(new BoxLayout(f5, BoxLayout.PAGE_AXIS));
        f5.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Image
        JPanel fI5 = new JPanel(new GridBagLayout());
        fI5.setOpaque(false);
        ImageIcon image5 = new ImageIcon("images/waffleic.png");
        Image img5 = image5.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JButton imgF5 = new JButton(new ImageIcon(img5));
        imgF5.setFocusable(false);
        imgF5.setContentAreaFilled(false);
        imgF5.setBorderPainted(false);
        imgF5.addActionListener(this);
        imgF5.setActionCommand("waffleButton");
        fI5.add(imgF5);
        //Panel Title
        JPanel fT5 = new JPanel(new GridBagLayout());
        JLabel food5 = new JLabel("Waffle Ice Cream");
        fT5.setOpaque(false);
        fT5.add(food5);
        f5.add(fI5);
        f5.add(fT5);
        f5.setOpaque(false);

        //Empty Food 6
        JPanel f6 = new JPanel();
        f6.setLayout(new BoxLayout(f6, BoxLayout.PAGE_AXIS));
        f6.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        f6.setOpaque(false);


        //Food Display Add
        dispFood1.add(f1);
        dispFood1.add(f2);
        dispFood1.add(f3);
        dispFood2.add(f4);
        dispFood2.add(f5);
        dispFood2.add(f6);

        //Scroll Pane
        JPanel allFood = new JPanel(new GridLayout(4, 1));
        allFood.add(dispFood1);
        allFood.add(dispFood2);
        allFood.setBackground(new Color(246,246,246));
        allFood.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JScrollPane scrollFood = new JScrollPane(allFood);
        scrollFood.setBackground(new Color(246,246,246));
        scrollFood.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Info Panel Bottom
        JPanel infFood3 = new JPanel();
        infFood3.setLayout(new GridLayout(1, 2));
        infFood3.setBackground(new Color(38, 74, 77));

        //Label Makanan
        JPanel infoMak = new JPanel(new GridBagLayout());
        infoMak.setOpaque(false);

        namaMak = new JLabel("Pilih Makanan");
        namaMak.setForeground(new Color(246,246,246));
        namaMak.setFont(new Font("", Font.BOLD, 24));

        hargaMak = new JLabel("CafeNicoBoba");
        hargaMak.setForeground(new Color(246,246,246));

        // GridBagConstraints Untuk Set Lokasi Label Info Makanan
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 40, 10, 0); // Menambah spacing diantara labels

        // Add label ke panel infoMak
        infoMak.add(namaMak, gbc);

        gbc.gridy = 1;
        infoMak.add(hargaMak, gbc);

        //Info Kanan ( Panel )
        JPanel infoKanan = new JPanel(new GridBagLayout());
        infoKanan.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        infoKanan.setOpaque(false);

        //Info Kanan ( Panel Buttons )
        JPanel infoBeli = new JPanel();
        infoBeli.setLayout(new BoxLayout(infoBeli, BoxLayout.PAGE_AXIS));
        infoBeli.setOpaque(false);
        infoKanan.add(infoBeli);

        // Kuantitas Dan + / - Button
        JPanel buttonAdd = new JPanel();
        buttonAdd.setLayout(new BoxLayout(buttonAdd, BoxLayout.LINE_AXIS));
        buttonAdd.setOpaque(false);
        kuantitas = new JTextField("0", 3);
        kuantitas.setEditable(false);
        kuantitas.setFocusable(false);
        kuantitas.setHorizontalAlignment(SwingConstants.CENTER);
        kuantitas.setMaximumSize(new Dimension(80, 40));
        kuantitas.setBackground(new Color(246,246,246));
        kuantitas.setFont(new Font("", Font.BOLD, 14));

        JButton tambah = new JButton("+");
        tambah.setMaximumSize(new Dimension(50, 40));
        tambah.setFocusable(false);
        tambah.setBackground(new Color(80, 139, 152));
        tambah.setForeground(new Color(246,246,246));
        tambah.setFont(new Font("", Font.BOLD, 14));
        tambah.setActionCommand("plusButton");
        tambah.addActionListener(this);

        JButton del = new JButton("-");
        del.setMaximumSize(new Dimension(50, 40));
        del.setFocusable(false);
        del.setBackground(new Color(80, 139, 152));
        del.setForeground(new Color(246,246,246));
        del.setFont(new Font("", Font.BOLD, 14));
        del.setActionCommand("minusButton");
        del.addActionListener(this);

        //Cancel Button
        JPanel buttonBot1M = new JPanel();
        buttonBot1M.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        buttonBot1M.setLayout(new GridLayout(1,1));
        buttonBot1M.setOpaque(false);

        JButton resetM = new JButton("Batalkan Pesanan");
        resetM.setFocusable(false);
        resetM.setBackground(new Color(80, 139, 152));
        resetM.setForeground(new Color(246,246,246));
        resetM.setFont(new Font("", Font.BOLD, 14));
        resetM.addActionListener(this);
        resetM.setActionCommand("resetM");

        //Cek Pesanan Button
        JPanel buttonBot2M = new JPanel();
        buttonBot2M.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        buttonBot2M.setLayout(new GridLayout(1,1));
        buttonBot2M.setOpaque(false);

        JButton cekP = new JButton("Cek Pesanan");
        cekP.setFocusable(false);
        cekP.setBackground(new Color(80, 139, 152));
        cekP.setForeground(new Color(246,246,246));
        cekP.setFont(new Font("", Font.BOLD, 14));
        cekP.addActionListener(this);
        cekP.setActionCommand("cekPButton");

        //Add Panel Content ButtonAdd
        buttonAdd.add(kuantitas);
        buttonAdd.add(tambah);
        buttonAdd.add(del);

        //Add Panel Content ButtonBot
        buttonBot1M.add(resetM);
        buttonBot2M.add(cekP);

        //Add Panel Content infoBeli
        infoBeli.add(buttonAdd);
        infoBeli.add(buttonBot1M);
        infoBeli.add(buttonBot2M);

        //Add Panel Content infFood3
        infFood3.add(infoMak);
        infFood3.add(infoKanan);

        //Add Panel Content Food Panel
        foodPanel.add(scrollFood);
        foodPanel.add(infFood3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Untuk Fungsi Button
        String actionCommand = e.getActionCommand();
        MakananDB mDB = new MakananDB();
        PemesananDB pDB = new PemesananDB();
        List<PemesananConstructor> pC = pDB.getOrder();
        List<MakananConstructor> makanan = mDB.foodList();
        //Button Burger
        if ("burgButton".equals(actionCommand)) {
            kuantitas.setText(Integer.toString(kBurg));
            namaMak.setText(makanan.get(0).getNama_makanan());
            idMak = makanan.get(0).getId_makanan();
            clickCountF1 = clickCountF1 + 1;
            if (clickCountF1 <= 1){
                hargaMak.setText("Rp " + makanan.get(0).getHarga_makanan());
                mDB.addFood(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan());
            }
        } else if ("sfButton".equals(actionCommand)) {
            kuantitas.setText(Integer.toString(kSF));
            namaMak.setText(makanan.get(1).getNama_makanan());
            idMak = makanan.get(1).getId_makanan();
            clickCountF2 = clickCountF2 + 1;
            if (clickCountF2 <= 1){
                hargaMak.setText("Rp " + makanan.get(1).getHarga_makanan());
                mDB.addFood(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan());
            }
        } else if ("cpButton".equals(actionCommand)) {
            kuantitas.setText(Integer.toString(kCP));
            namaMak.setText(makanan.get(2).getNama_makanan());
            idMak = makanan.get(2).getId_makanan();
            clickCountF3 = clickCountF3 + 1;
            if (clickCountF3 <= 1){
                hargaMak.setText("Rp " + makanan.get(2).getHarga_makanan());
                mDB.addFood(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan());
            }
        } else if ("rotiButton".equals(actionCommand)) {
            kuantitas.setText(Integer.toString(kRoti));
            namaMak.setText(makanan.get(3).getNama_makanan());
            idMak = makanan.get(3).getId_makanan();
            clickCountF4 = clickCountF4 + 1;
            if (clickCountF4 <= 1){
                hargaMak.setText("Rp " + makanan.get(3).getHarga_makanan());
                mDB.addFood(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan());
            }
        } else if ("waffleButton".equals(actionCommand)) {
            kuantitas.setText(Integer.toString(kWaffle));
            namaMak.setText(makanan.get(4).getNama_makanan());
            idMak = makanan.get(4).getId_makanan();
            clickCountF5 = clickCountF5 + 1;
            if (clickCountF5 <= 1){
                hargaMak.setText("Rp " + makanan.get(4).getHarga_makanan());
                mDB.addFood(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan());
            }
        } else if ("plusButton".equals(actionCommand)){
            if("M01".equals(idMak)) {
                kBurg++;
                kuantitas.setText(Integer.toString(kBurg));
                mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kBurg);
                mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(0).getHarga_makanan() * kBurg);
                hargaMak.setText("Rp " + makanan.get(0).getHarga_makanan() * kBurg);
            } else if ("M02".equals(idMak)) {
                kSF++;
                kuantitas.setText(Integer.toString(kSF));
                mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kSF);
                mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(1).getHarga_makanan() * kSF);
                hargaMak.setText("Rp " + makanan.get(1).getHarga_makanan() * kSF);
            }
            else if ("M03".equals(idMak)) {
                kCP++;
                kuantitas.setText(Integer.toString(kCP));
                mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kCP);
                mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(2).getHarga_makanan() * kCP);
                hargaMak.setText("Rp " + makanan.get(2).getHarga_makanan() * kCP);
            }
            else if ("M04".equals(idMak)) {
                kRoti++;
                kuantitas.setText(Integer.toString(kRoti));
                mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kRoti);
                mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(3).getHarga_makanan() * kRoti);
                hargaMak.setText("Rp " + makanan.get(3).getHarga_makanan() * kRoti);
            }
            else if ("M05".equals(idMak)) {
                kWaffle++;
                kuantitas.setText(Integer.toString(kWaffle));
                mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kWaffle);
                mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(4).getHarga_makanan() * kWaffle);
                hargaMak.setText("Rp " + makanan.get(4).getHarga_makanan() * kWaffle);
            }
        } else if ("minusButton".equals(actionCommand)) {
            if("M01".equals(idMak)){
                if(kBurg == 0){
                    kuantitas.setText("0");
                } else {
                    kBurg--;
                    mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kBurg);
                    mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(0).getHarga_makanan() * kBurg);
                }
                kuantitas.setText(Integer.toString(kBurg));
                hargaMak.setText("Rp " + makanan.get(0).getHarga_makanan() * kBurg);
            } else if ("M02".equals(idMak)) {
                if(kSF == 0){
                    kuantitas.setText("0");
                } else {
                    kSF--;
                    mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kSF);
                    mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(1).getHarga_makanan() * kSF);
                }
                kuantitas.setText(Integer.toString(kSF));
                hargaMak.setText("Rp " + makanan.get(1).getHarga_makanan() * kSF);
            } else if ("M03".equals(idMak)) {
                if(kCP == 0){
                    kuantitas.setText("0");
                } else {
                    kCP--;
                    mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kCP);
                    mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(2).getHarga_makanan() * kCP);
                }
                kuantitas.setText(Integer.toString(kCP));
                hargaMak.setText("Rp " + makanan.get(2).getHarga_makanan() * kCP);
            } else if ("M04".equals(idMak)) {
                if(kRoti == 0){
                    kuantitas.setText("0");
                } else {
                    kRoti--;
                    mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kRoti);
                    mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(3).getHarga_makanan() * kRoti);
                }
                kuantitas.setText(Integer.toString(kRoti));
                hargaMak.setText("Rp " + makanan.get(3).getHarga_makanan() * kRoti);
            } else if ("M05".equals(idMak)) {
                if(kWaffle == 0){
                    kuantitas.setText("0");
                } else {
                    kWaffle--;
                    mDB.updateFoodK(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), kWaffle);
                    mDB.updateFoodPrice(idMak, pC.get(pDB.getRowCount() - 1).getId_pemesanan(), makanan.get(4).getHarga_makanan() * kWaffle);
                }
                kuantitas.setText(Integer.toString(kWaffle));
                hargaMak.setText("Rp " + makanan.get(4).getHarga_makanan() * kWaffle);
            }
        } else if ("resetM".equals(actionCommand)) {
            mDB.deleteFood(pC.get(pDB.getRowCount() - 1).getId_pemesanan());
            pDB.deleteOrder(pC.get(pDB.getRowCount() - 1).getId_pemesanan());
            new GUIAwal();
            SwingUtilities.getWindowAncestor(foodPanel).dispose();
        } else if ("cekPButton".equals(actionCommand)) {
            new GUICekPesanan();
            SwingUtilities.getWindowAncestor(foodPanel).dispose();
        }
    }
    public JPanel getFoodPanel() {
        return foodPanel;
    }
}

