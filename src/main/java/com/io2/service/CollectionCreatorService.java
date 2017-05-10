package com.io2.service;

import com.io2.model.Brand;
import com.io2.model.Sneaker;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Niki on 2017-04-19.
 */

interface CollectionCreatorService {
    List<Brand> getAllBrands();

    Map<Float, String> getSizes();

    Boolean addSneaker(Sneaker sneaker, MultipartFile file, Long id) throws IOException;

    String handleFileUpload(MultipartFile file) throws IOException;
}
