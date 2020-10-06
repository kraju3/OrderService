package com.example.service.orders.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="SHIPPING")
public class Shipping {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long shippingID;

    @Column
    public String shippingAddress;

    @Column
    public String shippingDate;

    @Column
    @Enumerated(EnumType.ORDINAL)
    public Status shippingStatus;

    public Shipping(String shippingAddress, String shippingDate, Status shippingStatus) {
        this.shippingAddress = shippingAddress;
        this.shippingDate = shippingDate;
        this.shippingStatus = shippingStatus;
    }

    public Shipping(){

    }

    public long getShippingID() {
        return shippingID;
    }

    public void setShippingID(long shippingID) {
        this.shippingID = shippingID;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Status getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(Status shippingStatus) {
        this.shippingStatus = shippingStatus;
    }
}

