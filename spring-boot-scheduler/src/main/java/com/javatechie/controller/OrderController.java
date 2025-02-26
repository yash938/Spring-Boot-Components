package com.javatechie.controller;

import com.javatechie.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javatechie.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
}
