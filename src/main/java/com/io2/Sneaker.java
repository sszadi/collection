package com.io2;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Niki on 2017-03-18.
 */
@Entity
public class Sneaker {
    @Id
    @GeneratedValue
    private Long id;
    private String model;
    private int size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Sneaker{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", size=" + size +
                '}';
    }
}
