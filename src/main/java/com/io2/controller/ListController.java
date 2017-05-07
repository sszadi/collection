package com.io2.controller;

import com.io2.model.Brand;
import com.io2.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * Created by Niki on 2017-05-06.
 */
@Controller
public class ListController {

    @Autowired
    ListService listService;

    @RequestMapping("/list")
    public String showList(Model model) {
        Collection<Brand> buyList = listService.getBuyList();
        model.addAttribute("buyList", buyList);
        return "list";
    }

    @PostMapping("/list/add")
    public String addToList(@RequestParam String name, Model model) {
        if (listService.add(name)) {
            model.addAttribute("listSucc", true);
        } else {
            model.addAttribute("listError", true);
        }
        return "redirect:/list";
    }
}
