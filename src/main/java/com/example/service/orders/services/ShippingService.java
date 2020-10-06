package com.example.service.orders.services;

import com.example.service.orders.domain.Customer;
import com.example.service.orders.domain.Shipping;
import com.example.service.orders.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private ShippingRepository shippingService;

    @Autowired
    public ShippingService(ShippingRepository shippingService){
        this.shippingService=shippingService;
    }

    public Shipping createShipping(Shipping shipping){
        return shippingService.save((shipping));
    }

    public void updateShipping(Shipping shipping) {
        Shipping shipping_ = shippingService.findById(shipping.getShippingID()).orElseThrow();
        shipping_.setShippingAddress(shipping.getShippingAddress());
        shipping_.setShippingDate(shipping.getShippingDate());
        shipping_.setShippingStatus(shipping.getShippingStatus());

        shippingService.save(shipping_);
    }

    public void deleteShipping(Shipping shipping){
        shippingService.delete(shipping);
    }

}
