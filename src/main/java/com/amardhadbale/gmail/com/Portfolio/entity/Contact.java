package com.amardhadbale.gmail.com.Portfolio.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String subject;

    @Column(length = 1000)
    private String message;
    public Contact() {
    }
}
