package com.example.service.orders.services;

import com.example.service.orders.domain.Customer;
import com.example.service.orders.domain.Order;
import com.example.service.orders.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> getAllCustomers() {

        return customerRepository.findAll();

    }

    public Customer getCustomer(long customerID) {

        return customerRepository.findById(customerID).orElseThrow();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        Customer customer_ = customerRepository.findById(customer.getCustomerID()).orElseThrow();
        customer_.setCustomerAddress(customer.getCustomerAddress());
        customer_.setCustomerName(customer.getCustomerName());
    }

    public void DeleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }
}