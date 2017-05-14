package com.io2.controller;

import com.io2.service.ThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Niki on 2017-05-12.
 */
@ControllerAdvice
public class ThumbnailsController {

    private final ThumbnailsService thumbnailsService;

    @Autowired
    public ThumbnailsController(ThumbnailsService thumbnailsService) {
        this.thumbnailsService = thumbnailsService;
    }

    @ModelAttribute
    public void getThumbnails(Model model, Pageable pageable) {
        //Pageable pageable = new PageRequest(page, 50);
        //@RequestParam(value = "page") int page
        thumbnailsService.getThumbnails(model, pageable);
    }

}
