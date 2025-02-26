package com.javatechie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int qty;
    private double price;

    public Order(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}
