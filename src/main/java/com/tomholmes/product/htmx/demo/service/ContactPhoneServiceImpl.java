package com.tomholmes.product.htmx.demo.service;

import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.repository.ContactPhoneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("contactPhoneService")
public class ContactPhoneServiceImpl implements ContactPhoneService
{
    private ContactPhoneRepository contactPhoneDao;

    public ContactPhoneServiceImpl(ContactPhoneRepository contactPhoneDao)
    {
        this.contactPhoneDao = contactPhoneDao;
    }

    @Override
    public List<ContactPhoneEntity> getAllPhonesByContactId(long contactId)
    {
        ContactEntity contact = new ContactEntity();
        contact.setContactId(contactId);
        List<ContactPhoneEntity> contactPhoneList = contactPhoneDao.findByContact(contact);
        return contactPhoneList;
    }

    @Override
    public List<ContactPhoneEntity> getAllPhonesByContactId(ContactEntity contactEntity)
    {
        List<ContactPhoneEntity> contactPhoneList = contactPhoneDao.findByContact(contactEntity);
        return contactPhoneList;
    }

    @Override
    public ContactPhoneEntity createContactPhone(ContactPhoneEntity contactPhone) {
        ContactPhoneEntity contactPhoneEntity = contactPhoneDao.save(contactPhone);
        return contactPhoneEntity;
    }

    @Override
    public ContactPhoneEntity updateContactPhone(ContactPhoneEntity contactPhone) {
        ContactPhoneEntity contactPhoneEntity = contactPhoneDao.save(contactPhone);
        return contactPhoneEntity;
    }

    @Override
    public void deleteContactPhone(ContactPhoneEntity contactPhone) {
        contactPhoneDao.delete(contactPhone);
    }

    @Override
    public void deleteContactPhoneById(long contactPhoneId) {
        ContactPhoneEntity contactPhoneEntity = contactPhoneDao.findById(contactPhoneId).orElse(null);
        contactPhoneDao.delete(contactPhoneEntity);
    }

    @Override
    public ContactPhoneEntity getPhoneContactById(long phoneId)
    {
        ContactPhoneEntity contactPhoneEntity = contactPhoneDao.findById(phoneId).orElse(null);
        return contactPhoneEntity;
    }
}
