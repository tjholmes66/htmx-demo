package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.dto.ContactEmailDTO;
import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.repository.ContactEmailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo")
public class ContactEmailListMapperTest {

    @Autowired
    private ContactEmailRepository contactEmailRepository; // repository

    @Autowired
    private ContactEmailListMapper contactEmailListMapper;

    @Test
    public void testDtoListToEntityList() {
        Long contactId = 5L;
        List<ContactEmailEntity> contactEmailEntityList = contactEmailRepository.findByContactContactId(contactId);
        assertNotNull(contactEmailEntityList);
        assertEquals(3, contactEmailEntityList.size());

        List<ContactEmailDTO> contactEmailDTOList = contactEmailListMapper.entityListToDtoList(contactEmailEntityList);
        assertNotNull(contactEmailDTOList);
        assertEquals(3, contactEmailDTOList.size());

        contactEmailEntityList = contactEmailListMapper.dtoListToEntityList(contactEmailDTOList);
        assertNotNull(contactEmailDTOList);
        assertEquals(3, contactEmailDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        Long contactId = 5L;
        List<ContactEmailEntity> contactEmailEntityList = contactEmailRepository.findByContactContactId(contactId);
        assertNotNull(contactEmailEntityList);
        assertEquals(3, contactEmailEntityList.size());

        List<ContactEmailDTO> contactEmailDTOList = contactEmailListMapper.entityListToDtoList(contactEmailEntityList);
        assertNotNull(contactEmailDTOList);
        assertEquals(3, contactEmailDTOList.size());
    }

}
