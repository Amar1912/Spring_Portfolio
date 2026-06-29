package com.amardhadbale.gmail.com.Portfolio.service;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    public void saveContact(String name, String email, String subject, String message) {

        System.out.println("===== Contact Details =====");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);

    }

}