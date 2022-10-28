/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.controller;

import com.mycompany.simplecrud.dao.RegistrationDao;
import com.mycompany.simplecrud.model.Registration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
//    create reference in DAO layer
    private RegistrationDao registrationDao;
    
    public void init(){
        registrationDao = new RegistrationDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        try {
            //System.out.println("Amayuru");
            PrintWriter writer = resp.getWriter();
            ArrayList<Registration> details = registrationDao.getAllUser();
            //String data = new Gson(details);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            //writer.write(data);
            //System.out.println(details);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
