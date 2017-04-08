package com.io2.controller;

import com.io2.exception.EmailExistsException;
import com.io2.model.User;
import com.io2.model.UserDTO;
import com.io2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Niki on 2017-04-06.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "sign-up";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result) {
        User registeredUser = new User();
        registeredUser = createUserAccount(userDTO, result);
        if (registeredUser == null) {
            result.rejectValue("email", "error");
        }
        return "redirect:/";
    }

    private User createUserAccount(UserDTO userDTO, BindingResult result) {
        User registeredUser;
        try {
            registeredUser = userService.registerNewUser(userDTO);
        } catch (EmailExistsException ex) {
            return null;
        }
        return registeredUser;
    }

}
