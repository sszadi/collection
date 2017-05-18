package com.io2.service;

import com.io2.model.Sneaker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Niki on 2017-05-11.
 */
public interface CollectionService {

    int PAGE_SIZE = 6;

    Page<Sneaker> getUserCollectionPage(Pageable pageable);

    List<Sneaker> getUserCollection();

    Double getCollectionWorth();

    Page<Sneaker> getAnotherCollections(Pageable pageable);

    Page<Sneaker> getAllSneakers(Pageable pageable);
}

