package com.example.simplespringboot.service.impl;

import com.example.simplespringboot.exception.CustomerByIdNotFoundException;
import com.example.simplespringboot.model.Customer;
import com.example.simplespringboot.service.CustomerService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customers;
    static final String NOT_FOUND_EXCEPTION = "Customer with id = %s not found!";

    static {
        if (customers == null) {
            Customer customer1 = new Customer();
            customer1.setId(UUID.randomUUID().toString());
            customer1.setName("Akif");
            customer1.setSurname("Veliyev");
            customer1.setAge(35);

            customers = new ArrayList<>();
            customers.add(customer1);
        }
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomerById(String id) {
        return customers
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new CustomerByIdNotFoundException(NOT_FOUND_EXCEPTION.formatted(id))
                );
    }
}
