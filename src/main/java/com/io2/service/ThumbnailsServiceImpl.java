package com.io2.service;

import com.io2.model.Sneaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collection;

/**
 * Created by Niki on 2017-05-12.
 */
@Service
public class ThumbnailsServiceImpl implements ThumbnailsService {
    private final CollectionService collectionService;

    @Autowired
    public ThumbnailsServiceImpl(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @Override

    public void getThumbnails(Model model, Pageable pageable) {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Page<Sneaker> collectionPages = null;
        if (authorities.contains(new SimpleGrantedAuthority(ROLE_ANONYMOUS))) {
            collectionPages = collectionService.getAllSneakers(pageable);
        } else {
            collectionPages = collectionService.getAnotherCollections(pageable);
        }
        model.addAttribute("pages", collectionPages);
        model.addAttribute("collectionList", collectionPages.getContent());
    }
}
