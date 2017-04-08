package com.io2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 2017-04-07.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Transient
    @ManyToMany(mappedBy = "roles", targetEntity = User.class)
    private List<User> users = new ArrayList<>();
    private String name;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
