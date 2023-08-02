package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {

    public static Connection geConnection() throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","alaa01064784975");
        con.setAutoCommit(false);
        return con;
    }
}
