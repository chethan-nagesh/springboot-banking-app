package com.bank.customer.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bank.customer.model.Customer;
import com.bank.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
