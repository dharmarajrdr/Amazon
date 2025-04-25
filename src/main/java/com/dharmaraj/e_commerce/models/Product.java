package com.dharmaraj.e_commerce.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Product extends BaseModel{
    
    private String name;

    private String description;

    private double price;
}
