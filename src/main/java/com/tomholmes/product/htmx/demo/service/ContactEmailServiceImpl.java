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
    public ContactEmailEntity getEmailContactById(long emailId)
    {
        ContactEmailEntity contactEmailEntity = contactEmailDao.getOne(emailId);
        return contactEmailEntity;
    }
}
