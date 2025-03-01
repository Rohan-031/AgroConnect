package com.agro.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Product(String name, double price, int quantity, String category, String sellingDescription, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.sellingDescription = sellingDescription;
        this.description = description;
    }

    public Product(String name, double price, String category, int quantity, String description, String sellingDescription) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.description = description;
        this.sellingDescription = sellingDescription;
    }

    public Product() {  }

}
