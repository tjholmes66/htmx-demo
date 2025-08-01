package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.repository.ContactEmailRepository;

@Transactional
@Service("contactEmailService")
public class ContactEmailServiceImpl implements ContactEmailService
{
    private ContactEmailRepository contactEmailDao;

    public ContactEmailServiceImpl(ContactEmailRepository contactEmailDao)
    {
        this.contactEmailDao = contactEmailDao;
    }

    @Override
    public List<ContactEmailEntity> getAllEmailsByContactId(long contactId)
    {
        ContactEntity contact = new ContactEntity();
        contact.setContactId(contactId);
        List<ContactEmailEntity> contactEmailList = contactEmailDao.findByContact(contact);
        return contactEmailList;
    }

    @Override
    public List<ContactEmailEntity> getAllEmailsByContactId(ContactEntity contactEntity)
    {
        List<ContactEmailEntity> contactEmailList = contactEmailDao.findByContact(contactEntity);
        return contactEmailList;
    }

    @Override
    public ContactEmailEntity createContactEmail(ContactEmailEntity contactEmail) {
        ContactEmailEntity contactEmailEntity = contactEmailDao.save(contactEmail);
        return contactEmailEntity;
    }

    @Override
    public ContactEmailEntity updateContactEmail(ContactEmailEntity contactEmail) {
        ContactEmailEntity contactEmailEntity = contactEmailDao.save(contactEmail);
        return contactEmailEntity;
    }

    @Override
    public void deleteContactEmail(ContactEmailEntity contactEmail) {
        contactEmailDao.delete(contactEmail);
    }

    @Override
    public void deleteContactEmailById(Long contactEmailId)
    {
        ContactEmailEntity contactEmailEntity = contactEmailDao.findById(contactEmailId).orElse(null);
        contactEmailDao.delete(contactEmailEntity);
    }

    @Override
    public ContactEmailEntity getEmailContactById(long emailId)
    {
        ContactEmailEntity contactEmailEntity = contactEmailDao.findById(emailId).orElse(null);
        return contactEmailEntity;
    }
}
