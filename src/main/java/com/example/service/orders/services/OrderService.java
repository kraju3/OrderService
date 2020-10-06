package com.example.service.orders.services;

import com.example.service.orders.domain.Order;
import com.example.service.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderService {


    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }



    public Iterable<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Order getOrder(long orderId){
        return orderRepository.findById(orderId).orElseThrow();
    }

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }


    public Order updateOrder(long orderID, Order order) throws NoSuchElementException {
        Order order_ = orderRepository.findById(orderID).orElseThrow();

        order_.setCustomer(order.getCustomer());
        order_.setShipping(order.getShipping());
        order_.setOrderDate(order.getOrderDate());

        return orderRepository.save(order_);

    }

    public void deleteOrder(long orderID) {

        orderRepository.deleteById(orderID);
    }
}
