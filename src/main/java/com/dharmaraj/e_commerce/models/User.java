package com.dharmaraj.e_commerce.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "users")
public class User extends BaseModel{
    
    private String name;
    private String email;
    private String password;
    private UserType userType;
}
