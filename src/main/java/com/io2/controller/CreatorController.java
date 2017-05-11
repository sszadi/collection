package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.service.CreatorService;
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
    private CreatorService creatorService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showSneakerCreator(Model model, @ModelAttribute("sneakers") Sneaker sneakers) {
        model.addAttribute("brands", creatorService.getAllBrands());
        model.addAttribute("sizes", creatorService.getSizes());
        if (sneakers != null) {
            model.addAttribute("sneaker", sneakers);
        } else {
            model.addAttribute("sneaker", new Sneaker());
        }
        return "add";
    }

    @PostMapping("/add")
    public String addSneaker(Sneaker sneaker, @RequestParam("file") MultipartFile file, Model model, @RequestParam("id") Long id) throws IOException {
        if (id == null) {
            if (creatorService.addSneaker(sneaker, file)) {
                model.addAttribute("addSucc", true);
            } else {
                model.addAttribute("addError", true);
            }
        } else {
            if (creatorService.editSneaker(sneaker, file, id)) {
                model.addAttribute("editSucc", true);
            } else {
                model.addAttribute("editError", true);
            }
        }
        return "redirect:/collection";
    }
}
