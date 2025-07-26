package com.tomholmes.product.htmx.demo.service;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.LinkTypeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo.services")
@Transactional
public class ContactLinkServiceImplTest
{
    @Autowired
    private ContactLinkService service;

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

    private final static String link = "111-222-1234";
    private final static long linkTypeId = 1;

    private ContactLinkEntity createContactLinkDto()
    {
        long contactId = 4;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ============================================================
        ContactLinkEntity contactLinkDto = new ContactLinkEntity();
        contactLinkDto.setContact(contactEntity);
        contactLinkDto.setLinkId(id);
        contactLinkDto.setEnteredDate(enteredDate);
        contactLinkDto.setLink(link);

        LinkTypeEntity linkType = new LinkTypeEntity();
        linkType.setId(linkTypeId);
        contactLinkDto.setLinkType(linkType);

        return contactLinkDto;
    }

    @Test
    public void testCreateContactLink() throws Exception
    {
        System.out.println("testCreateContactLink: START");
        ContactLinkEntity contactLinkEntity = createContactLinkDto();
        contactLinkEntity.setLinkId(null);
        // ==================================================
        ContactLinkEntity newContactLinkEntity = service.createContactLink(contactLinkEntity);
        assertNotNull(newContactLinkEntity);
        assertNotNull(newContactLinkEntity.getLinkId());
        // ==================================================
        System.out.println("testCreateContactLink: FINISH");
    }

    @Test
    public void testDeleteContactLink() throws Exception
    {
        System.out.println("testDeleteContactLink: START");
        System.out.println("createContactLink: START");
        ContactLinkEntity contactLinkEntity = createContactLinkDto();
        contactLinkEntity.setLinkId(null);
        // ==================================================
        ContactLinkEntity newContactLinkEntity = service.createContactLink(contactLinkEntity);
        assertNotNull(newContactLinkEntity);
        assertNotNull(newContactLinkEntity.getLinkId());
        System.out.println("createContactLink: FINISH");
        // ==================================================
        System.out.println("deleteContactLink: START");
        service.deleteContactLink(newContactLinkEntity);
        System.out.println("deleteContactLink: FINISH");
        // ==================================================
        System.out.println("testDeleteContactLink: FINISH");
    }

    @Test
    public void testDeleteContactLinkById() throws Exception
    {
        System.out.println("testDeleteContactLink: START");
        System.out.println("createContactLink: START");
        ContactLinkEntity contactLinkEntity = createContactLinkDto();
        contactLinkEntity.setLinkId(null);
        // ==================================================
        ContactLinkEntity newContactLinkEntity = service.createContactLink(contactLinkEntity);
        assertNotNull(newContactLinkEntity);
        assertNotNull(newContactLinkEntity.getLinkId());
        System.out.println("createContactLink: FINISH");
        // ==================================================
        System.out.println("deleteContactLink: START");
        service. deleteContactLinkById(newContactLinkEntity.getLinkId());
        System.out.println("deleteContactLink: FINISH");
        // ==================================================
        System.out.println("testDeleteContactLink: FINISH");
    }

    @Test
    public void testRetrieveLinksByContactDto1() throws Exception
    {
        System.out.println("testFetchByContactExample1: START");
        long contactId = 1;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ==================================================
        List<ContactLinkEntity> contactLinks = service.getAllLinksByContactId(contactEntity.getContactId());
        ContactLinkEntity contactLink = null;
        if (contactLinks != null)
        {
            System.out.println("testFetchByContactExample1: contacts: size=" + contactLinks.size());
            System.out.println("testFetchByContactExample1: contacts=" + contactLinks.toString());

            if (contactLinks.size() > 0)
            {
                contactLink = contactLinks.get(0);
                System.out.println("testFetchByContactExample1: contactLink: id=" + contactLink.getLinkId());
                System.out.println("testFetchByContactExample1: contactLink: contactId=" + contactLink.getContact().getContactId());
                System.out.println("testFetchByContactExample1: contactLink: link=" + contactLink.getLink());
                System.out.println("testFetchByContactExample1: contactLink=" + contactLink.toString());
            }
        }
        assertNotNull(contactLinks);
        // ==================================================
        System.out.println("testFetchByContactExample: FINISH");
    }

    @Test
    public void testRetrieveLinksByContactDto2() throws Exception
    {
        System.out.println("testFetchByContactExample1: START");
        long contactId = 4;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ==================================================
        List<ContactLinkEntity> contactLinks = service.getAllLinksByContactId(contactEntity.getContactId());
        ContactLinkEntity contactLink = null;
        if (contactLinks != null)
        {
            System.out.println("testFetchByContactExample1: contacts: size=" + contactLinks.size());
            System.out.println("testFetchByContactExample1: contacts=" + contactLinks.toString());

            if (contactLinks.size() > 0)
            {
                contactLink = contactLinks.get(0);
                System.out.println("testFetchByContactExample1: contactLink: id=" + contactLink.getLinkId());
                System.out.println("testFetchByContactExample1: contactLink: contactId=" + contactLink.getContact().getContactId());
                System.out.println("testFetchByContactExample1: contactLink: link=" + contactLink.getLink());
                System.out.println("testFetchByContactExample1: contactLink=" + contactLink.toString());
            }
        }
        assertNotNull(contactLinks);
        // ==================================================
        System.out.println("testFetchByContactExample: FINISH");
    }

    @Test
    public void testFetchById() throws Exception
    {
        System.out.println("testFetchById: START");
        long linkId = 4;
        // ==================================================
        ContactLinkEntity contactLink = service.getLinkContactById(linkId);
        System.out.println("testFetchByContactExample: contactLink: id=" + contactLink.getLinkId());
        System.out.println("testFetchByContactExample: contactLink: contactId=" + contactLink.getContact().getContactId());
        System.out.println("testFetchByContactExample: contactLink: link=" + contactLink.getLink());
        System.out.println("contacts=" + contactLink.toString());
        assertNotNull(contactLink);
        // ==================================================
        System.out.println("testFetchById: FINISH");
    }

}
