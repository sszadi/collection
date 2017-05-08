package com.io2.service;

import com.io2.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Niki on 2017-05-08.
 */
public class SneakersServiceImpl implements SneakersService {
    @Autowired
    SneakerRepository sneakerRepository;


}
