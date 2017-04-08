package com.io2.repository;

import com.io2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Niki on 2017-04-07.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    User findByUsername(String username);

    User save(User user);
}
