package com.tomholmes.product.htmx.demo.service;

import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;

import java.util.List;

public interface ContactPhoneService
{
    List<ContactPhoneEntity> getAllPhonesByContactId(long contactId);

    ContactPhoneEntity getPhoneContactById(long phoneId);

    List<ContactPhoneEntity> getAllPhonesByContactId(ContactEntity contactEntity);

    ContactPhoneEntity createContactPhone(ContactPhoneEntity contactPhone);

    ContactPhoneEntity updateContactPhone(ContactPhoneEntity contactPhone);

    void deleteContactPhone(ContactPhoneEntity contactPhone);

    void deleteContactPhoneById(long contactPhoneId);
}
