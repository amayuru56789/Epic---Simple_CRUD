/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.dto;

/**
 *
 * @author indee
 */
public class RegistrationDTO {
    private String userID;
    private String userName;
    private String address;
    private String email;
    private String contact;
    private String password;
    //private String confirmationPassword;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String userID, String userName, String address, String email, String contact, String password) {
        this.userID = userID;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.password = password;
        //this.confirmationPassword = confirmationPassword;
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
    
//    public String getConfirmationPassword() {
//        return confirmationPassword;
//    }
//
//    public void setConfirmationPassword(String confirmationPassword) {
//        this.confirmationPassword = confirmationPassword;
//    }

    @Override
    public String toString() {
        return "RegistrationDTO{" + "userID=" + userID + ", userName=" + userName + ", address=" + address + ", email=" + email + ", contact=" + contact + ", password=" + password + '}';
    }
    
    
}
