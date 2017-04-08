package com.io2.service;

import com.io2.exception.EmailExistsException;
import com.io2.model.Role;
import com.io2.model.User;
import com.io2.model.UserDTO;
import com.io2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Niki on 2017-04-07.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

    public User registerNewUser(UserDTO userDTO) throws EmailExistsException {

        if (isEmailExist(userDTO.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + userDTO.getEmail());
        }

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRoles(Arrays.asList(new Role("USER_ROLE")));
        return userRepository.save(user);
    }

    private boolean isEmailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
      //  authenticationProvider.set
        return authenticationProvider;
    }
}
