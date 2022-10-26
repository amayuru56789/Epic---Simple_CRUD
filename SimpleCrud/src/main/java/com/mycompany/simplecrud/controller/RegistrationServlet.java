/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        System.out.println("Amayuru");
        PrintWriter writer = resp.getWriter();
        
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
