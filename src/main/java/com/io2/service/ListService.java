package com.io2.service;

import com.io2.model.Brand;

import java.util.Collection;

/**
 * Created by Niki on 2017-05-07.
 */
public interface ListService {
    Boolean add(String name);

    Collection<Brand> getBuyList();
}
