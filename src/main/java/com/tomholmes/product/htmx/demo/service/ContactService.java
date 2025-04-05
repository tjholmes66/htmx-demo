package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import com.tomholmes.product.htmx.demo.dto.ContactDTO;
import com.tomholmes.product.htmx.demo.dto.ContactDataResponseDTO;
import com.tomholmes.product.htmx.demo.model.ContactEntity;

public interface ContactService
{
    List<ContactEntity> getAllContacts();

    List<ContactDTO> getContactsByUserId(long userId);

    ContactEntity getContactById(long contactId);

    ContactEntity add(ContactEntity newContact);

    ContactEntity update(ContactEntity newContact);

    void remove(long contactId);

    ContactDataResponseDTO getContactDataById(long contactId);
}
