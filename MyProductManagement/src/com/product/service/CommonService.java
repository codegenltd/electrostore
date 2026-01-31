/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product.service;

import com.myproduct.model.Product;
import com.myproduct.util.DBConnection;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class CommonService {
    Connection con;
    private Component rootPane;
    public int create(Product p) throws SQLException{
        
     
         con = DBConnection.getConnection();
         String sql ="INSERT INTO productlist (pid , name, qty, price) VALUES (?,?,?,?)";
         
         PreparedStatement std = con.prepareStatement(sql);
         std.setInt(1, p.getPid());
         std.setString(2, p.getName());
         std.setInt(3, p.getQty());
         std.setDouble(4, p.getPrice());
         int status = std.executeUpdate();
         return status;
    };
    
    public int update(Product c) throws SQLException{
        con = DBConnection.getConnection();
        String sql = "UPDATE productlist SET  name = ? , qty = ? , price = ? WHERE pid = ? ";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setString(1, c.getName());
        st.setInt(2, c.getQty());
        st.setDouble(3,c.getPrice());
        st.setInt(4, c.getPid());
        
        int status = st.executeUpdate();
    return status;
    }
    public int delete (int pid) throws SQLException{
     con = DBConnection.getConnection();
        String sql = "DELETE FROM productlist WHERE pid = ? ";
        
        PreparedStatement st = con.prepareStatement(sql);
         st.setInt(1, pid);
       
        
        int status = st.executeUpdate();
    return status;
    }
    public Product getId (int pid) throws SQLException{
        con = DBConnection.getConnection();
        String sql = "SELECT * FROM productlist WHERE pid = (?) ";
        PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1, pid);
       ResultSet rs = ps.executeQuery();
       Product p = new Product();
       if(rs.next()){
       p.setName(rs.getString("name"));
       p.setQty(rs.getInt("qty"));
       p.setPrice(rs.getDouble("price"));
       }else{
        JOptionPane.showMessageDialog(rootPane, " not found product");
       }
        
        
    return p;
    }

   
    
}
