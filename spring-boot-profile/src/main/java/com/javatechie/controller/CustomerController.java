package com.javatechie.controller;

import com.javatechie.dto.CustomerDto;
import com.javatechie.entity.Customer;
import com.javatechie.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public List<Customer> saveCustomers(@RequestBody List<Customer> customers) {
        return service.addNewCustomers(customers);
    }

    @GetMapping
    public List<CustomerDto> fetchAllCustomers() {
        return service.getCustomers();
    }
}
