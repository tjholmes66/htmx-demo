package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.dto.ContactLinkDTO;
import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.repository.ContactLinkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo")
public class ContactLinkListMapperTest {

    @Autowired
    private ContactLinkRepository contactLinkRepository; // repository

    @Autowired
    private ContactLinkListMapper contactLinkListMapper;

    @Test
    public void testDtoListToEntityList() {
        Long contactId = 5L;
        List<ContactLinkEntity> contactLinkEntityList = contactLinkRepository.findByContactContactId(contactId);
        assertNotNull(contactLinkEntityList);
        assertEquals(1, contactLinkEntityList.size());

        List<ContactLinkDTO> contactLinkDTOList = contactLinkListMapper.entityListToDtoList(contactLinkEntityList);
        assertNotNull(contactLinkDTOList);
        assertEquals(1, contactLinkDTOList.size());

        contactLinkEntityList = contactLinkListMapper.dtoListToEntityList(contactLinkDTOList);
        assertNotNull(contactLinkDTOList);
        assertEquals(1, contactLinkDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        Long contactId = 5L;
        List<ContactLinkEntity> contactLinkEntityList = contactLinkRepository.findByContactContactId(contactId);
        assertNotNull(contactLinkEntityList);
        assertEquals(1, contactLinkEntityList.size());

        List<ContactLinkDTO> contactLinkDTOList = contactLinkListMapper.entityListToDtoList(contactLinkEntityList);
        assertNotNull(contactLinkDTOList);
        assertEquals(1, contactLinkDTOList.size());
    }

}
