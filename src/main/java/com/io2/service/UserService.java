package com.io2.service;

import com.io2.exception.EmailExistsException;
import com.io2.model.User;
import com.io2.model.UserDTO;

/**
 * Created by Niki on 2017-04-07.
 */
public interface UserService {
    User registerNewUser(UserDTO userDTO) throws EmailExistsException;

    User getCurrentUser();
}
