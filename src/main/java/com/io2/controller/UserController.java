package com.io2.controller;

import com.io2.exception.EmailExistsException;
import com.io2.model.User;
import com.io2.model.UserDTO;
import com.io2.service.ThumbnailsService;
import com.io2.service.UserServiceImpl;
import com.io2.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Niki on 2017-04-06.
 */
@Controller
public class UserController {

    private final UserServiceImpl userService;
    private final UserFormValidator userFormValidator;
    private final ThumbnailsService thumbnailsService;
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    public UserController(UserServiceImpl userService, UserFormValidator userFormValidator, ThumbnailsService thumbnailsService) {
        this.userService = userService;
        this.userFormValidator = userFormValidator;
        this.thumbnailsService = thumbnailsService;

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        UserDTO userDTO = new UserDTO();
        //  thumbnailsService.getThumbnails(model);
        model.addAttribute("user", userDTO);
        return "sign-up";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result, Model model) {
        User registeredUser;
        userFormValidator.validate(userDTO, result);
        //    thumbnailsService.getThumbnails(model);
        registeredUser = createUserAccount(userDTO);
        LOGGER.log(Level.INFO, "Register new user.");

        if (result.hasErrors() || registeredUser == null) {
            model.addAttribute("regError", "messages.regError");
            return "sign-up";
        }

        if (!userService.isPasswordTheSame(userDTO.getPassword(), userDTO.getConfirmPassword())) {
            model.addAttribute("passwordError", "messages.passwordError");
            return "sign-up";
        }

        model.addAttribute("regSucc", "messages.regSucc");
        return "index";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/welcome?logout";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginError(Model model) {
        // thumbnailsService.getThumbnails(model);
        model.addAttribute("logPlease", "message.logPlease");
        return "index";
    }

    @RequestMapping(value = "/badcredentials", method = RequestMethod.GET)
    public String badCredentials() {
        return "index";
    }


    private User createUserAccount(UserDTO userDTO) {
        User registeredUser = null;
        try {
            registeredUser = userService.registerNewUser(userDTO);
        } catch (EmailExistsException ex) {
            return null;
        }
        return registeredUser;
    }

    @RequestMapping(value = "/profile")
    public String showUserProfile(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "user-profile";
    }

}
