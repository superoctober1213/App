package com.example.myapplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBService {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try{
            Properties pro = new Properties();

            ClassLoader classLoader = DBService.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            pro.load(new FileReader(path));

            //pro.load(new FileReader("src/jdbc.properties"));

            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            Class.forName(driver);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Statement stmt, Connection conn) {
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeAll(Statement stmt, Connection conn, ResultSet rs) {
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null){
            try {
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


