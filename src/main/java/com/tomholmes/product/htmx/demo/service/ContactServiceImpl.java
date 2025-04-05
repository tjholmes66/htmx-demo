package com.tomholmes.product.htmx.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.tomholmes.product.htmx.demo.dto.*;
import com.tomholmes.product.htmx.demo.mapper.ContactEmailListMapper;
import com.tomholmes.product.htmx.demo.mapper.ContactLinkListMapper;
import com.tomholmes.product.htmx.demo.mapper.ContactListMapper;
import com.tomholmes.product.htmx.demo.mapper.ContactPhoneListMapper;
import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import com.tomholmes.product.htmx.demo.repository.ContactEmailRepository;
import com.tomholmes.product.htmx.demo.repository.ContactLinkRepository;
import com.tomholmes.product.htmx.demo.repository.ContactPhoneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.repository.ContactRepository;

@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService
{
    private ContactRepository contactDao;

    private ContactEmailRepository contactEmailDao;
    private ContactPhoneRepository contactPhoneDao;
    private ContactLinkRepository contactLinkDao;

    private ContactListMapper contactListMapper;

    private ContactEmailListMapper contactEmailListMapper;
    private ContactPhoneListMapper contactPhoneListMapper;
    private ContactLinkListMapper contactLinkListMapper;

    public ContactServiceImpl(ContactRepository contactDao,
                              ContactListMapper contactListMapper,
                              ContactEmailRepository contactEmailDao,
                              ContactPhoneRepository contactPhoneDao,
                              ContactLinkRepository contactLinkDao,
                              ContactEmailListMapper contactEmailListMapper,
                              ContactPhoneListMapper contactPhoneListMapper,
                              ContactLinkListMapper contactLinkListMapper
                              )
    {
        this.contactDao = contactDao;
        this.contactListMapper = contactListMapper;
        this.contactEmailDao = contactEmailDao;
        this.contactPhoneDao = contactPhoneDao;
        this.contactLinkDao = contactLinkDao;
        this.contactEmailListMapper = contactEmailListMapper;
        this.contactPhoneListMapper = contactPhoneListMapper;
        this.contactLinkListMapper = contactLinkListMapper;
    }

    @Override
    public List<ContactEntity> getAllContacts()
    {
        List<ContactEntity> contactList = contactDao.findAll();
        return contactList;
    }

    @Override
    public List<ContactDTO> getContactsByUserId(long userId)
    {
        List<ContactDTO> contactDTOList = new ArrayList<ContactDTO>();
        List<ContactEntity> contactEntityList = contactDao.findByUserUserId(userId);
        contactDTOList = contactListMapper.entityListToDtoList(contactEntityList);
        return contactDTOList;
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

    @Override
    public ContactDataResponseDTO getContactDataById(long contactId) {
        System.out.println("getContactDataById: contactId=" + contactId);
        ContactDataResponseDTO contactDataResponseDTO = new ContactDataResponseDTO();

        List<ContactEmailEntity> contactEmailEntityList = contactEmailDao.findByContactContactId(contactId);
        List<ContactEmailDTO> contactEmailDTOList = contactEmailListMapper.entityListToDtoList(contactEmailEntityList);
        contactDataResponseDTO.setEmailList(contactEmailDTOList);

        List<ContactPhoneEntity> contactPhoneEntityList = contactPhoneDao.findByContactContactId(contactId);
        List<ContactPhoneDTO> contactPhoneDTOList = contactPhoneListMapper.entityListToDtoList(contactPhoneEntityList);
        contactDataResponseDTO.setPhoneList(contactPhoneDTOList);

        List<ContactLinkEntity> contactLinkEntityList = contactLinkDao.findByContactContactId(contactId);
        List<ContactLinkDTO> contactLinkDTOList = contactLinkListMapper.entityListToDtoList(contactLinkEntityList);
        contactDataResponseDTO.setLinkList(contactLinkDTOList);

        return contactDataResponseDTO;
    }

}
