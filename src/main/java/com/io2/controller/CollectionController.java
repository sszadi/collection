package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.model.User;
import com.io2.repository.SneakerRepository;
import com.io2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Niki on 2017-04-25.
 */
@Controller
public class CollectionController {

    @Autowired
    SneakerRepository sneakerRepository;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public String collection(Model model) {
        User user = userService.getCurrentUser();
        List<Sneaker> collection = sneakerRepository.findByOwner_Id(user.getId());
        model.addAttribute("collectionList", collection);

        return "collection";
    }

}
