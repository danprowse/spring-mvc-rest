package com.example.springmvcrest.service;

import com.example.springmvcrest.domain.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    Customer findCustomerById(long id);
    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer deleteCustomerById(Long id);

    ResponseEntity<Customer> updateCustomer(Customer customer, Long id);
}
