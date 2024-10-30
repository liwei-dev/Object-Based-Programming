package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMemberRegis {
    private JFrame frame;
    private JTextField fieldNama, fieldNoTelp;

    MemberDB meDB = new MemberDB();
    int idc;
    String id_member;

    public GUIMemberRegis() {
        frame = new JFrame("Registrasi Member");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setResizable(false);

        JLabel labelNama = new JLabel("Nama:");
        fieldNama = new JTextField();
        labelNama.setBounds(20, 20, 100, 25);
        fieldNama.setBounds(120, 20, 200, 25);

        JLabel labelNoTelp = new JLabel("Nomor Telepon:");
        fieldNoTelp = new JPasswordField();
        labelNoTelp.setBounds(20, 50, 100, 25);
        fieldNoTelp.setBounds(120, 50, 200, 25);

        JButton regisBtn = new JButton("Register");
        regisBtn.setBounds(170, 90, 100, 25);
        regisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!meDB.cekMember(fieldNoTelp.getText(), fieldNama.getText())) {
                    idc = meDB.getRowCount() ;
                    id_member = "P" + idc;
                    meDB.addMember(id_member, fieldNoTelp.getText(), fieldNama.getText());
                    JOptionPane.showMessageDialog(frame, "Member berhasil dibuat!");
                    fieldNama.setText("");
                    fieldNoTelp.setText("");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Member sudah terdaftar!");
                }
            }
        });

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