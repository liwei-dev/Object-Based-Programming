package org.example;

import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

import static org.example.Database.db;

public class MinumanDB {
    public List<MinumanConstructor> drinkList() {
        String sql = "SELECT * FROM minuman";
        try (Connection con = Database.db.open()) {
            return con.createQuery(sql).executeAndFetch(MinumanConstructor.class);
        }
    }

    public List<RasaConstructor> rasaList() {
        String sql = "SELECT * FROM rasa";
        try (Connection con = Database.db.open()) {
            return con.createQuery(sql).executeAndFetch(RasaConstructor.class);
        }
    }

    public List<ToppingConstructor> topList() {
        String sql = "SELECT * FROM topping";
        try (Connection con = Database.db.open()) {
            return con.createQuery(sql).executeAndFetch(ToppingConstructor.class);
        }
    }

    public void addDrink(String id_pMin, String idMin, String idRasa, String idTop) {
        String sql = "INSERT INTO pesanminum VALUES (:id_pMin, :idMin, :idRasa, :idTop, 0, 0)";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("id_pMin", id_pMin)
                    .addParameter("idMin", idMin)
                    .addParameter("idRasa", idRasa)
                    .addParameter("idTop", idTop)
                    .executeUpdate();
        }
    }

    public int getRowCount() {
        int rowCount = 0;
        String sql = "SELECT COUNT(*) FROM pesanminum";
        try (Connection con = Database.db.open()) {
            rowCount = con.createQuery(sql)
                    .executeScalar(Integer.class);
        }
        return rowCount;
    }

    public String getRasaID(String nama_rasa) {
        String rasaResult;
        String sql = "SELECT id_rasa FROM rasa WHERE nama_rasa = :nama_rasa";
        try (Connection con = db.open()) {
            rasaResult = con.createQuery(sql)
                    .addParameter("nama_rasa", nama_rasa)
                    .executeScalar(String.class);
        }
        return rasaResult;
    }

    public String getTopID(String nama_topping) {
        String topResult;
        String sql = "SELECT id_topping FROM topping WHERE nama_topping = :nama_topping";
        try (Connection con = db.open()) {
            topResult = con.createQuery(sql)
                    .addParameter("nama_topping", nama_topping)
                    .executeScalar(String.class);
        }
        return topResult;
    }

    public void addDorder(String idpMin, String id_pemesanan) {
        String sql = "INSERT INTO pesanan_minuman VALUES (:idpMin, :id_pemesanan)";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("idpMin", idpMin)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }

    public void updateDrinkK(String idMin, String idRasa, String idTop, int kuantitas) {
        String sql = "UPDATE pesanminum SET kuantitasMin = :kuantitas WHERE id_minuman = :idMin AND id_rasa = :idRasa AND id_topping = :idTop";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("idMin", idMin)
                    .addParameter("idRasa", idRasa)
                    .addParameter("idTop", idTop)
                    .addParameter("kuantitas", kuantitas)
                    .executeUpdate();
        }
    }

    public void updateDrinkPrice(String idMin, String idRasa, String idTop, int harga) {
        String sql = "UPDATE pesanminum SET totalH_min = :harga WHERE id_minuman = :idMin AND id_rasa = :idRasa AND id_topping = :idTop";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("idMin", idMin)
                    .addParameter("idRasa", idRasa)
                    .addParameter("idTop", idTop)
                    .addParameter("harga", harga)
                    .executeUpdate();
        }
    }

    public boolean cekDrink(String id_minuman, String id_rasa, String id_topping) {
        String sql = "SELECT COUNT(*) FROM pesanminum WHERE id_minuman = :id_minuman AND id_rasa = :id_rasa AND id_topping = :id_topping";
        try (Connection con = db.open()) {
            int count = con.createQuery(sql)
                    .addParameter("id_minuman", id_minuman)
                    .addParameter("id_rasa", id_rasa)
                    .addParameter("id_topping", id_topping)
                    .executeScalar(Integer.class);

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteDrink(String id_pemesanan){
        String sql = "DELETE FROM pesanan_minuman WHERE id_pemesanan = :id_pemesanan";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("id_pemesanan", id_pemesanan)
                    .executeUpdate();
        }
    }

    public void deleteDrinkOrder() {
        String sql = "DELETE FROM pesanminum";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }
    }

    public int totalDrinkOrder() {
        String sql = "SELECT SUM(totalH_min) AS total FROM pesanminum";
        try (Connection con = db.open()) {
            Integer total = con.createQuery(sql)
                    .executeScalar(Integer.class);
            return total != null ? total : 0;
        }
    }

    public int getKuantitas(String id_minuman, String id_rasa, String id_topping) {
        String sql = "SELECT kuantitasMin FROM pesanminum WHERE id_minuman = :id_minuman AND id_rasa = :id_rasa AND id_topping = :id_topping";
        try (Connection con = db.open()) {
            int count = con.createQuery(sql)
                    .addParameter("id_minuman", id_minuman)
                    .addParameter("id_rasa", id_rasa)
                    .addParameter("id_topping", id_topping)
                    .executeScalar(Integer.class);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getHargaTop(String id_topping) {
        int topHarga;
        String sql = "SELECT harga_topping FROM topping WHERE id_topping = :id_topping";
        try (Connection con = db.open()) {
            topHarga = con.createQuery(sql)
                    .addParameter("id_topping", id_topping)
                    .executeScalar(Integer.class);
        }
        return topHarga;
    }
}