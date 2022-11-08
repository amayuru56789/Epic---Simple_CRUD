/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.dao;

import com.mycompany.simplecrud.db.DbConnection;
import com.mycompany.simplecrud.model.Registration;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author indee
 */
public class RegistrationDao {
    
    Encryption en;

    public RegistrationDao() throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
        this.en = new Encryption();
    }
    
    public boolean registerUser(Registration registration) throws ClassNotFoundException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
      
        try {
            LocalDateTime time = LocalDateTime.now();  
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
            String formatDateTime = time.format(format);   
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
            
            String passwordEncrypt = en.encrypt(registration.getPassword());
            PreparedStatement pstm = con.prepareStatement("insert into Registration values(?,?,?,?,?,?,?,?)");
            pstm.setObject(1, registration.getUserID());
            pstm.setObject(2, registration.getUserName());
            pstm.setObject(3, registration.getAddress());
            pstm.setObject(4, registration.getEmail());
            pstm.setObject(5, registration.getContact());
            pstm.setObject(6, passwordEncrypt);
            pstm.setObject(7, formatDateTime);
            pstm.setObject(8, "");
            if (pstm.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Registration> getAllUser() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Registration");
        
        ResultSet rst = pstm.executeQuery();
        //System.out.println(rst.getObject(1));
        ArrayList<Registration> load = new ArrayList<>();
        while(rst.next()){
             Registration registration = new Registration(
                     rst.getString(1),
                     rst.getString(2),
                     rst.getString(3),
                     rst.getString(4),
                     rst.getString(5),
                     rst.getString(6)
             );
             load.add(registration);
        }
        
        return load;
    }
    
    public boolean updateUser(Registration registration) throws ClassNotFoundException, SQLException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
        Registration searchUser = getAllRegistrationDetails(registration.getUserID());
        String createTime = searchUser.getCreateTime();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        LocalDateTime time = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String lastDateTime = time.format(format);
        String passwordEncrypt = en.encrypt(registration.getPassword());
        PreparedStatement pstm = con.prepareStatement("update Registration set userName=?, address=?, email=?, contact=?, password=?, createTime=?, lastUpdateTime=? where userID=?");
        pstm.setObject(1, registration.getUserName());
        pstm.setObject(2, registration.getAddress());
        pstm.setObject(3, registration.getEmail());
        pstm.setObject(4, registration.getContact());
        pstm.setObject(5, passwordEncrypt);
        pstm.setObject(6, createTime);
        pstm.setObject(7, lastDateTime);
        pstm.setObject(8, registration.getUserID());
        
        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deleteUser(String userID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("delete from Registration where userID=?");
        pstm.setObject(1, userID);
        
        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }
    
    public Registration searchUser(String userID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Registration where userID=?");
        pstm.setObject(1, userID);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return new Registration(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }else{
            return null;
        }
    }
    
    public Registration getAllRegistrationDetails(String userID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from registration where userID=?");
        pstm.setObject(1, userID);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                return new Registration(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8)
                );
            }else{
                return null;
            }
    }

//    public boolean registerUser(Registration registration) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
