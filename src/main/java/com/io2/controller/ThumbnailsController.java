package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.service.FileService;
import com.io2.service.ThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by Niki on 2017-05-12.
 */
@Controller
public class ThumbnailsController {

    private final ThumbnailsService thumbnailsService;
    private final FileService fileService;
    private final static Logger logger = Logger.getLogger(ThumbnailsController.class.getName());

    @Autowired
    public ThumbnailsController
            (ThumbnailsService thumbnailsService, FileService fileService) {
        this.thumbnailsService = thumbnailsService;
        this.fileService = fileService;
    }

    @RequestMapping("/thumbnails")
    public String getThumbnails
            (Model model, @RequestParam(value = "page") Integer page) {

        if (page < 1) {
            page = 0;
        }

        Page<Sneaker> collectionPage = thumbnailsService.getThumbnails(page);
        model.addAttribute("collectionList", collectionPage);
        return "index";
    }

    @RequestMapping(value = "/images/{filename}", method = RequestMethod.GET)
    public void getFile
            (@PathVariable("filename") String filename, HttpServletResponse response) {
        fileService.getFile(filename, response);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/collection/show", method = RequestMethod.GET)
    public String collectionPage(Model model, @RequestParam(value = "page") Integer page) {

        if (page < 1) {
            page = 0;
        }

        thumbnailsService.getUserCollectionThumb(page, model);


        return "collection";
    }

}
