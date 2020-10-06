package com.example.service.orders.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ORDERSDB")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long orderID;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Customer customer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Shipping shipping;

    @Column
    public String orderDate;

    public Order(com.example.service.orders.domain.Customer customer, com.example.service.orders.domain.Shipping shipping, String orderDate) {
        this.customer = customer;
        this.shipping = shipping;
        this.orderDate = orderDate;
    }

    public Order(){}

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public com.example.service.orders.domain.Customer getCustomer() {
        return customer;
    }

    public void setCustomer(com.example.service.orders.domain.Customer customer) {
        this.customer = customer;
    }

    public com.example.service.orders.domain.Shipping getShipping() {
        return shipping;
    }

    public void setShipping(com.example.service.orders.domain.Shipping shipping) {
        this.shipping = shipping;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
