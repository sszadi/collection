package com.io2.service;

import com.io2.model.Sneaker;

import java.util.List;

/**
 * Created by Niki on 2017-05-11.
 */
public interface CollectionService {

    List<Sneaker> getAll();

    Double getCollectionWorth(List<Sneaker> collection);
}

