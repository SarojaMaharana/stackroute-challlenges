package com.stackroute.contactapi.controller;

// api/v1/contacts

import com.stackroute.contactapi.exceptions.ContactExistsException;
import com.stackroute.contactapi.model.Contact;
import com.stackroute.contactapi.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private ContactsService service;

    @Autowired
    public ContactController(ContactsService service) {
        this.service = service;
    }

    @GetMapping("welcome")
    public String welcome(){
        return "Welcome to Spring Boot Rest API";
    }

    @PostMapping
    public Contact addNewContact(@RequestBody Contact newContact) throws ContactExistsException {
        return this.service.addNewContact(newContact);
    }

    @GetMapping
    public List<Contact> getAllContacts(){
        return this.service.getAllContact();
    }


}
