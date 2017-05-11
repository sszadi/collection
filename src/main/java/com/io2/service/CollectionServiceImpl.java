package com.io2.service;

import com.io2.model.Sneaker;
import com.io2.model.User;
import com.io2.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Niki on 2017-05-11.
 */

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private SneakerRepository sneakerRepository;
    @Autowired
    private UserService userService;


    @Override
    public List<Sneaker> getAll() {
        User user = userService.getCurrentUser();
        return sneakerRepository.findByOwner_Id(user.getId());
    }

    @Override
    public Double getCollectionWorth(List<Sneaker> collection) {
        return collection.stream().mapToDouble(Sneaker::getPrice).sum();
    }

}
