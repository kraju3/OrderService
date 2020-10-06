package com.example.service.orders.domain;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    public long customerID;

    @Column
    public String customerName;

    @Column
    public String customerAddress;

    public Customer(String customerName, String customerAddress) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public Customer(){}

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
