package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.UserEntity;
import com.tomholmes.product.htmx.demo.repository.ContactRepository;

@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService
{
    private ContactRepository contactDao;

    public ContactServiceImpl(ContactRepository contactDao)
    {
        this.contactDao = contactDao;
    }

    @Override
    public List<ContactEntity> getAllContacts()
    {
        List<ContactEntity> contactList = contactDao.findAll();
        return contactList;
    }

    @Override
    public List<ContactEntity> getContactsByUserId(long userId)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        List<ContactEntity> contactList = contactDao.findByUser(userEntity);
        return contactList;
    }

    @Override
    public ContactEntity getContactById(long contactId)
    {
        ContactEntity contactEntity = contactDao.findById(contactId).orElse(null);
        return contactEntity;
    }

    @Override
    public ContactEntity add(ContactEntity newContact)
    {
        ContactEntity contactEntity = contactDao.save(newContact);
        return contactEntity;
    }

    @Override
    public ContactEntity update(ContactEntity newContact)
    {
        ContactEntity updatedContactEntity = contactDao.save(newContact);
        return updatedContactEntity;
    }

    @Override
    public void remove(long contactId)
    {
        System.out.println("remove: contactId=" + contactId);
        contactDao.deleteById(contactId);
    }

}
