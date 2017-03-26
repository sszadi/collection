package com.io2;

import com.io2.model.Sneaker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Niki on 2017-03-22.
 */

@Repository
public class SneakerDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional                  // start of transaction
    public void find() {
        entityManager.find(Sneaker.class, 1L);
    }
}
