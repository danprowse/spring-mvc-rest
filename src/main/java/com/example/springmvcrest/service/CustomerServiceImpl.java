package com.example.springmvcrest.service;

import com.example.springmvcrest.domain.Customer;
import com.example.springmvcrest.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomerById(Long id) {
        Customer c1 = findCustomerById(id);
        customerRepository.deleteById(id);
        return c1;
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Customer customer, Long id) {
        Optional<Customer> studentOptional = customerRepository.findById(id);

        //checking if customer exist
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        //does not exist, new id to new customer info.
        customer.setID(id);

        //save changes
        customerRepository.save(customer);

        return ResponseEntity.noContent().build();
    }
}
