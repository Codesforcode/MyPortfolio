package com.akash.portfolio.service;

import com.akash.portfolio.entity.Contact;
import com.akash.portfolio.repository.ContactRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ContactService {
    private final ContactRepository repository;
    public void save(Contact contact){
        repository.save(contact);
    }



}
