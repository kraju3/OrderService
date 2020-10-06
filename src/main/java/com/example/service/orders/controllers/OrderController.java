package com.example.service.orders.controllers;

import com.example.service.orders.domain.Customer;
import com.example.service.orders.domain.Order;
import com.example.service.orders.domain.Shipping;
import com.example.service.orders.services.CustomerService;
import com.example.service.orders.services.OrderService;
import com.example.service.orders.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {


    private OrderService orderService;
    private CustomerService customerService;
    private ShippingService shippingService;

    @Autowired
    public OrderController(CustomerService customerService,ShippingService shippingService, OrderService orderService) {

        this.customerService = customerService;
        this.shippingService = shippingService;
        this.orderService = orderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping(value="/{orderID}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable(value = "orderID") long orderID){
        return orderService.getOrder(orderID);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order customerOrder){
        Shipping shipping = shippingService.createShipping(customerOrder.getShipping());
        Customer customer = customerService.createCustomer(customerOrder.getCustomer());
        Order order = new Order(customer,shipping,customerOrder.getOrderDate());
        return orderService.createOrder(order);
    }

    @PutMapping(value = "/{orderID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Order updateOrder(@PathVariable(value = "orderID") long orderID,@RequestBody Order order){
        shippingService.updateShipping(order.getShipping());
        customerService.updateCustomer(order.getCustomer());
        return orderService.updateOrder(orderID,order);
    }

    @DeleteMapping(value="/{orderID}")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteOrder(@PathVariable(value = "orderID") long orderID){
        Order order_deleted = orderService.getOrder(orderID);
        customerService.DeleteCustomer(order_deleted.getCustomer());
        shippingService.deleteShipping(order_deleted.getShipping());
        orderService.deleteOrder(orderID);
    }

}
