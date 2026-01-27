package com.fooddelivery;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;

    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Role {
        CUSTOMER, RESTAURANT_OWNER, DELIVERY_PARTNER, ADMIN
    }
}