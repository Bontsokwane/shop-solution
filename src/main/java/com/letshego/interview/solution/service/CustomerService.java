package com.letshego.interview.solution.service;

import com.letshego.interview.solution.model.Customer;

import java.util.Optional;

public interface CustomerService {

    public Customer createCustomer(Customer customer);

    public Optional<Customer> getCustomerById(String customerId);
}
