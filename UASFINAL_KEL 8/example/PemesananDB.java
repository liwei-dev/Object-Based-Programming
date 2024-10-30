package org.example;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.example.Database.db;

public class PemesananDB {

    ArrayList<String> strukList = new ArrayList<>();
    public void createOrder(String id_pemesanan) {
        String sql = "INSERT INTO pemesanan VALUES (:id_pemesanan, 'P000', NOW(), 0, 'None')";
        try (Connection con = Database.db.open()) {
            con.createQuery(sql)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }

    public int getRowCount() {
        int rowCount = 0;
        String sql = "SELECT COUNT(*) FROM pemesanan";
        try (Connection con = Database.db.open()) {
            rowCount = con.createQuery(sql)
                    .executeScalar(Integer.class);
        }
        return rowCount;
    }
    public List<PemesananConstructor> getOrder() {
        String sql = "SELECT * FROM pemesanan";
        try (Connection con = Database.db.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(PemesananConstructor.class);
        }
    }

    public void deleteOrder(String id_pemesanan){
        String sql = "DELETE FROM pemesanan WHERE id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }



    public ArrayList<String> StrukMakanan() {

        try (Connection connection = db.open()) {
            String query = "SELECT m.nama_makanan, pmak.kuantitasMak, pmak.totalH_mak FROM makanan m JOIN pesanan_makanan pmak ON(m.id_makanan = pmak.id_makanan)";

            try (PreparedStatement preparedStatement = db.getConnectionSource().getConnection().prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String foodName = resultSet.getString("nama_makanan");
                    int quantity = resultSet.getInt("kuantitasMak");
                    double totalPrice = resultSet.getDouble("totalH_mak");

                    strukList.add(foodName);
                    strukList.add(String.valueOf(quantity));
                    strukList.add(String.valueOf(totalPrice));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return strukList;
    }

    public ArrayList<String> StrukMinuman() {
        try (Connection connection = db.open()) {
            String query = "SELECT min.nama_minuman, m.kuantitasMin, m.totalH_min FROM minuman min JOIN pesanminum m ON(min.id_minuman = m.id_minuman) JOIN pesanan_minuman pmin ON(m.id_pesanMinum = pmin.id_pesanMinum)";

            try (PreparedStatement preparedStatement = db.getConnectionSource().getConnection().prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String drinkName = resultSet.getString("nama_minuman");
                    int quantity = resultSet.getInt("kuantitasMin");
                    double totalPrice = resultSet.getDouble("totalH_min");

                    strukList.add(drinkName);
                    strukList.add(String.valueOf(quantity));
                    strukList.add(String.valueOf(totalPrice));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return strukList;
    }

    public void updateMP (String metode_pembayaran, String id_pemesanan) {
        String sql = "UPDATE pemesanan SET metode_pembayaran = :metode_pembayaran WHERE id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()){
            con.createQuery(sql)
                    .addParameter("metode_pembayaran", metode_pembayaran)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }

    public String getMP (String id_pemesanan) {
        String mp;
        String sql = "SELECT metode_pembayaran FROM pemesanan WHERE id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()){
            mp = con.createQuery(sql)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeScalar(String.class);
        }
        return mp;
    }

    public void updateHtotal (int harga_total, String id_pemesanan) {
        String sql = "UPDATE pemesanan SET harga_total = :harga_total WHERE id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()){
            con.createQuery(sql)
                    .addParameter("harga_total", harga_total)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }

    public void updateMember (String id_member, String id_pemesanan) {
        String sql = "UPDATE pemesanan SET id_member = :id_member WHERE id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()){
            con.createQuery(sql)
                    .addParameter("id_member", id_member)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }


    public ArrayList<String> getStrukList() {
        return strukList;
    }
}
