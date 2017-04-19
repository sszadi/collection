package com.io2.repository;

import com.io2.model.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Niki on 2017-04-19.
 */
public interface BrandRepository extends CrudRepository<Brand, Long> {
    List<Brand> findAll();
}
