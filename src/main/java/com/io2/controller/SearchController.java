package com.io2.controller;

import com.io2.model.Brand;
import com.io2.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Niki on 2017-05-07.
 */

@Controller
public class SearchController {

    @Autowired
    BrandRepository brandRepository;
    private List<Brand> brandList;
    private Logger logger = Logger.getLogger(SearchController.class.getName());

    @RequestMapping(value = "/getBrands", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Brand> getBrands(@RequestParam String term) {
        brandList = brandRepository.findAll();
        return simulateSearchResult(term);

    }

    private List<Brand> simulateSearchResult(String brandName) {
        List<Brand> result = new LinkedList<>();

        for (Brand brand : brandList) {
            if (brand.getName().toLowerCase().contains(brandName.toLowerCase())) {
                result.add(brand);
            }
        }

        return result;
    }
}
