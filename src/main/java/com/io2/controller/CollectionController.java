package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.repository.SneakerRepository;
import com.io2.service.CollectionCreatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Niki on 2017-04-19.
 */
@Controller
public class CollectionController {

    @Autowired
    private SneakerRepository sneakerRepository;
    @Autowired
    private CollectionCreatorServiceImpl collectionCreatorService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showSneakerCreator(Model model) {
        model.addAttribute("brands", collectionCreatorService.getAllBrands());
        model.addAttribute("sizes", collectionCreatorService.getSizes());
        model.addAttribute("sneaker", new Sneaker());
        return "add";
    }

    @PostMapping("/add")
    public void addSneaker(Sneaker sneaker, Model model) {
        model.addAttribute("message", sneaker.getBrand() + " added to your collection.");
        sneakerRepository.save(sneaker);
    }
}
