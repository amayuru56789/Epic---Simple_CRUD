package com.mycompany.simplecrud.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author indee
 */
public class Registration {
    private String userID;
    private String userName;
    private String address;
    private String email;
    private String contact;
    private String password;

    public Registration() {
    }

    public Registration(String userID, String userName, String address, String email, String contact, String password) {
        this.userID = userID;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Registration{" + "userID=" + userID + ", userName=" + userName + ", address=" + address + ", email=" + email + ", contact=" + contact + ", password=" + password + '}';
    }    
    
}
