package com.tomholmes.product.htmx.demo.service;

import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.repository.ContactLinkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("contactLinkService")
public class ContactLinkServiceImpl implements ContactLinkService
{
    private ContactLinkRepository contactLinkDao;

    public ContactLinkServiceImpl(ContactLinkRepository contactLinkDao)
    {
        this.contactLinkDao = contactLinkDao;
    }

    @Override
    public List<ContactLinkEntity> getAllLinksByContactId(long contactId)
    {
        ContactEntity contact = new ContactEntity();
        contact.setContactId(contactId);
        List<ContactLinkEntity> contactLinkList = contactLinkDao.findByContact(contact);
        return contactLinkList;
    }

    @Override
    public List<ContactLinkEntity> getAllLinksByContactId(ContactEntity contactEntity)
    {
        List<ContactLinkEntity> contactLinkList = contactLinkDao.findByContact(contactEntity);
        return contactLinkList;
    }

    @Override
    public ContactLinkEntity createContactLink(ContactLinkEntity contactLink) {
        ContactLinkEntity contactLinkEntity = contactLinkDao.save(contactLink);
        return contactLinkEntity;
    }

    @Override
    public ContactLinkEntity updateContactLink(ContactLinkEntity contactLink) {
        ContactLinkEntity contactLinkEntity = contactLinkDao.save(contactLink);
        return contactLinkEntity;
    }

    @Override
    public void deleteContactLink(ContactLinkEntity contactLink) {
        contactLinkDao.delete(contactLink);
    }

    @Override
    public void deleteContactLinkById(Long contactLinkId)
    {
        ContactLinkEntity contactLinkEntity = contactLinkDao.findById(contactLinkId).orElse(null);
        contactLinkDao.delete(contactLinkEntity);
    }
    
    @Override
    public ContactLinkEntity getLinkContactById(long linkId)
    {
        ContactLinkEntity contactLinkEntity = contactLinkDao.findById(linkId).orElse(null);
        return contactLinkEntity;
    }
}
