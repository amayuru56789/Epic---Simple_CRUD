/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.dao;

import com.mycompany.simplecrud.util.Encryption;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author indee
 */
public class LoginDao {
    Encryption encryption;

    public LoginDao() throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
        encryption = new Encryption();
    }
    
    public boolean checkEqualityUser(String userID, String password) throws ClassNotFoundException, SQLException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        //String query = "select * from Registration where userID=? && password=?";
        PreparedStatement pstm = con.prepareStatement("select * from Registration where userID=? ");
        pstm.setObject(1, userID);
        //pstm.setObject(2, password);
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()){
            String passwordEncrypt=rst.getString(6);
            String passwordDecrypt=encryption.decrypt(passwordEncrypt);
                if (password.equals(passwordDecrypt)){
                    return true;
                }else{
                    return false;
                }
            //return true;
        }else{
            return false;
        }
    }
}
