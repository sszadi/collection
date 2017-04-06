package com.io2.controller;

import com.io2.repository.SneakerRepository;
import com.io2.model.Sneaker;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by Niki on 2017-03-22.
 */

@org.springframework.stereotype.Controller
public class HelloController {

    //@Autowired
    private SneakerRepository sneakerDAO;

    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("/index")
    public String hello(Model model) {
        return "index";
    }

    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public String collection() {
        return "collection";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String form() {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String formSupport(@ModelAttribute("form") @Valid Sneaker form, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        } else {
            //formularz wypełniony prawidłowo
            return "add";
        }
    }
}
