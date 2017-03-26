package com.io2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Niki on 2017-03-18.
 */
@Entity
public class Sneaker {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(name = "model", nullable = false)
    private String model;
    @NotNull
    @Column(name = "size", nullable = false)
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
