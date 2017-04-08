package com.io2.model;

import com.io2.annotation.PasswordMatches;
import com.io2.annotation.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Niki on 2017-04-04.
 */

@PasswordMatches
public class UserDTO {

    private String email;
    private String username;
    private String password;
    private String matchingPassword;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
