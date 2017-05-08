package com.io2.controller;

import com.io2.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Niki on 2017-03-22.
 */

@org.springframework.stereotype.Controller
public class HelloController {

    @Autowired
    private MyUserDetailsService userDetailsService;
    private static final Logger LOGGER = Logger.getLogger(HelloController.class.getName());

    @RequestMapping("/")
    public String main() {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        LOGGER.log(Level.INFO, "Authorities: " + authorities);
        return "index";
    }

    @RequestMapping("/welcome")
    public String hello() {
        return "index";
    }


}
