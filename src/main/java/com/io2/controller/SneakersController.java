package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Niki on 2017-05-08.
 */
@Controller
public class SneakersController {

    @Autowired
    private SneakerRepository sneakerRepository;

    @RequestMapping("/sneakers/id/{id}")
    public String showSneakersInfo(@PathVariable("id") Long id, Model model) {
        Sneaker sneaker = sneakerRepository.findById(id);
        model.addAttribute("sneakers", sneaker);
        return "sneakers";
    }

    @RequestMapping("/sneakers/delete/id/{id}")
    public String deleteSneakers(@PathVariable("id") Long id, Model model) {
        Sneaker sneaker = sneakerRepository.findById(id);
        sneakerRepository.delete(sneaker);
        model.addAttribute("delSucc", "message.delSucc");
        return "redirect:/collection";
    }

    @RequestMapping("/sneakers/edit/id/{id}")
    public String editSneakers(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Sneaker sneaker = sneakerRepository.findById(id);
        redirectAttributes.addFlashAttribute("sneakers", sneaker);
        return "redirect:/add";
    }

    @PostMapping("/sneakers/edit/id/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        return "redirect:/add";
    }

}
