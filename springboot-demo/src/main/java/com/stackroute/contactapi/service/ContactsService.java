package com.stackroute.contactapi.service;

import com.stackroute.contactapi.exceptions.ContactExistsException;
import com.stackroute.contactapi.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactsService {
    Contact addNewContact(Contact contact) throws ContactExistsException;
    List<Contact> getAllContact();
}
