/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.controller;

import com.mycompany.simplecrud.bo.RegistrationBo;
import com.mycompany.simplecrud.dto.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author indee
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/Registration"})
public class RegistrationServlet extends HttpServlet {
//    create object in BO layer
    private RegistrationBo registrationBo= new RegistrationBo();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        
        resp.setContentType("application/json");
        //resp.setCharacterEncoding("UTF-8");
//        ServletContext servletContext = req.getServletContext();
//        BasicDataSource basicDataSource = (BasicDataSource) servletContext.getAttribute("bds");
        
        try {
            //System.out.println("Amayuru");
            PrintWriter writer = resp.getWriter();
//            Connection connection = basicDataSource.getConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
                    
            ArrayList<RegistrationDTO> details = registrationBo.getAllUser();
            for (RegistrationDTO registrationDTO : details){
                JsonObjectBuilder obj = Json.createObjectBuilder();
                obj.add("userID", registrationDTO.getUserID());
                obj.add("userName", registrationDTO.getUserName());
                obj.add("address", registrationDTO.getAddress());
                obj.add("email", registrationDTO.getEmail());
                obj.add("contact", registrationDTO.getContact());
                obj.add("password", registrationDTO.getPassword());
                
                arrayBuilder.add(obj.build());
            }
            
            writer.print(arrayBuilder.build());
            con.close();
            //System.out.println(details);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//        PrintWriter writer = resp.getWriter();
//        writer.write("Hi");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, UnsupportedEncodingException{
        resp.setContentType("application/json");
//        ServletContext servletContext = req.getServletContext();
//        BasicDataSource bds = (BasicDataSource) servletContext.getAttribute("bds");
        
        //System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject obj = reader.readObject();
        String userID = obj.getString("userID");
        String userName = obj.getString("userName");
        String address = obj.getString("address");
        String email = obj.getString("email");
        String contact = obj.getString("contact");
        String password = obj.getString("password");
//        String encryptedpassword = null;  
//        
//        try {
//            /* MessageDigest instance for MD5. */  
//            MessageDigest m = MessageDigest.getInstance("MD5");
//            
//            /* Add plain-text password bytes to digest using MD5 update() method. */  
//            m.update(password.getBytes());  
//            
//            /* Convert the hash value into bytes */   
//            byte[] bytes = m.digest(); 
//            
//            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
//            StringBuilder s = new StringBuilder();  
//            for(int i=0; i< bytes.length ;i++) {  
//                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
//            }  
//            /* Complete hashed password in hexadecimal format */  
//            encryptedpassword = s.toString();  
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        /* Display the unencrypted and encrypted passwords. */  
//        System.out.println("Plain-text password: " + password);  
//        System.out.println("Encrypted password using MD5: " + encryptedpassword);  
        
        RegistrationDTO registrationDTO = new RegistrationDTO(userID,userName,address,email,contact,password);
        try {
//            Connection connection = bds.getConnection();
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
            if (registrationBo.registrationUser(registrationDTO)){
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 200);
                response.add("message", "Successfully Added");
                response.add("data", "");
                writer.print(response.build());
            }else{
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 500);
                response.add("message", "Can't add the user");
                response.add("data", "");
                writer.print(response.build());
            }
            //con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, UnsupportedEncodingException{
        resp.setContentType("application/json");
        
        //System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();
        
        /*get user information from json Request Using JsonReader */
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject jsonObject = reader.readObject();
        String userID = jsonObject.getString("userID");
        String userName = jsonObject.getString("userName");
        String address = jsonObject.getString("address");
        String email = jsonObject.getString("email");
        String contact = jsonObject.getString("contact");
        String password = jsonObject.getString("password");
        /*System.out.println(userID+" "+userName+" "+address+" "+email);*/
        
        RegistrationDTO registrationDTO = new RegistrationDTO(userID, userName, address, email, contact, password);
        try {
            if (registrationBo.updateUser(registrationDTO)){
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 200);
                response.add("message", "Successfuly Updated");
                response.add("data", "");
                writer.print(response.build());
            }else{
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 500);
                response.add("message", "Can't update user");
                response.add("data", "");
                writer.print(response.build());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("application/json");
        
        //get userID Using getParameter Method
        String userID = req.getParameter("userID");
        System.out.println(userID);
        
        //System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();
        try {
            if (registrationBo.deleteUser(userID)){
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 200);
                response.add("message", "Successfuly deleted...");
                response.add("data", "");
                writer.print(response.build());
            }else{
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", 500);
                response.add("message", "Wrong ID inserted...");
                response.add("data", "");
                writer.print(response.build());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
