package com.dharmaraj.e_commerce.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "orders")
public class Order extends BaseModel {
    
    @ManyToOne
    private User user;
    
    @OneToMany
    private List<OrderDetail> orderDetails;
    
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;
}
