package com.example.service.orders;

import com.example.service.orders.domain.Customer;
import com.example.service.orders.domain.Order;
import com.example.service.orders.domain.Shipping;
import com.example.service.orders.domain.Status;
import com.example.service.orders.repository.CustomerRepository;
import com.example.service.orders.repository.OrderRepository;
import com.example.service.orders.repository.ShippingRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(OrderRepository repository, CustomerRepository customerRepository, ShippingRepository shippingRepository){
		Customer customer1 = new Customer("Test Customer","Maple Ln");
		Shipping shipping = new Shipping(customer1.getCustomerAddress(), new Date().toString(), Status.WAITING);

		Order order1 = new Order(customer1,shipping,shipping.getShippingDate());

		return args -> {
			customerRepository.save(customer1);
			shippingRepository.save(shipping);
			repository.save(order1);
		};

	}
}
