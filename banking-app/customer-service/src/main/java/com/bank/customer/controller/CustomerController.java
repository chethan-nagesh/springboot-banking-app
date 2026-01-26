package com.bank.customer.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAllCustomers();
    }
}
