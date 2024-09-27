package com.colocation.services;

import com.colocation.models.ContactModel;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    ContactModel createContact(ContactModel contact);

    Optional<ContactModel> getContactById(Long id);
    List<ContactModel> getAllContacts();
    void deleteContact(Long id);
}
