package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class GUIStruk extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel, panel1;
    PemesananDB pDB = new PemesananDB();
    MinumanDB minDB = new MinumanDB();
    MakananDB makDB = new MakananDB();
    int totalHarga = makDB.totalFoodOrder() + minDB.totalDrinkOrder();
    LocalDateTime nowDate = LocalDateTime.now();
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String date = nowDate.format(formatDate);
    MemberDB meDB = new MemberDB();
    MemberConstructor mC;
    int poinPlus;
    int poinNow;
    int poinAdd;
    public GUIStruk(MemberConstructor mC){

        this.mC = mC;

        panel = new JPanel();
        panel.setBackground(new Color(80, 139, 152));
        Border border = new LineBorder(new Color(38, 74, 77), 20, false);
        panel.setBorder(border);
        panel.setLayout(null);

        JButton nextButton = new JButton("Next");
        nextButton.setFocusable(false);
        nextButton.setBackground(new Color(255,255,255));
        nextButton.setFont(new Font("", Font.BOLD, 15));
        nextButton.setActionCommand("Next");
        nextButton.addActionListener(this);
        nextButton.setBounds(500, 865, 150, 60);
        panel.add(nextButton);

        panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(null);
        panel1.setBounds(125, 130, 440, 500);

        JLabel labelJudul = new JLabel("NOMOR PESANAN");
        labelJudul.setFont(new Font("", Font.BOLD, 35));
        labelJudul.setBounds(70, 5, 400, 75);
        panel1.add(labelJudul);

        JLabel labelNomor = new JLabel("PM" + pDB.getRowCount());
        labelNomor.setFont(new Font("", Font.PLAIN, 30));
        labelNomor.setBounds(183, 50, 200, 75);
        panel1.add(labelNomor);

        JLabel strip = new JLabel("---------------------------------");
        strip.setFont(new Font("", Font.PLAIN, 30));
        strip.setBounds(58, 100, 400, 30);
        panel1.add(strip);

        JLabel labelBrand = new JLabel("NicoBoba");
        labelBrand.setFont(new Font("", Font.PLAIN, 14));
        labelBrand.setBounds(190, 120, 400, 30);
        panel1.add(labelBrand);

        pDB.StrukMakanan();
        pDB.StrukMinuman();
        pDB.updateHtotal(totalHarga, "PE" + pDB.getRowCount());

        String strukRows[][] = new String[pDB.getStrukList().size() / 3][3];
        int row = 0;

        for (int i = 0; i < pDB.getStrukList().size(); i += 3) {
            strukRows[row][0] = pDB.getStrukList().get(i);
            strukRows[row][1] = pDB.getStrukList().get(i + 1);
            strukRows[row][2] = pDB.getStrukList().get(i + 2);
            row++;
        }

        String column[] = {"Nama", "Qty.", "Harga"};
        JTable table = new JTable(strukRows, column);
        table.setBackground(Color.WHITE);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.WHITE);
        table.setBounds(58, 150, 330, 200);

        //Untuk buat text pada kolom centered
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        //Untuk kolom tertenti
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        //Untuk resize kolom
        TableColumn column0 = table.getColumnModel().getColumn(0);
        column0.setPreferredWidth(270);

        TableColumn column1 = table.getColumnModel().getColumn(1);
        column1.setPreferredWidth(50);

        TableColumn column2 = table.getColumnModel().getColumn(2);
        column2.setPreferredWidth(100);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(58, 150, 330, 200);
        panel1.add(scrollPane);

        JLabel labelPb = new JLabel("Metode Pembayaran :                        " + pDB.getMP("PE" + String.valueOf(pDB.getRowCount())));
        labelPb.setFont(new Font("", Font.PLAIN, 12));
        labelPb.setBounds(57, 355, 300, 20);
        panel1.add(labelPb);

        JLabel labelTotal = new JLabel("Total: Rp " + totalHarga);
        labelTotal.setFont(new Font("", Font.PLAIN, 12));
        labelTotal.setBounds(247, 355, 150, 60);
        panel1.add(labelTotal);

        JLabel labelPoin = new JLabel("Poin Anda: ");
        labelPoin .setFont(new Font("", Font.PLAIN, 12));
        labelPoin .setBounds(57, 355, 150, 60);
        labelPoin.setVisible(false);
        if(mC != null){
            labelPoin.setVisible(meDB.loginMember(mC.getNoTelp_member(), mC.getNama_member()));
            if (totalHarga >= 1000){
                poinPlus = totalHarga / 1000;
                poinNow = meDB.poinMember(meDB.getIDm(mC.getNoTelp_member(), mC.getNama_member()));
                poinAdd = poinNow + poinPlus;
                meDB.updatePoin(poinAdd, meDB.getIDm(mC.getNoTelp_member(), mC.getNama_member()));
                pDB.updateMember(meDB.getIDm(mC.getNoTelp_member(), mC.getNama_member()), "PE" + String.valueOf(pDB.getRowCount()));
                labelPoin.setText("Poin Anda: " + poinAdd);
            }
            else {
                labelPoin.setText("Poin Anda: " + meDB.poinMember(meDB.getIDm(mC.getNoTelp_member(), mC.getNama_member())));
            }
        }
        panel1.add(labelPoin);

        JLabel strip2 = new JLabel("---------------------------------");
        strip2.setFont(new Font("", Font.PLAIN, 30));
        strip2.setBounds(58, 370, 400, 70);
        panel1.add(strip2);

        JLabel labelTanggal = new JLabel(date);
        labelTanggal.setFont(new Font("", Font.PLAIN, 16));
        labelTanggal.setBounds(150, 400, 400, 80);
        panel1.add(labelTanggal);

        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                nextButton.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                nextButton.setCursor(Cursor.getDefaultCursor());
                nextButton.setBackground(Color.WHITE);
            }
        });

        frame = new JFrame();
        panel.add(panel1);
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
        if("Next".equals(ac)){
            frame.dispose();
            GUIAkhir n = new GUIAkhir();
            minDB.deleteDrinkOrder();
            minDB.deleteDrink("PE" + Integer.toString(pDB.getRowCount()));
            makDB.deleteFoodOrder();
        }
    }
}
