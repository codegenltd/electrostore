/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import user.model.UserModel;

/**
 *
 * @author HP
 */
public class DBConnection {
   static Connection con;
    public static Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userlogin";
            String user = "root";
            String password = "root";
            con = DriverManager.getConnection(url, user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return con;
    }
}
