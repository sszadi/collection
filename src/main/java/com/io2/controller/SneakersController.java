package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Niki on 2017-05-08.
 */
@Controller
public class SneakersController {

    @Autowired
    SneakerRepository sneakerRepository;

    @RequestMapping("/sneakers/id/{id}")
    public String showSneakersInfo(@PathVariable("id") Long id, Model model) {
        Sneaker sneaker = sneakerRepository.findById(id);
        model.addAttribute("sneakers", sneaker);
        return "sneakers";
    }

    @RequestMapping("/sneakers/delete/id/{id}")
    public String deleteSneakers(@PathVariable("id") Long id, Model model) {
        Sneaker sneaker = sneakerRepository.findById(id);
        model.addAttribute("sneakers", sneaker);
        return "sneakers";
    }

}
