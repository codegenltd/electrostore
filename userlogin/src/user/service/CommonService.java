/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import user.model.UserModel;
import user.util.DBConnection;

/**
 *
 * @author HP
 */
public class CommonService {
    Connection con;
    
     public int userReg(UserModel m) throws SQLException{
        con = DBConnection.getCon();
        String sql = "INSERT INTO userlogin (userid, name, username, age, password) VALUES (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, m.getUserid());
        ps.setString(2, m.getName());
        ps.setString(3, m.getUsername());
        ps.setInt(4, m.getAge());
        ps.setString(5, m.getPassword());

        
        int status = ps.executeUpdate();
        return status;
        
        
      
    
    }
    public boolean userlogin(UserModel m) throws SQLException{
        con = DBConnection.getCon();
        String sql = "SELECT * FROM userlogin WHERE username = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
       
        ps.setString(1, m.getUsername());
       
        
        ResultSet rs = ps.executeQuery();
        
    
      
        
        
        return rs.next();
    
    }
    
}
