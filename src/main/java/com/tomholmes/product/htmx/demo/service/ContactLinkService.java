package com.tomholmes.product.htmx.demo.service;

import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;

import java.util.List;

public interface ContactLinkService
{
    List<ContactLinkEntity> getAllLinksByContactId(long contactId);

    ContactLinkEntity getLinkContactById(long linkId);

    List<ContactLinkEntity> getAllLinksByContactId(ContactEntity contactEntity);

    ContactLinkEntity createContactLink(ContactLinkEntity contactLink);

    ContactLinkEntity updateContactLink(ContactLinkEntity contactLink);

    void deleteContactLink(ContactLinkEntity contactLink);

    void deleteContactLinkById(Long contactLinkId);
}
