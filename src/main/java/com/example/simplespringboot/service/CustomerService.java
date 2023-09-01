package com.example.simplespringboot.service;

import com.example.simplespringboot.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomerById(String id);

    void checkExistingCustomer(Customer customer);

    Customer createCustomer(Customer customer);

    void deleteCustomer(String id);
}
