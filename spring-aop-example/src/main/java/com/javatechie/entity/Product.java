package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private String productType;


    public Product(String name, double price, String description, String productType) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productType = productType;
    }

}
