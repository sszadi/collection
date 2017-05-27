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

    private final BrandRepository brandRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private User user;

    @Autowired
    public ListServiceImpl
            (BrandRepository brandRepository, UserService userService, UserRepository userRepository) {
        this.brandRepository = brandRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public Boolean add(String name) {
        Brand brand = null;

        if (name != null) {
            brand = brandRepository.findByName(name);
        }

        if (brand == null) {
            return false;
        }

        user = userService.getCurrentUser();
        user.getBuyList().add(brand);
        userRepository.save(user);
        return true;
    }

    @Override
    public Collection<Brand> getBuyList() {
        user = userService.getCurrentUser();
        return user.getBuyList();
    }

    @Override
    public boolean delete(Long id) {
        user = userService.getCurrentUser();
        Brand brand = brandRepository.findById(id);

        if (brand == null || user == null) {
            return false;
        }

        user.getBuyList().remove(brand);
        userRepository.save(user);
        return true;
    }

}
