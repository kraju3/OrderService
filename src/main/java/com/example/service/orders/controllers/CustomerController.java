package com.example.service.orders.controllers;

import com.example.service.orders.domain.Customer;
import com.example.service.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {


    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerID}")
    public Customer getCustomer(@PathVariable(value = "customerID") long customerID){
        return customerService.getCustomer(customerID);
    }
}
