/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.dao;

import com.mycompany.simplecrud.db.DbConnection;
import com.mycompany.simplecrud.model.Registration;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indee
 */
public class RegistrationDao {
    
    public boolean registerUser(Registration registration) throws ClassNotFoundException{
        DbConnection connection = null;
      
        try {
            connection = new DbConnection();
            PreparedStatement pstm = connection.getConnection().prepareStatement("insert into Registration values(?,?,?,?,?,?)");
            pstm.setObject(1, registration.getUserID());
            pstm.setObject(2, registration.getUserName());
            pstm.setObject(3, registration.getAddress());
            pstm.setObject(4, registration.getEmail());
            pstm.setObject(5, registration.getContact());
            pstm.setObject(6, registration.getPassword());
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
       
        DbConnection connection = null;
        connection = new DbConnection();
        PreparedStatement pstm = connection.getConnection().prepareStatement("select * from Registration");
        
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
        connection.connection.close();
        return load;
    } 
}
