/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecrud.bo;

import com.mycompany.simplecrud.dao.RegistrationDao;
import com.mycompany.simplecrud.dto.RegistrationDTO;
import com.mycompany.simplecrud.model.Registration;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author indee
 */
public class RegistrationBo {

    //    create reference in DAO layer
    private RegistrationDao registrationDao;

    public ArrayList<RegistrationDTO> getAllUser() throws SQLException, ClassNotFoundException {
        ArrayList<Registration> all = registrationDao.getAllUser();
        ArrayList<RegistrationDTO> registrationList = new ArrayList<>();
        for (Registration registration : all) {
            registrationList.add(
                    new RegistrationDTO(
                            registration.getUserID(),
                            registration.getUserName(),
                            registration.getAddress(),
                            registration.getEmail(),
                            registration.getContact(),
                            registration.getPassword()
                    )
            );
        }
        return registrationList;

    }
}
