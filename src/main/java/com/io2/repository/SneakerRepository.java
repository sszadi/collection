package com.io2.repository;

import com.io2.model.Sneaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Niki on 2017-03-18.
 */
@Repository
public interface SneakerRepository extends CrudRepository<Sneaker, Long> {
    Sneaker findById(Long id);

    List<Sneaker> findByBrand(String brand);

    Sneaker save(Sneaker sneaker);

    List<Sneaker> findByOwner_Id(Long id);

}
