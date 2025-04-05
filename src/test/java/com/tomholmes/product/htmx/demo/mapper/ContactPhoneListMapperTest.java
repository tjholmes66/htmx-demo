package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.dto.ContactPhoneDTO;
import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import com.tomholmes.product.htmx.demo.repository.ContactPhoneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo")
public class ContactPhoneListMapperTest {

    @Autowired
    private ContactPhoneRepository contactPhoneRepository; // repository

    @Autowired
    private ContactPhoneListMapper contactPhoneListMapper;

    @Test
    public void testDtoListToEntityList() {
        Long contactId = 5L;
        List<ContactPhoneEntity> contactPhoneEntityList = contactPhoneRepository.findByContactContactId(contactId);
        assertNotNull(contactPhoneEntityList);
        assertEquals(3, contactPhoneEntityList.size());

        List<ContactPhoneDTO> contactPhoneDTOList = contactPhoneListMapper.entityListToDtoList(contactPhoneEntityList);
        assertNotNull(contactPhoneDTOList);
        assertEquals(3, contactPhoneDTOList.size());

        contactPhoneEntityList = contactPhoneListMapper.dtoListToEntityList(contactPhoneDTOList);
        assertNotNull(contactPhoneDTOList);
        assertEquals(3, contactPhoneDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        Long contactId = 5L;
        List<ContactPhoneEntity> contactPhoneEntityList = contactPhoneRepository.findByContactContactId(contactId);
        assertNotNull(contactPhoneEntityList);
        assertEquals(3, contactPhoneEntityList.size());

        List<ContactPhoneDTO> contactPhoneDTOList = contactPhoneListMapper.entityListToDtoList(contactPhoneEntityList);
        assertNotNull(contactPhoneDTOList);
        assertEquals(3, contactPhoneDTOList.size());
    }

}
