package com.io2.service;

import com.io2.exception.EmailExistsException;
import com.io2.model.User;
import com.io2.model.UserDTO;
import com.io2.repository.RoleRepository;
import com.io2.repository.UserRepository;
import com.io2.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by Niki on 2017-04-07.
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public User registerNewUser(UserDTO userDTO) throws EmailExistsException {

        if (isEmailExist(userDTO.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + userDTO.getEmail());
        }


        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setEnabled(true);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRoles(Collections.singletonList(roleRepository.findByName("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();

        return userRepository.findByEmail(userDetail.getUsername());
    }

    private boolean isEmailExist(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }


    public boolean isPasswordTheSame(String password, String repeatedPassword) {
        return password.equals(repeatedPassword);
    }


}
