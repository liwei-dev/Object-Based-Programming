package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUIMinumanAdd extends JFrame implements ActionListener {
    JFrame window;
    JComboBox<String> rasa;
    JComboBox<String> topping;
    private String r;
    private String t;
    private String kodeR;
    private String kodeT;
    private Integer hargaT;
    GUIMenuMinuman mN;
    int idPm;
    MinumanDB minDB = new MinumanDB();
    PemesananDB pDB = new PemesananDB();

    public GUIMinumanAdd(GUIMenuMinuman menuMinuman) {
        this.mN = menuMinuman;

        //Declare DB
        MinumanDB minDB = new MinumanDB();

        //Mengisi Constructor Dari Database
        List<RasaConstructor> rasaMin = minDB.rasaList();
        List<ToppingConstructor> topMin = minDB.topList();

        //Membuat Frame
        window = new JFrame();
        window.setTitle("Minuman");
        window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        window.setResizable(false);

        //Membuat Panel
        JPanel utama = new JPanel();
        utama.setLayout(new FlowLayout(FlowLayout.LEFT));

        //Membuat ComboBox Rasa
        JPanel atasR = new JPanel();
        JLabel tR = new JLabel("Pilih Rasa      : ");
        rasa = new JComboBox<>();
        for (RasaConstructor rC : rasaMin) {
            rasa.addItem(rC.getNama_rasa());
        }
        rasa.setMaximumSize(new Dimension(80, 20));

        atasR.add(tR);
        atasR.add(rasa);

        //Membuat ComboBox Topping
        JPanel bawahT = new JPanel();
        JLabel tT = new JLabel("Pilih Topping : ");
        topping = new JComboBox<>();
        for (ToppingConstructor tC : topMin) {
            topping.addItem(tC.getNama_topping());
        }
        JLabel priceT = new JLabel(" + Rp 5.000");
        bawahT.add(tT);
        bawahT.add(topping);
        bawahT.add(priceT);

        //Membuat Button Done
        JButton done = new JButton("Selesai");
        done.setPreferredSize(new Dimension(170, 30));
        done.addActionListener(this);
        done.setActionCommand("d");

        utama.add(atasR);
        utama.add(bawahT);
        utama.add(done);

        window.add(utama);

        window.setSize(300, 160);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if ("d".equals(actionCommand)) {

            //Untuk mengambil item yang di pilih
            r = rasa.getSelectedItem().toString();
            t = topping.getSelectedItem().toString();

            //Untuk mengambil kode dari database
            kodeR = minDB.getRasaID(r);
            kodeT = minDB.getTopID(t);

            //Untuk mengambil harga topping
            hargaT = minDB.getHargaTop(kodeT);

            //Kondisi untuk tanpa rasa
            if ("No Flavour".equals(r)) {
                mN.updateDrink(mN.getMinumN());
                //Kondisi jika tanpa topping
                if ("No Topping".equals(t)) {
                    mN.updateTop("No Topping");
                //Kondisi dengan topping
                } else {
                    mN.updateTop(t + " + Rp 5.000");
                    minDB.updateDrinkPrice(mN.getIdMin(), kodeR, kodeT, mN.getDrinkLoc() + 5000);
                }
            }
            //Kondisi dengan rasa
            else{
                mN.updateDrink(r + " " + mN.getMinumN());
                //Kondisi tanpa topping
                if ("No Topping".equals(t)) {
                    mN.updateTop("No Topping");
                //Kondisi dengan topping
                } else {
                    mN.updateTop(t + " + Rp 5.000");
                    minDB.updateDrinkPrice(mN.getIdMin(), kodeR, kodeT, mN.getDrinkLoc() + 5000);
                }
            }

            //Kondisi jika minuman belum pernah di pesan
            if (!minDB.cekDrink(mN.getIdMin(), minDB.getRasaID(r), minDB.getTopID(t))) {
                idPm = minDB.getRowCount() + 1;
                String idPesanMinum = "PM" + Integer.toString(idPm);

                minDB.addDrink(idPesanMinum, mN.getIdMin(), minDB.getRasaID(r), minDB.getTopID(t));
                minDB.addDorder(idPesanMinum, "PE" + String.valueOf(pDB.getRowCount()));

                mN.kuantitasD.setText("0");
            } else {
                mN.kuantitasD.setText(Integer.toString(minDB.getKuantitas(mN.getIdMin(), minDB.getRasaID(r), minDB.getTopID(t))));
            }
            window.dispose();
        }
    }

    public String getKodeR() {
        return kodeR;
    }

    public String getKodeT() {
        return kodeT;
    }

    public Integer getHargaT() {
        return hargaT;
    }
}
