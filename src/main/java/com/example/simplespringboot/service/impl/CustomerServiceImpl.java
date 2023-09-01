package com.example.simplespringboot.service.impl;

import com.example.simplespringboot.exception.CustomerByIdNotFoundException;
import com.example.simplespringboot.exception.CustomerIsAlreadyException;
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
    static final String ALREADY_EXISTING_EXCEPTION = "Customer with name = %s and Surname = %s is already existing";

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

    @Override
    public void checkExistingCustomer(Customer customer) {
        customers
                .stream()
                .filter(newCustomer -> newCustomer.getName().equals(customer.getName()))
                .filter(newCustomer -> newCustomer.getSurname().equals(customer.getSurname()))
                .findFirst()
                .ifPresent(customer1 -> {
                    throw new CustomerIsAlreadyException(ALREADY_EXISTING_EXCEPTION.formatted(customer.getName(), customer.getSurname()));
                });
    }

    @Override
    public Customer createCustomer(Customer customer) {
        checkExistingCustomer(customer);

        customer.setId(UUID.randomUUID().toString());
        customers.add(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(String id) {
        customers = customers
                .stream()
                .filter(customer -> !customer.getId().equals(id))
                .toList();
    }
}
