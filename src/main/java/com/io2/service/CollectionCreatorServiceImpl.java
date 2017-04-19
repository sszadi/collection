package com.io2.service;

import com.io2.model.Brand;
import com.io2.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Niki on 2017-04-19.
 */
@Service
public class CollectionCreatorServiceImpl implements CollectionCreatorService {

    private Map<Float, String> sizes = new TreeMap<>();
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    private Map<Float, String> createSizes() {
        for (float i = 5; i < 15; i += 0.5) {
            sizes.put(i, i + " US");
        }
        return sizes;
    }

    public Map<Float, String> getSizes() {
        if (sizes.isEmpty()) {
            sizes = createSizes();
        }
        return sizes;
    }

}
