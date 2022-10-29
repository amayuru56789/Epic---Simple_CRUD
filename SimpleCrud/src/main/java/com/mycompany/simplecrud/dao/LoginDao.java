/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author indee
 */
public class LoginDao {
    public boolean checkEqualityUser(String userID, String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        String query = "select * from Registration where userID=? && password=?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setObject(1, userID);
        pstm.setObject(2, password);
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()){
            return true;
        }else{
            return false;
        }
    }
}
