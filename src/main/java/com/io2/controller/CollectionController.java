package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.service.CollectionService;
import com.io2.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Niki on 2017-04-25.
 */
@Controller
public class CollectionController {

    @Autowired
    private FileService fileService;
    @Autowired
    private CollectionService collectionService;


    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public String collection(Model model) {
        List<Sneaker> collection = collectionService.getAll();
        model.addAttribute("collectionList", collection);

        Double worth = collectionService.getCollectionWorth(collection);
        model.addAttribute("worth", worth);
        return "collection";
    }

    @RequestMapping(value = "/images/{filename}", method = RequestMethod.GET)
    public void getFile(@PathVariable("filename") String filename, HttpServletResponse response) {
        fileService.getFile(filename, response);
    }

}
