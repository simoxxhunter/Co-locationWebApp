package com.colocation.services;


import com.colocation.models.ContactModel;
import com.colocation.repositories.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImp implements ContactService {

    private final ContactRepo ContactRepository;

    @Autowired
    public ContactServiceImp(ContactRepo contactRepository) {
        ContactRepository = contactRepository;
    }

    public ContactModel createContact(ContactModel contact) {

        return ContactRepository.save(contact);
    }

    public Optional<ContactModel> getContactById(Long id) {
        return ContactRepository.findById(id);
    }

    public List<ContactModel> getAllContacts() {
        return ContactRepository.findAll();
    }

    public void deleteContact(Long id) {
        ContactRepository.deleteById(id);
    }
}
