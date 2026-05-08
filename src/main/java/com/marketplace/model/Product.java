package com.marketplace.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String seller;
    private String category;
    private String description;
    private String imageUrl;
    private int stock;

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getSeller() { return seller; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public int getStock() { return stock; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setSeller(String seller) { this.seller = seller; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setStock(int stock) { this.stock = stock; }
}
