package com.tomholmes.product.htmx.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.EmailTypeEntity;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo.services")
@Transactional
public class ContactEmailServiceImplTest
{
    @Autowired
    private ContactEmailService service;

    private final static long id = 0;
    private final static String prefix = "Mr.";
    private final static String firstname = "Thomas";
    private final static String middlename = "Joseph";
    private final static String lastname = "Holmes";
    private final static String suffix = "Jr.";

    private final static String address1 = "42 Wheeler Circle";
    private final static String address2 = "Apartment 38";
    private final static String city = "Stoughton";
    private final static String state = "MA";
    private final static String zip = "02072";

    private final static long enteredBy = 1;
    private final static LocalDateTime enteredDate = LocalDateTime.now();
    private final static long editedBy = 1;
    private final static LocalDateTime editedDate = LocalDateTime.now();

    private final static LocalDate birthDate = LocalDate.now();
    private final static boolean admin = false;

    private final static String email = "111-222-1234";
    private final static long emailTypeId = 1;

    private ContactEmailEntity createContactEmailDto()
    {
        long contactId = 4;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ============================================================
        ContactEmailEntity contactEmailDto = new ContactEmailEntity();
        contactEmailDto.setContact(contactEntity);
        contactEmailDto.setEmailId(id);
        contactEmailDto.setEnteredDate(enteredDate);
        contactEmailDto.setEmail(email);

        EmailTypeEntity emailType = new EmailTypeEntity();
        emailType.setId(emailTypeId);
        contactEmailDto.setEmailType(emailType);

        return contactEmailDto;
    }

    @Test
    public void testCreateContactEmail() throws Exception
    {
        System.out.println("testCreateContactEmail: START");
        ContactEmailEntity contactEmailEntity = createContactEmailDto();
        contactEmailEntity.setEmailId(null);
        // ==================================================
        ContactEmailEntity newContactEmailEntity = service.createContactEmail(contactEmailEntity);
        assertNotNull(newContactEmailEntity);
        assertNotNull(newContactEmailEntity.getEmailId());
        // ==================================================
        System.out.println("testCreateContactEmail: FINISH");
    }

    @Test
    public void testDeleteContactEmail() throws Exception
    {
        System.out.println("testDeleteContactEmail: START");
        System.out.println("createContactEmail: START");
        ContactEmailEntity contactEmailEntity = createContactEmailDto();
        contactEmailEntity.setEmailId(null);
        // ==================================================
        ContactEmailEntity newContactEmailEntity = service.createContactEmail(contactEmailEntity);
        assertNotNull(newContactEmailEntity);
        assertNotNull(newContactEmailEntity.getEmailId());
        System.out.println("createContactEmail: FINISH");
        // ==================================================
        System.out.println("deleteContactEmail: START");
        service.deleteContactEmail(newContactEmailEntity);
        System.out.println("deleteContactEmail: FINISH");
        // ==================================================
        System.out.println("testDeleteContactEmail: FINISH");
    }

    @Test
    public void testDeleteContactEmailById() throws Exception
    {
        System.out.println("testDeleteContactEmail: START");
        System.out.println("createContactEmail: START");
        ContactEmailEntity contactEmailEntity = createContactEmailDto();
        contactEmailEntity.setEmailId(null);
        // ==================================================
        ContactEmailEntity newContactEmailEntity = service.createContactEmail(contactEmailEntity);
        assertNotNull(newContactEmailEntity);
        assertNotNull(newContactEmailEntity.getEmailId());
        System.out.println("createContactEmail: FINISH");
        // ==================================================
        System.out.println("deleteContactEmail: START");
        service.deleteContactEmailById(newContactEmailEntity.getEmailId());
        System.out.println("deleteContactEmail: FINISH");
        // ==================================================
        System.out.println("testDeleteContactEmail: FINISH");
    }

    @Test
    public void testRetrieveEmailsByContactDto1() throws Exception
    {
        System.out.println("testFetchByContactExample1: START");
        long contactId = 1;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ==================================================
        List<ContactEmailEntity> contactEmails = service.getAllEmailsByContactId(contactEntity.getContactId());
        ContactEmailEntity contactEmail = null;
        if (contactEmails != null)
        {
            System.out.println("testFetchByContactExample1: contacts: size=" + contactEmails.size());
            System.out.println("testFetchByContactExample1: contacts=" + contactEmails.toString());

            if (contactEmails.size() > 0)
            {
                contactEmail = contactEmails.get(0);
                System.out.println("testFetchByContactExample1: contactEmail: id=" + contactEmail.getEmailId());
                System.out.println("testFetchByContactExample1: contactEmail: contactId=" + contactEmail.getContact().getContactId());
                System.out.println("testFetchByContactExample1: contactEmail: email=" + contactEmail.getEmail());
                System.out.println("testFetchByContactExample1: contactEmail=" + contactEmail.toString());
            }
        }
        assertNotNull(contactEmails);
        // ==================================================
        System.out.println("testFetchByContactExample: FINISH");
    }

    @Test
    public void testRetrieveEmailsByContactDto2() throws Exception
    {
        System.out.println("testFetchByContactExample1: START");
        long contactId = 4;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ==================================================
        List<ContactEmailEntity> contactEmails = service.getAllEmailsByContactId(contactEntity.getContactId());
        ContactEmailEntity contactEmail = null;
        if (contactEmails != null)
        {
            System.out.println("testFetchByContactExample1: contacts: size=" + contactEmails.size());
            System.out.println("testFetchByContactExample1: contacts=" + contactEmails.toString());

            if (contactEmails.size() > 0)
            {
                contactEmail = contactEmails.get(0);
                System.out.println("testFetchByContactExample1: contactEmail: id=" + contactEmail.getEmailId());
                System.out.println("testFetchByContactExample1: contactEmail: contactId=" + contactEmail.getContact().getContactId());
                System.out.println("testFetchByContactExample1: contactEmail: email=" + contactEmail.getEmail());
                System.out.println("testFetchByContactExample1: contactEmail=" + contactEmail.toString());
            }
        }
        assertNotNull(contactEmails);
        // ==================================================
        System.out.println("testFetchByContactExample: FINISH");
    }

    @Test
    public void testFetchById() throws Exception
    {
        System.out.println("testFetchById: START");
        long emailId = 4;
        // ==================================================
        ContactEmailEntity contactEmail = service.getEmailContactById(emailId);
        System.out.println("testFetchByContactExample: contactEmail: id=" + contactEmail.getEmailId());
        System.out.println("testFetchByContactExample: contactEmail: contactId=" + contactEmail.getContact().getContactId());
        System.out.println("testFetchByContactExample: contactEmail: email=" + contactEmail.getEmail());
        System.out.println("contacts=" + contactEmail.toString());
        assertNotNull(contactEmail);
        // ==================================================
        System.out.println("testFetchById: FINISH");
    }

}
