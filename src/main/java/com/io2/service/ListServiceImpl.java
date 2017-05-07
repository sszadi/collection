package com.io2.service;

import com.io2.model.Brand;
import com.io2.model.User;
import com.io2.repository.BrandRepository;
import com.io2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Niki on 2017-05-07.
 */
@Service
public class ListServiceImpl implements ListService {

    @Autowired
    BrandRepository brandRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean add(String name) {
        Brand brand = null;
        if (name != null) {
            brand = brandRepository.findByName(name);
        }
        if (brand == null) {
            return false;
        }
        User user = userService.getCurrentUser();
        user.getBuyList().add(brand);
        userRepository.save(user);
        return true;
    }

    @Override
    public Collection<Brand> getBuyList() {
        User user = userService.getCurrentUser();
        return user.getBuyList();
    }


}
