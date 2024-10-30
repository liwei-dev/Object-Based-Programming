package org.example;

import org.sql2o.Connection;

import static org.example.Database.db;

public class MemberDB {
    public boolean loginMember(String noTelp_member, String nama_member ) {
        String sql = "SELECT COUNT(*) FROM member WHERE noTelp_member = :noTelp_member AND nama_member = :nama_member";
        try (Connection con = db.open()) {
            int count = con.createQuery(sql)
                    .addParameter("noTelp_member", noTelp_member)
                    .addParameter("nama_member", nama_member)
                    .executeScalar(Integer.class);

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getRowCount() {
        int rowCount = 0;
        String sql = "SELECT COUNT(*) FROM member";
        try (Connection con = Database.db.open()) {
            rowCount = con.createQuery(sql)
                    .executeScalar(Integer.class);
        }
        return rowCount;
    }

    public String getIDm (String noTelp_member, String nama_member){
        String id = "";
        String sql = "SELECT id_member FROM member WHERE noTelp_member = :noTelp_member AND nama_member = :nama_member";
        try (Connection con = db.open()){
            id = con.createQuery(sql)
                    .addParameter("noTelp_member", noTelp_member)
                    .addParameter("nama_member", nama_member)
                    .executeScalar(String.class);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        }
    }

    public int poinMember(String id_member){
        String sql = "SELECT poin_member FROM member WHERE id_member = :id_member";
        try (Connection con = db.open()){
            int poin = con.createQuery(sql)
                    .addParameter("id_member", id_member)
                    .executeScalar(Integer.class);
            return poin;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void addMember(String id_member, String noTelp_member, String nama_member){
        String sql = "INSERT INTO member VALUES(:id_member, :nama_member, :noTelp_member, 0)";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("id_member", id_member)
                    .addParameter("noTelp_member", noTelp_member)
                    .addParameter("nama_member", nama_member)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePoin(int poin_member, String id_member){
        String sql = "UPDATE member SET poin_member = :poin_member WHERE id_member = :id_member";
        try (Connection con = db.open()) {
            con.createQuery(sql)
                    .addParameter("poin_member", poin_member)
                    .addParameter("id_member", id_member)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean cekMember(String noTelp_member, String nama_member){
        String sql = "SELECT COUNT(*) FROM member WHERE noTelp_member = :noTelp_member AND nama_member = :nama_member";
        try (Connection con = db.open()) {
            int count = con.createQuery(sql)
                    .addParameter("noTelp_member", noTelp_member)
                    .addParameter("nama_member", nama_member)
                    .executeScalar(Integer.class);

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
