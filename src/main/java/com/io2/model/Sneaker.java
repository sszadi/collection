package com.io2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Niki on 2017-03-18.
 */
@Entity
@Table(name = "sneakers")
public class Sneaker {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Brand.class)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @NotNull
    @Column(name = "size", nullable = false)
    private Double size;
    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "filename")
    private String filename;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User owner;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Sneaker{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }


}
