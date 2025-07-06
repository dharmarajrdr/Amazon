package com.dharmaraj.e_commerce.models;

import lombok.Data;

import java.util.Date;

import jakarta.persistence.Entity;

@Data
@Entity
public class Preference extends BaseModel {
    
    private String category;
    private String description;
    private Date createdAt;
}
