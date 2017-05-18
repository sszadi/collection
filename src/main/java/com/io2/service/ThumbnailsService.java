package com.io2.service;

import com.io2.model.Sneaker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

/**
 * Created by Niki on 2017-05-12.
 */
public interface ThumbnailsService {

    String ROLE_USER = "ROLE_USER";

    Page<Sneaker> getThumbnails(Integer page);

    void getUserCollectionThumb(Integer page, Model model);

}
