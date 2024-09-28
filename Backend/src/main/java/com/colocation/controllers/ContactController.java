package com.colocation.controllers;

import com.colocation.models.ContactModel;
import com.colocation.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;




@CrossOrigin(origins = "http://localhost:4200/")

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactModel createContact(@RequestBody ContactModel contact) {
        return contactService.createContact(contact);
    }

    @GetMapping("/{id}")
    public ContactModel getContactById(@PathVariable Long id) {
        return contactService.getContactById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
    }

    @GetMapping
    public List<ContactModel> getAllContacts() {
        return contactService.getAllContacts();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}