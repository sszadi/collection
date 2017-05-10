package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.service.CollectionCreatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Niki on 2017-04-19.
 */
@Controller
public class CreatorController {

    @Autowired
    private CollectionCreatorServiceImpl collectionCreatorService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showSneakerCreator(Model model, @ModelAttribute("sneakers") Sneaker sneakers) {
        model.addAttribute("brands", collectionCreatorService.getAllBrands());
        model.addAttribute("sizes", collectionCreatorService.getSizes());
        if (sneakers != null) {
            model.addAttribute("sneaker", sneakers);
        } else {
            model.addAttribute("sneaker", new Sneaker());
        }
        return "add";
    }

    @PostMapping("/add")
    public String addSneaker(Sneaker sneaker, @RequestParam("file") MultipartFile file, Model model, @RequestParam("id") Long id) throws IOException {
        if (collectionCreatorService.addSneaker(sneaker, file, id)) {
            model.addAttribute("addSucc", true);
        } else {
            model.addAttribute("addError", true);
        }
        return "redirect:/collection";
    }
}
