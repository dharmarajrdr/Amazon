package com.dharmaraj.e_commerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import org.springframework.context.annotation.Lazy;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "users")
public class User extends BaseModel{
    
    private String name;

    private String email;

    private String password;

    private UserType userType;

    @OneToMany
    private List<Order> orders;

    @OneToMany
    @Lazy
    private List<Preference> preferences;
}
