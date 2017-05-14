package com.io2.controller;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Niki on 2017-03-22.
 */
@org.springframework.stereotype.Controller
public class HelloController {

    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("/welcome")
    public String hello() {
        return "index";
    }

}
