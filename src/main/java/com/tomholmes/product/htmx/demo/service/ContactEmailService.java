package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;

public interface ContactEmailService
{
    List<ContactEmailEntity> getAllEmailsByContactId(long contactId);

    ContactEmailEntity getEmailContactById(long emailId);

    List<ContactEmailEntity> getAllEmailsByContactId(ContactEntity contactEntity);

    ContactEmailEntity createContactEmail(ContactEmailEntity contactEmail);

    ContactEmailEntity updateContactEmail(ContactEmailEntity contactEmail);

    void deleteContactEmail(ContactEmailEntity contactEmail);

}
