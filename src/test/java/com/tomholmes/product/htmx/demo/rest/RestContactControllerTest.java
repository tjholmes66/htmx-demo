package com.tomholmes.product.htmx.demo.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tomholmes.product.htmx.demo.dto.ContactDataResponseDTO;
import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.repository.CompanyRepository;
import com.tomholmes.product.htmx.demo.repository.ContactRepository;
import com.tomholmes.product.htmx.demo.repository.UserRepository;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.UserEntity;

@SpringBootTest
@WebAppConfiguration
@Transactional
public class RestContactControllerTest
{
    private final static String BASE_URL = "/rest/contacts";

    private final static long contactId = 0;
    // =============================================
    private final static String prefix = "Mr.";
    private final static String firstName = "contact_fn1";
    private final static String middleName = "contact_mn1";
    private final static String lastName = "contact_ln1";
    private final static String suffix = "Jr.";
    // =============================================
    private final static String address1 = "123 Main Street";
    private final static String address2 = "Apartment 38A";
    private final static String city = "Boston";
    private final static String state = "MA";
    private final static String zip = "02368-1234";
    // =============================================
    private final static long editedBy = 1;
    private final static LocalDateTime editedDate = LocalDateTime.now();
    private final static long enteredBy = 1;
    private final static LocalDateTime enteredDate = LocalDateTime.now();
    // =============================================
    private final static long companyId = 0;
    private final static LocalDate birthDate = LocalDate.now();

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CompanyRepository companyRepository;

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

    private ContactEntity createContactEntity()
    {
        ContactEntity contactEntity = new ContactEntity();
        // contactEntity.setContactId(contactId);
        // =============================================
        contactEntity.setPrefix(prefix);
        contactEntity.setFirstName(firstName);
        contactEntity.setMiddleName(middleName);
        contactEntity.setLastName(lastName);
        contactEntity.setSuffix(suffix);
        // =============================================
        contactEntity.setAddress1(address1);
        contactEntity.setAddress2(address2);
        contactEntity.setCity(city);
        contactEntity.setState(state);
        contactEntity.setZip(zip);
        // =============================================
        CompanyEntity companyEntity = companyRepository.findByCompanyId(companyId);
        contactEntity.setCompany(companyEntity);
        // =============================================
        contactEntity.setBirthDate(birthDate);
        // =============================================
        contactEntity.setEditedBy(editedBy);
        contactEntity.setEditedDate(editedDate);
        contactEntity.setEnteredBy(enteredBy);
        contactEntity.setEnteredDate(enteredDate);
        // =============================================
        // contactEntity.setEmails(emails)
        // contactEntity.setPhones(phones)
        // contactEntity.setLinks(links)
        // =============================================
        long userId = 1;
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        // =============================================
        contactEntity.setUser(user);
        // =============================================
        return contactEntity;
    }

    private final static int updId = 9;
    private final static String updEmail = "tom@tomholmes.new";
    private final static int updPositionId = 3;
    private final static String updFirstname = "tom4_upd";
    private final static String updLastname = "holmes4_upd";
    private final static String updPassword = "pass4upd";
    private final static String updSecurityQuestion1 = "question1upd";
    private final static String updSecurityQuestion2 = "question2upd";
    private final static String updSecurityAnswer1 = "answer1upd";
    private final static String updSecurityAnswer2 = "answer2upd";

    /*
    I have the following URIs:
    
        /contacts - Returns all contacts
        /contacts/contact/{id} - Return a specific user
        /contacts/create/{user} - Add user to db
        /contacts/update/{user} - Update user
        /contacts/delete/{id} - Delete Contact
    */

    // @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    // public ArrayList<ContactEntity> getContactList1()
    @Test
    public void testGetContactList1() throws Exception
    {
        System.out.println("testGetContactList1: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetContactList1: FINISH");
    }

    // @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    // public @ResponseBody ArrayList<ContactEntity> getContactList2()
    @Test
    public void testGetContactList2() throws Exception
    {
        System.out.println("testGetContactList2: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetContactList2: FINISH");
    }

    // @RequestMapping(value = "/contactId/{contactId}", method = RequestMethod.GET, headers =
    // "Accept=application/json")
    // public @ResponseBody ContactEntity getContactById(@PathVariable("contactId") long contactId)
    @Test
    public void testGetContactById() throws Exception
    {
        System.out.println("testGetContactById: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/contactId/6");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetContactById: FINISH");
    }

    // @GetMapping(value = "/data/{contactId}", headers = "Accept=application/json")
    // public @ResponseBody ContactDataResponseDTO getContactDataById(@PathVariable("contactId") long contactId)
    @Test
    public void testGetContactDataById() throws Exception
    {
        System.out.println("testGetContactDataById: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/data/5");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetContactDataById: FINISH");
    }


    // @GetMapping(value = "/userId/{userId}", headers = "Accept=application/json")
    //public @ResponseBody List<ContactEntity> getContactsByUserId(@PathVariable("userId") long userId)
    @Test
    public void testGetContactsByUserId() throws Exception
    {
        System.out.println("testGetContactsByUserId: START");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/userId/1");
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
        System.out.println("testGetContactsByUserId: FINISH");
    }

    // @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
    // public @ResponseBody ContactEntity createContact(@RequestBody ContactEntity contact)
    @Test
    public void testCreateContact() throws Exception
    {
        ContactEntity contactEntity = createContactEntity();

        ObjectMapper mapper = new ObjectMapper();
        // Register the JavaTimeModule
        mapper.registerModule(new JavaTimeModule());
        // Optional: Disable writing dates as timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String json = mapper.writeValueAsString(contactEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + "/create").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    // @PutMapping(value = "/update", produces = "application/json", headers = "content-type=application/json")
    // public @ResponseBody ContactEntity updateContact(@RequestBody ContactEntity contact)
    @Test
    public void testUpdateContact() throws Exception
    {
        Long contactId = 6L;
        ContactEntity contactEntity =  contactRepository.findById(contactId).orElse(null);
        contactEntity.setFirstName("UPD_FIRST_NAME");
        contactEntity.setLastName("UPD_LAST_NAME");

        ObjectMapper mapper = new ObjectMapper();
        // Register the JavaTimeModule
        mapper.registerModule(new JavaTimeModule());
        // Optional: Disable writing dates as timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String json = mapper.writeValueAsString(contactEntity);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put(BASE_URL + "/update").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    // @DeleteMapping(value = "/delete/{contactId}",  headers = "Accept=application/json")
    // public @ResponseBody void deleteContact(@PathVariable("contactId") long contactId)
    @Test
    public void testDeleteContact() throws Exception {
        Long contactId = 6L;
        ContactEntity contactEntity = contactRepository.findById(contactId).orElse(null);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete(BASE_URL + "/delete/{contactId}",6L).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
