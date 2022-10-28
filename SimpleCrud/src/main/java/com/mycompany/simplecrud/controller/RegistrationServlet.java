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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author indee
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/Registration"})
public class RegistrationServlet extends HttpServlet {
//    create reference in BO layer
    private RegistrationBo registrationBo;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        
        resp.setContentType("application/json");
        //resp.setCharacterEncoding("UTF-8");
        
        try {
            //System.out.println("Amayuru");
            PrintWriter writer = resp.getWriter();
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
            //System.out.println(details);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();
        
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
