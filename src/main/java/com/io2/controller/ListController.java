package com.io2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Niki on 2017-05-06.
 */
@Controller
public class ListController {

    @RequestMapping("/list")
    public String showList() {
        return "list";
    }
}
