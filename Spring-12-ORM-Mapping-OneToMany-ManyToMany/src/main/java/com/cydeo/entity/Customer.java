package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String email;
    private String name;
    private String surname;
    private String username;

    public Customer(String address, String email, String name, String surname, String username) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Payment> paymentList;
}
