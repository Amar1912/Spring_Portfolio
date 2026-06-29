package com.amardhadbale.gmail.com.Portfolio.service;

import com.amardhadbale.gmail.com.Portfolio.entity.Contact;
import com.amardhadbale.gmail.com.Portfolio.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void saveContact(Contact contact) {

        contactRepository.save(contact);

    }
}