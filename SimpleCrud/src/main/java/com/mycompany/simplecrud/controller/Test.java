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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author indee
 */
@WebServlet(urlPatterns = "/Test")
public class Test extends HttpServlet {
    
    RegistrationBo registrationBo = new RegistrationBo();
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
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
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
