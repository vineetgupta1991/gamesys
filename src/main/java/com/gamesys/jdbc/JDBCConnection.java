package com.gamesys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    static final String DB_URL = "jdbc:h2:~/rss_feed";
    static final String USER = "sa";
    static final String PASS = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
