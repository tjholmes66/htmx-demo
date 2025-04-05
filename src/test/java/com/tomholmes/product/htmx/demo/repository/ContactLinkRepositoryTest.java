package com.tomholmes.product.htmx.demo.repository;

import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.LinkTypeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContactLinkRepositoryTest extends BaseRepositoryTests
{
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactLinkRepository contactLinkRepository;

    private long id = 2;
    private boolean active = true;
    private String address1 = "123 main street";
    private String address2 = "Apt. 456";
    private boolean admin = false;
    private String dob = "11/03/1966";
    private LocalDate birthDate = null;
    private String city = "Randolph";
    private long companyId = 0;
    private String firstName = "first_name";
    private String lastName = "last_name";
    private String password = "password";
    private String username = "username";
    private String prefix = "Mr.";
    private String suffix = "Jr.";
    private String state = "MA";
    private String zip = "12345-1234";
    private String linkUrlNew = "www.tomholmes.net";
    private String linkDescriptionNew = "link description new";
    private String linkUrlUpd = "www.kevinfolan.net";
    private String linkDescriptionUpd = "link description update";
    private long linkTypeId = 1;

    private ContactEntity contact;

    @Test
    public void testContactLinkFetchByContactEntity() throws Exception
    {
        System.out.println("testContactLinkFetchByContact: START");
        // ==========================================================================
        ContactEntity contact = new ContactEntity();
        contact.setContactId(5L);
        List<ContactLinkEntity> contactLinkList = contactLinkRepository.findByContact(contact);
        assertEquals(1, contactLinkList.size());
        // ==========================================================================
        contact = new ContactEntity();
        contact.setContactId(6L);
        contactLinkList = contactLinkRepository.findByContact(contact);
        assertEquals(1, contactLinkList.size());
        // ==========================================================================
        contact = new ContactEntity();
        contact.setContactId(11L); // id does not exist
        contactLinkList = contactLinkRepository.findByContact(contact);
        assertEquals(0, contactLinkList.size());
        // ==========================================================================
        System.out.println("testContactLinkFetchByContact: FINISH");
    }

    @Test
    public void testContactLinkFetchByContactEntityId() throws Exception
    {
        System.out.println("testContactLinkFetchByContact: START");
        // ==========================================================================
        Long contactId = 5L;
        List<ContactLinkEntity> contactLinkList = contactLinkRepository.findByContactContactId(contactId);
        assertEquals(1, contactLinkList.size());
        // ==========================================================================
        contact = new ContactEntity();
        contact.setContactId(6L);
        contactLinkList = contactLinkRepository.findByContactContactId(contactId);
        assertEquals(1, contactLinkList.size());
        // ==========================================================================
        contactId = 11L;    // id does not exist
        contactLinkList = contactLinkRepository.findByContactContactId(contactId);
        assertEquals(0, contactLinkList.size());
        // ==========================================================================
        System.out.println("testContactLinkFetchByContact: FINISH");
    }

    @Test
    public void testCreate() throws Exception
    {
        System.out.println("testCreate: START");
        // =================================================================================
        LinkTypeEntity linkType = new LinkTypeEntity();
        linkType.setId(linkTypeId);
        contact = contactRepository.findById(id).orElse(null);
        // =================================================================================
        ContactLinkEntity contactLink = new ContactLinkEntity();
        // contactLink.setId(id);
        contactLink.setContact(contact);
        contactLink.setLink(linkUrlNew);
        contactLink.setLinkDescription(linkDescriptionNew);
        contactLink.setEnteredDate(LocalDateTime.now());
        contactLink.setLinkType(linkType);
        System.out.println("testCreate: " + contactLink.toString());
        // ***************************************************************
        System.out.println("testCreate: START: CREATE");
        contactLink = contactLinkRepository.save(contactLink);
        assertNotNull(contactLink);
        System.out.println("testCreate: FINISH: CREATE");
        // =================================================================================
        contactLinkRepository.delete(contactLink);
        // =================================================================================
    }

    @Test
    public void testContactRetrieve()
    {
        System.out.println("testContactRetrieve: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testContactRetrieve: START: CREATE");
        List<ContactLinkEntity> contactLinks = (List<ContactLinkEntity>) contactLinkRepository.findAll();
        assertNotNull(contactLinks);
        for (ContactLinkEntity contactLink : contactLinks)
        {
            assertNotNull(contactLink.getLinkId());
            assertNotNull(contactLink.getContact());
            assertNotNull(contactLink.getLinkType());
            // ************************************************************
            // assertEquals(4, contactLink.getContact().getContactId());
            // assertEquals(1, contactLink.getLinkType().getId());
            // ************************************************************
            System.out.println("testContactRetrieve: contactLink=" + contactLink.toString());
        }
        System.out.println("testContactRetrieve: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testContactRetrieveById()
    {
        System.out.println("testContactRetrieveById: START");
        // =================================================================================
        // =================================================================================
        // ***************************************************************
        System.out.println("testContactRetrieveById: START: CREATE");
        ContactLinkEntity contactLink = contactLinkRepository.findById(id).orElse(null);
        assertNotNull(contactLink.getLinkId());
        // ************************************************************
        assertNotNull(contactLink.getLinkId());
        assertNotNull(contactLink.getContact());
        assertNotNull(contactLink.getLinkType());
        // ************************************************************
        assertEquals(5, contactLink.getContact().getContactId());
        assertEquals(7, contactLink.getLinkType().getId());
        // ************************************************************
        System.out.println("testContactRetrieve: contactLink=" + contactLink.toString());
        System.out.println("testContactRetrieveById: FINISH: CREATE");
        // =================================================================================
    }

    public void XtestContactDelete()
    {
        System.out.println("testContactDelete: START");
        // =================================================================================
        ContactLinkEntity contactLink;
        ContactLinkEntity contactLinkGet;
        // =================================================================================
        // ***************************************************************
        long id = 10;
        contactLink = contactLinkRepository.findById(id).orElse(null);
        contactLinkRepository.delete(contactLink);
        contactLinkGet = contactLinkRepository.findById(id).orElse(null);
        assertEquals(null, contactLinkGet);
        // ***************************************************************
        System.out.println("testContactDelete: FINISH: CREATE");
        // =================================================================================
    }

    /*
    public void X_testContactLinkEntityByName() {
    	System.out.println("testContactLinkEntityByName: START");
    	// =================================================================================
    	String interestName1 = "TEST";
    	String interestUuid1 = "AAA";
    	String interestPath1 = "ABC/AAA";
    	ContactLinkEntity interest1 = new ContactLinkEntity();
    	interest1.setContactLinkEntityName(interestName1);
    	interest1.setContactLinkEntityUuid(interestUuid1);
    	interest1.setContactLinkEntityPath(interestPath1);
    	System.out.println("testContactLinkEntityByName: " + interestName1 + " " + interestUuid1 + " " + interestPath1);
    	interest1 = contactLinkRepository.saveContactLinkEntity(interest1);
    	assertNotNull(interest1);
    	// =================================================================================
    	String interestName2 = "TEST";
    	String interestUuid2 = "BBB";
    	String interestPath2 = "ABC/BBB";
    	ContactLinkEntity interest2 = new ContactLinkEntity();
    	interest2.setContactLinkEntityName(interestName2);
    	interest2.setContactLinkEntityUuid(interestUuid2);
    	interest2.setContactLinkEntityPath(interestPath2);
    	System.out.println("testContactLinkEntityByName: " + interestName2 + " " + interestUuid2 + " " + interestPath2);
    	interest2 = contactLinkRepository.saveContactLinkEntity(interest2);
    	assertNotNull(interest2);
    	// =================================================================================
    	String interestName3 = "TEST";
    	String interestUuid3 = "BBB";
    	String interestPath3 = "ABC/BBB";
    	ContactLinkEntity interest3 = new ContactLinkEntity();
    	interest3.setContactLinkEntityName(interestName3);
    	interest3.setContactLinkEntityUuid(interestUuid3);
    	interest3.setContactLinkEntityPath(interestPath3);
    	System.out.println("testContactLinkEntityByName: " + interestName3 + " " + interestUuid3 + " " + interestPath3);
    	interest3 = contactLinkRepository.saveContactLinkEntity(interest3);
    	assertNotNull(interest2);
    	// =================================================================================
    	String interestName = "TEST";
    	List<ContactLinkEntity> interests = contactLinkRepository.getContactLinkEntitysByName(interestName);
    	System.out.println("testContactLinkEntityByName: interests: size=" + interests.size() );
    	assertEquals(3,interests.size());
    	// =================================================================================
    	System.out.println("testContactLinkEntityCRUS: START: DELETE");
    	contactLinkRepository.deleteContactLinkEntity(interest1);
    	contactLinkRepository.deleteContactLinkEntity(interest2);
    	contactLinkRepository.deleteContactLinkEntity(interest3);
    	System.out.println("testContactLinkEntityCRUS: FINISH: DELETE");
    	// =================================================================================
    }
    */

    // @Test
    public void testContactUpdate()
    {
        System.out.println("testContactUpdate: START");
        // =================================================================================
        String updateCity = "Randolph";
        String updateFirstName = "updated_fn";
        String updateLastName = "updated_ln";
        String updatePassword = "updated_pwd";
        String updateUsername = "updated_username";
        // =================================================================================
        ContactLinkEntity contactLink = contactLinkRepository.findById(null).orElse(null);
// assertEquals(contactLink.getAddress1(),address1);
// assertEquals(contactLink.getAddress2(),address2);
// assertEquals(contactLink.getCity(),city);
// assertEquals(contactLink.getCompanyId(),companyId);
// assertEquals(contactLink.getFirstName(),firstName);
// assertEquals(contactLink.getId(),id);
// assertEquals(contactLink.getLastName(),lastName);
// //assertEquals(contactLink.getMiddleName(),middleName);
// assertEquals(contactLink.getPassword(),password);
// assertEquals(contactLink.getPrefix(),prefix);
// assertEquals(contactLink.getState(),state);
// assertEquals(contactLink.getSuffix(),suffix);
// assertEquals(contactLink.getUsername(),username);
// assertEquals(contactLink.getZip(),zip);
        System.out.println("testContactUpdate: " + contactLink.toString());
        // ***************************************************************
// contactLink.setCity(updateCity);
// contactLink.setFirstName(updateFirstName);
// contactLink.setLastName(updateLastName);
// contactLink.setPassword(updatePassword);
// contactLink.setUsername(updateUsername);
// ***************************************************************
        System.out.println("testContactUpdate: START: CREATE");
        contactLink = contactLinkRepository.save(contactLink);
        assertNotNull(contactLink);
// assertEquals(contactLink.getCity(),updateCity);
// assertEquals(contactLink.getFirstName(),updateFirstName);
// assertEquals(contactLink.getLastName(),updateLastName);
// assertEquals(contactLink.getPassword(),updatePassword);
// assertEquals(contactLink.getUsername(),updateUsername);
        System.out.println("testContactUpdate: FINISH: CREATE");
        // =================================================================================
    }

}
