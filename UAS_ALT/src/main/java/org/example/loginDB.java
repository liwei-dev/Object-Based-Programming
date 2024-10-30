package org.example;

import org.sql2o.Connection;

import java.util.List;

import static org.example.Database.db;

public class loginDB {
    public boolean cekLogin(String user_Code){
        String sql = "SELECT COUNT(*) FROM user_acc WHERE userCode = :userCode";
        try (Connection con = db.open()) {
            int count = con.createQuery(sql)
                    .addParameter("userCode", user_Code)
                    .executeScalar(Integer.class);

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
