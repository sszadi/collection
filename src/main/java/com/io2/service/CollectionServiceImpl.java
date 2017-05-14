package com.io2.service;

import com.io2.model.Sneaker;
import com.io2.model.User;
import com.io2.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Niki on 2017-05-11.
 */

@Service
public class CollectionServiceImpl implements CollectionService {

    private final SneakerRepository sneakerRepository;
    private final UserService userService;

    @Autowired
    public CollectionServiceImpl(SneakerRepository sneakerRepository, UserService userService) {
        this.sneakerRepository = sneakerRepository;
        this.userService = userService;
    }


    @Override
    public List<Sneaker> getAllUserCollection() {
        User user = userService.getCurrentUser();
        return sneakerRepository.findByOwner_Id(user.getId());
    }

    @Override
    public Double getCollectionWorth(List<Sneaker> collection) {
        return collection.stream().mapToDouble(Sneaker::getPrice).sum();
    }

    @Override
    public Page<Sneaker> getAnotherCollections(Pageable pageable) {
        User user = userService.getCurrentUser();
        return sneakerRepository.findByOwner_IdNot(user.getId(), pageable);
    }

    @Override
    public Page<Sneaker> getAllSneakers(Pageable pageable) {
        return sneakerRepository.findAll(pageable);
    }

}
