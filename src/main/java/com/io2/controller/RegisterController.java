package com.io2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Niki on 2017-04-06.
 */
@Controller
public class RegisterController {

    @RequestMapping("/register")
    public String register() {
        return "sign-up";
    }
}
