package com.tomholmes.product.htmx.demo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tomholmes.product.htmx.demo.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@WebAppConfiguration
@Transactional
public class RestContactEmailControllerTest
{
    private final static String BASE_URL = "/rest/contact/email";

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    protected MockHttpSession session;

    @BeforeEach
    public void setUp()
    {
        this.session = new MockHttpSession();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    // =============================================

    private final static LocalDateTime enteredDate = LocalDateTime.now();
    private final static String email = "duncan.hines@somedomain.com";
    private final static long emailTypeId = 1;

    private ContactEmailEntity createContactEmailEntity()
    {
        long contactId = 4;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);

        ContactEmailEntity contactEmailDto = new ContactEmailEntity();
        contactEmailDto.setContact(contactEntity);
        contactEmailDto.setEmailId(null);
        contactEmailDto.setEnteredDate(enteredDate);
        contactEmailDto.setEmail(email);

        EmailTypeEntity emailType = new EmailTypeEntity();
        emailType.setId(emailTypeId);
        contactEmailDto.setEmailType(emailType);

        return contactEmailDto;
    }

    @Test
    public void testGetContactEmailListByContactId() throws Exception
    {
        System.out.println("testGetContactEmailListByContactId: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/contactId/5");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetContactEmailListByContactId: FINISH");
    }

    // @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
    // public @ResponseBody ContactEntity createContact(@RequestBody ContactEntity contact)
    @Test
    public void testCreateContact() throws Exception
    {
        ContactEmailEntity contactEmailEntity = createContactEmailEntity();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String json = mapper.writeValueAsString(contactEmailEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/create").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    // @DeleteMapping(value = "/delete/{contactId}",  headers = "Accept=application/json")
    // public @ResponseBody void deleteContact(@PathVariable("contactId") long contactId)
    @Test
    public void testDeleteContact() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(BASE_URL + "/delete/{contactEmailId}",6L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }


}
