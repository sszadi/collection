package com.io2.service;

import com.io2.model.Sneaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collection;

import static com.io2.service.CollectionService.PAGE_SIZE;

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


    public Page<Sneaker> getThumbnails(Integer page) {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        Pageable pageable = new PageRequest(page, PAGE_SIZE);
        Page<Sneaker> collectionPages = null;
        if (authorities.contains(new SimpleGrantedAuthority(ROLE_USER))) {
            collectionPages = collectionService.getAnotherCollections(pageable);

        } else {
            collectionPages = collectionService.getAllSneakers(pageable);
        }
        return collectionPages;
    }

    public void getUserCollectionThumb(Integer page, Model model) {
        Pageable pageable = new PageRequest(page, PAGE_SIZE);
        Page<Sneaker> collectionList = collectionService.getUserCollectionPage(pageable);
        model.addAttribute("collectionList", collectionList);
        model.addAttribute("worth", collectionService.getCollectionWorth());
    }
}
