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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
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
        }
        
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();
        
    }
}
