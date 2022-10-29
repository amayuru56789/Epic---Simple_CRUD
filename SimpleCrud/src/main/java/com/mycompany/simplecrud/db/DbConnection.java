/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.db;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indee
 */
@WebListener
public class DbConnection implements ServletContextListener{
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        /*Create Database Connection Pool*/
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306//epic");
        bds.setUsername("root");
        bds.setPassword("1234");
        bds.setMaxTotal(5); //size of connections in our Application
        bds.setInitialSize(5); //Initial connections

        //Common place for any servlet
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("bds",bds);// store pool in servletContext

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();
        BasicDataSource bds = (BasicDataSource) servletContext.getAttribute("bds");
        try {
            bds.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
//    public Connection connection;
//
//    public DbConnection() {
//    }
//    
//    public Connection getConnection() throws ClassNotFoundException{
//        
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
//           
//        } catch (SQLException ex) {
//            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return connection;
//    }
//    
//    public void connectionClose() throws SQLException{
//        connection.close();
//    }
}
