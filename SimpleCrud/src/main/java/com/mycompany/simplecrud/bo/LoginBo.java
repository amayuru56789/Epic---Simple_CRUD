/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.bo;

import com.mycompany.simplecrud.dao.LoginDao;
import java.security.InvalidKeyException;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 *
 * @author indee
 */
public class LoginBo {
    LoginDao loginDao = new LoginDao();
    
    public boolean equalityUser(String userName, String password) throws ClassNotFoundException, SQLException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        boolean equal = loginDao.checkEqualityUser(userName, password);
        if (equal){
            return true;
        }else{
            return false;
        }
    }
}
