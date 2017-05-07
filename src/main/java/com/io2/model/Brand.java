package com.io2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Niki on 2017-04-06.
 */

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "buyList")
    @JsonBackReference
    private Collection<User> usersList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(Collection<User> usersList) {
        this.usersList = usersList;
    }
}
