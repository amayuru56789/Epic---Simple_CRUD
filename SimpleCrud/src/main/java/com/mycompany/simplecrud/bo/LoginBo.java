/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.bo;

import com.mycompany.simplecrud.dao.LoginDao;
import java.sql.SQLException;

/**
 *
 * @author indee
 */
public class LoginBo {
    LoginDao loginDao = new LoginDao();
    
    public boolean equalityUser(String userID, String password) throws ClassNotFoundException, SQLException{
        boolean equal = loginDao.checkEqualityUser(userID, password);
        if (equal){
            return true;
        }else{
            return false;
        }
    }
}
