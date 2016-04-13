/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziaskincare.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ai
 */
public class DatabaseConnection {

    Connection conn = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/zia_skin_care";
    String user = "root";
    String pass = "123sahatea";

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, pass);
        System.out.println("koneksi berhasil");
        return conn;

    }
}
