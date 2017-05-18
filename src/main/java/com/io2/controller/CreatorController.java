package com.io2.controller;

import com.io2.model.Sneaker;
import com.io2.repository.BrandRepository;
import com.io2.service.CreatorService;
import com.io2.validator.SneakersValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Niki on 2017-04-19.
 */
@Controller
public class CreatorController {

    private final CreatorService creatorService;
    private final SneakersValidation sneakersValidation;
    private final BrandRepository brandRepository;
    private static final Logger LOGGER = Logger.getLogger(CreatorController.class.getName());


    @Autowired
    public CreatorController
            (CreatorService creatorService, SneakersValidation sneakersValidation, BrandRepository brandRepository) {
        this.creatorService = creatorService;
        this.sneakersValidation = sneakersValidation;
        this.brandRepository = brandRepository;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showSneakerCreator(
            Model model, @ModelAttribute("sneakers") Sneaker sneakers) {

        LOGGER.log(Level.INFO, "Show form for add sneakers to collection.");
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
    public String addSneaker
            (Sneaker sneaker, BindingResult result, @RequestParam("brand") String brand,
             @RequestParam(value = "file", required = false) MultipartFile file,
             Model model, @RequestParam("id") Long id) throws IOException {

        sneaker.setBrand(brandRepository.findByName(brand));
        if (sneaker.getBrand() == null) {
            model.addAttribute("brandError", true);
            return "redirect:/add";
        }

        if (id == null) {
            LOGGER.log(Level.INFO, "Add sneakers to collection.");
            sneakersValidation.validate(sneaker, result);

            if (creatorService.addSneaker(sneaker, file)) {
                model.addAttribute("addSucc", true);
            } else {
                model.addAttribute("addError", true);
            }

        } else {
            LOGGER.log(Level.INFO, "Edit sneakers.");

            if (creatorService.editSneaker(sneaker, file, id)) {
                model.addAttribute("editSucc", true);
            } else {
                model.addAttribute("editError", true);
            }
        }

        return "redirect:/collection";
    }
}
