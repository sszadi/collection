package com.io2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.io2.annotation.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by Niki on 2017-04-04.
 */

@Entity
@Table(name = "users")
public class User {

    private long id;
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    private Collection<Role> roles;
    private Collection<Brand> buyList;

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @NotNull
    @ValidEmail
    public String getEmail() {
        return email;
    }

    @NotNull
    public String getUsername() {
        return username;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    @NotNull
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @JsonManagedReference
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(name = "users_buylists", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id", referencedColumnName = "id"))
    @JsonManagedReference
    public Collection<Brand> getBuyList() {
        return buyList;
    }

    public void setBuyList(Collection<Brand> buyList) {
        this.buyList = buyList;
    }
}
