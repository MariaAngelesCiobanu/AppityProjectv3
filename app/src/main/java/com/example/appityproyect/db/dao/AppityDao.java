package com.example.appityproyect.db.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class AppityDao {

    private ConnectionManager connectionManager;

    public AppityDao(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
    public List<Appity> list() {
        Connection con = null;
        try {
            con = connectionManager.getConnection();

             var ps = con.prepareStatement("SELECT * FROM book");

            var rs = ps.executeQuery();
            List<Appity> apps = new ArrayList<>();
            while (rs.next()) {
                Appity apps1 = new Appity(
                        rs.getString("username"),
                        rs.getString("passReg"),
                        rs.getString("passReg2"),
                        rs.getInt("edad"),
                        rs.getString("email"),
                        rs.getString("email2"),
                        rs.getString("dni_nie")
                );
                apps.add(apps1);
            }

            return apps;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public boolean save(Appity apps) {
        Connection con = null;
        try {
            con = connectionManager.getConnection();

            var ps = con.prepareStatement("INSERT INTO apps(username, passReg, passReg2, edad, email, email2, nie_dni) VALUES(?,?,?,?,?,?,?)");

            ps.setString(1, apps.getUsername());
            ps.setString(2, apps.getPassReg());
            ps.setString(3, apps.getPassReg2());
            ps.setInt(4, apps.getEdad());
            ps.setString(5, apps.getEmail());
            ps.setString(6, apps.getEmail2());
            ps.setString(7, apps.getNieDni());

            int insertedRows = ps.executeUpdate();
            return insertedRows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
