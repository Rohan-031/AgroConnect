package com.agro.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "selling_description")
    private String sellingDescription;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "seller_id")
    @JsonIgnore
    private Seller seller;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellingDescription() {
        return sellingDescription;
    }

    public void setSellingDescription(String sellingDescription) {
        this.sellingDescription = sellingDescription;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product(String name, double price, int quantity, String category, String sellingDescription, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.sellingDescription = sellingDescription;
        this.description = description;
    }

    public Product() {  }

}
