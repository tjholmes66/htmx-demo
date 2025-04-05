package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.dto.ContactDTO;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo")
public class ContactListMapperTest {

    @Autowired
    private ContactRepository contactRepository; // repository

    @Autowired
    private ContactListMapper contactListMapper;

    @Test
    public void testDtoListToEntityList() {
        Long userId = 3L;
        List<ContactEntity> contactEntityList = contactRepository.findByUserUserId(userId);
        assertNotNull(contactEntityList);
        assertEquals(2, contactEntityList.size());

        List<ContactDTO> contactDTOList = contactListMapper.entityListToDtoList(contactEntityList);
        assertNotNull(contactDTOList);
        assertEquals(2, contactDTOList.size());

        contactEntityList = contactListMapper.dtoListToEntityList(contactDTOList);
        assertNotNull(contactDTOList);
        assertEquals(2, contactDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        Long userId = 3L;
        List<ContactEntity> contactEntityList = contactRepository.findByUserUserId(userId);
        assertNotNull(contactEntityList);
        assertEquals(2, contactEntityList.size());

        List<ContactDTO> contactDTOList = contactListMapper.entityListToDtoList(contactEntityList);
        assertNotNull(contactDTOList);
        assertEquals(2, contactDTOList.size());
    }

}
