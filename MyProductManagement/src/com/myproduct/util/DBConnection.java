/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproduct.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class DBConnection {
static Connection con;
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/productmgt";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return con;
    }
}
