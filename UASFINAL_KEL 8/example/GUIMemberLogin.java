package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMemberLogin {
    private JFrame frame;
    private JTextField fieldNama;
    private JTextField fieldNoTelp;
    GUIStruk sT;
    String notelp;
    String nama;
    MemberDB mDB = new MemberDB();
    boolean Result;

    private GUICekPesanan gcp;


    public GUIMemberLogin(GUIStruk sT, GUICekPesanan guiCekPesanan) {
        this.sT = sT;
        this.gcp = guiCekPesanan;
        MemberConstructor mC = new MemberConstructor();

        frame = new JFrame("Login Member");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        JLabel labelNama = new JLabel("Nama:");
        fieldNama = new JTextField();
        labelNama.setBounds(20, 20, 100, 25);
        fieldNama.setBounds(120, 20, 200, 25);


        JLabel labelNoTelp = new JLabel("Nomor Telepon:");
        fieldNoTelp = new JPasswordField();
        labelNoTelp.setBounds(20, 50, 100, 25);
        fieldNoTelp.setBounds(120, 50, 200, 25);


        JButton regisBtn = new JButton("Checkout");
        regisBtn.setBounds(170, 90, 100, 25);
        regisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fieldNama.getText().isEmpty() || !fieldNoTelp.getText().isEmpty()) {
                    nama = fieldNama.getText();
                    notelp = fieldNoTelp.getText();
                    Result = mDB.loginMember(notelp, nama);
                    if(Result == true){
                        mC.setNoTelp_member(notelp);
                        mC.setNama_member(nama);
                        GUIMenuPembayaran mP = new GUIMenuPembayaran(mC);
                        JOptionPane.showMessageDialog(frame, "Member berhasil Login!");
                        fieldNama.setText("");
                        fieldNoTelp.setText("");
                        frame.setVisible(false);
                        gcp.frame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Member Salah");
                    }
                }
            }
        });

        fieldNama.setText(fieldNama.getText());
        frame.setLayout(null);
        frame.add(labelNama);
        frame.add(fieldNama);
        frame.add(labelNoTelp);
        frame.add(fieldNoTelp);
        frame.add(regisBtn);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}