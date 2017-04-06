package com.io2.model;

import org.hibernate.annotations.Entity;

import javax.persistence.Table;

/**
 * Created by Niki on 2017-04-06.
 */

@Entity
@Table(name = "models")
public class Model {

    private Long id;
    private String name;
}
