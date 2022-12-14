/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.controller;

import com.mycompany.simplecrud.bo.LoginBo;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author indee
 */
@WebServlet(urlPatterns = "/Login")
public class LoginServlet extends HttpServlet{

    LoginBo loginBo = new LoginBo();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
            
            JsonReader reader = Json.createReader(req.getReader());
            JsonObject obj = reader.readObject();
            PrintWriter writer = resp.getWriter();
            
            String userName = obj.getString("userName");
            String password = obj.getString("password");
            
            boolean equal = loginBo.equalityUser(userName, password);
            if (equal){
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 200);
                response.add("message", true);
                response.add("data", JsonValue.NULL);
                writer.print(response.build());
            }else{
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 400);
                response.add("message", false);
                response.add("data", JsonValue.NULL);
                writer.print(response.build());
            }
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("application/json");
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
//            PreparedStatement pstm = con.prepareStatement("select * from Registration");
//            ResultSet rst = pstm.executeQuery();
//            
//            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//            PrintWriter writer = resp.getWriter();
//
//            while (rst.next()) {
//                JsonObjectBuilder objBuilder = Json.createObjectBuilder();
//                objBuilder.add("id",rst.getString(1));
//                objBuilder.add("name",rst.getString(2));
//                objBuilder.add("address",rst.getString(3));
//                objBuilder.add("salary",rst.getDouble(4));
//
//                arrayBuilder.add(objBuilder.build()); //add to the array of json
//
//
//
//            }
//            /*---------------------------objectBuilder for generate Response----------------------------*/
//            JsonObjectBuilder response = Json.createObjectBuilder();
//            response.add("status",200);
//            response.add("message","Done");
//            response.add("data",arrayBuilder.build());
//
//            /*System.out.println(arrayBuilder.build());*/
//            writer.print(response.build());
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    
}
