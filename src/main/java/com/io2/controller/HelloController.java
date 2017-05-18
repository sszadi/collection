package com.io2.controller;

import com.io2.service.ThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Created by Niki on 2017-03-22.
 */
@org.springframework.stereotype.Controller
@SessionAttributes("collectionList")
public class HelloController {

    private ThumbnailsService thumbnailsService;

    @Autowired
    public HelloController(ThumbnailsService thumbnailsService) {
        this.thumbnailsService = thumbnailsService;
    }

    @ModelAttribute
    public void getThumbnails(Model model) {
        model.addAttribute("collectionList", thumbnailsService.getThumbnails(0));
    }

    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("/welcome")
    public String hello() {
        return "index";
    }

}
