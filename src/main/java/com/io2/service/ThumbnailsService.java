package com.io2.service;

import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

/**
 * Created by Niki on 2017-05-12.
 */
public interface ThumbnailsService {

    String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

    void getThumbnails(Model model, Pageable pageable);
}
