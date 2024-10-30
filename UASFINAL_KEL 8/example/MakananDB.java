package org.example;

import org.sql2o.Connection;

import java.util.List;

import static org.example.Database.db;

public class MakananDB {
    public List<MakananConstructor> foodList() {
        String sql = "SELECT * FROM makanan";
        try (Connection con = Database.db.open()) {
            return con.createQuery(sql).executeAndFetch(MakananConstructor.class);
        }
    }

    public void addFood(String idMak, String id_pemesanan) {
        String sql = "INSERT INTO pesanan_makanan VALUES (:idMak, :id_pemesanan, 0, 0)";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("idMak", idMak)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }

    public void updateFoodK(String idMak, String id_pemesanan, int kuantitas) {
        String sql = "UPDATE pesanan_makanan SET kuantitasMak = :kuantitas WHERE id_makanan = :idMak AND id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("idMak", idMak)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .addParameter("kuantitas", kuantitas)
                    .executeUpdate();
        }
    }

    public void updateFoodPrice(String idMak, String id_pemesanan, int harga) {
        String sql = "UPDATE pesanan_makanan SET totalH_mak = :harga WHERE id_makanan = :idMak AND id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("idMak", idMak)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .addParameter("harga", harga)
                    .executeUpdate();
        }
    }

    public void deleteFood(String id_pemesanan){
        String sql = "DELETE FROM pesanan_makanan WHERE id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }

    public void deleteFoodOrder() {
        String sql = "DELETE FROM pesanan_makanan";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }
    }

    public int totalFoodOrder() {
        String sql = "SELECT SUM(totalH_mak) AS total FROM pesanan_makanan";
        try (Connection con = db.open()) {
            Integer total = con.createQuery(sql)
                    .executeScalar(Integer.class);
            return total != null ? total : 0;
        }
    }

}
