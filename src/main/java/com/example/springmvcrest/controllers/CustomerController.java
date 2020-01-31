package com.example.springmvcrest.controllers;

import com.example.springmvcrest.domain.Customer;
import com.example.springmvcrest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    private final CustomerService customerService;

    public static final String BASE_URL = "/api/v1/customers";

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer deleteCustomerById(@PathVariable Long id) {
        return customerService.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer customer, @PathVariable Long id){
        return customerService.updateCustomer(customer, id);
    }




}
