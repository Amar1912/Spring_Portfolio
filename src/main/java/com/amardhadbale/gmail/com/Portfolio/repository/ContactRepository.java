package com.amardhadbale.gmail.com.Portfolio.repository;

import com.amardhadbale.gmail.com.Portfolio.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}