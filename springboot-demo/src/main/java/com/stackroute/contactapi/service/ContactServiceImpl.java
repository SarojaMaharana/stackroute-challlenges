package com.stackroute.contactapi.service;

import com.stackroute.contactapi.dao.ContactRepository;
import com.stackroute.contactapi.exceptions.ContactExistsException;
import com.stackroute.contactapi.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactsService{

    private ContactRepository repository;

    @Autowired
    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact addNewContact(Contact contact) throws ContactExistsException {
        //contact.getEmail()
        final Optional<Contact> contactOptional = this.repository.findByEmail(contact.getEmail());
        if(contactOptional.isPresent()){
            throw new ContactExistsException("Contact already exists");
        }
        contact.setContactId(UUID.randomUUID().toString());
        final Contact newContact = this.repository.save(contact);
        return newContact;
    }

    @Override
    public List<Contact> getAllContact() {
        return this.repository.findAll();
    }
}
