package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.service.CollectionService;
import com.io2.service.ThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Niki on 2017-04-25.
 */
@Controller
public class CollectionController {

    private final ThumbnailsService thumbnailsService;
    private static final Logger LOGGER = Logger.getLogger(CollectionController.class.getName());

    @Autowired
    public CollectionController(ThumbnailsService thumbnailsService) {
        this.thumbnailsService = thumbnailsService;
    }

    @Secured("ROLE_USER")
    @ModelAttribute
    public void getCollection(Model model) {
        thumbnailsService.getUserCollectionThumb(0, model);
    }


    @Secured("ROLE_USER")
    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public String collection() {
        LOGGER.log(Level.INFO, "Show user collection.");
        return "collection";
    }



}
