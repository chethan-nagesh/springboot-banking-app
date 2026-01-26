package com.bank.customer.service;

import java.util.List;
import com.bank.customer.model.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
