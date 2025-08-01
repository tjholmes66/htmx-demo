package com.tomholmes.product.htmx.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import com.tomholmes.product.htmx.demo.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactRepositoryTest extends BaseRepositoryTests
{
    @Autowired
    private ContactRepository contactRepository; // repository

    @Autowired
    private UserRepository userRepository; // repository

    @Autowired
    private CompanyRepository companyRepository; // repository

    private long _id = 2;
    private boolean _active = true;
    private String _address1 = "123 main street";
    private String _address2 = "Apt. 456";
    private boolean _admin = false;
    private String _dob = "11/03/1966";
    private LocalDate _birthDate = null;
    private String _city = "Randolph";
    private Long _companyId = null;
    private String _firstName = "first_name";
    private String _lastName = "last_name";
    private String _password = "password";
    private String _username = "username";
    private String _prefix = "Mr.";
    private String _suffix = "Jr.";
    private String _state = "MA";
    private String _zip = "12345-1234";

    private HashSet<ContactEmailEntity> createEmails(ContactEntity contact)
    {
        HashSet<ContactEmailEntity> emails = new HashSet<ContactEmailEntity>();
        System.out.println("createEmails: START");
        ContactEmailEntity contactEmail = null;
        // ============================================================
        String email1 = "tom1@tomholmes1.net";
        EmailTypeEntity emailType1 = new EmailTypeEntity();
        emailType1.setId(1L);
        contactEmail = new ContactEmailEntity();
        contactEmail.setContact(contact);
        contactEmail.setEmail(email1);
        contactEmail.setEnteredDate(LocalDateTime.now());
        contactEmail.setEmailType(emailType1);
        emails.add(contactEmail);
        // **********************************************
        String email2 = "tom2@tomholmes2.net";
        EmailTypeEntity emailType2 = new EmailTypeEntity();
        emailType2.setId(2L);
        contactEmail = new ContactEmailEntity();
        contactEmail.setContact(contact);
        contactEmail.setEmail(email2);
        contactEmail.setEnteredDate(LocalDateTime.now());
        contactEmail.setEmailType(emailType2);
        emails.add(contactEmail);
        // **********************************************
        String email3 = "tom3@tomholmes3.net";
        EmailTypeEntity emailType3 = new EmailTypeEntity();
        emailType3.setId(3L);
        contactEmail = new ContactEmailEntity();
        contactEmail.setContact(contact);
        contactEmail.setEmail(email3);
        contactEmail.setEnteredDate(LocalDateTime.now());
        contactEmail.setEmailType(emailType3);
        emails.add(contactEmail);
        // ============================================================
        System.out.println("createEmails: FINISH");
        return emails;
    }

    private HashSet<ContactPhoneEntity> createPhones(ContactEntity contactEntity)
    {
        HashSet<ContactPhoneEntity> phones = new HashSet<ContactPhoneEntity>();
        System.out.println("createPhones: START");
        ContactPhoneEntity contactPhone = null;
        // ============================================================
        PhoneTypeEntity phoneType1 = new PhoneTypeEntity();
        phoneType1.setId(1L);
        contactPhone = new ContactPhoneEntity();
        contactPhone.setContact(contactEntity);
        contactPhone.setEnteredDate(LocalDateTime.now());
        contactPhone.setPhone("111-111-1111");
        contactPhone.setPhoneId(0L);
        contactPhone.setPhoneType(phoneType1);
        phones.add(contactPhone);
        // ============================================================
        PhoneTypeEntity phoneType2 = new PhoneTypeEntity();
        phoneType2.setId(2L);
        contactPhone = new ContactPhoneEntity();
        contactPhone.setContact(contactEntity);
        contactPhone.setEnteredDate(LocalDateTime.now());
        contactPhone.setPhone("222-222-2222");
        contactPhone.setPhoneId(0L);
        contactPhone.setPhoneType(phoneType2);
        phones.add(contactPhone);
        // ============================================================
        PhoneTypeEntity phoneType3 = new PhoneTypeEntity();
        phoneType3.setId(3L);
        contactPhone = new ContactPhoneEntity();
        contactPhone.setContact(contactEntity);
        contactPhone.setEnteredDate(LocalDateTime.now());
        contactPhone.setPhone("333-333-3333");
        contactPhone.setPhoneId(0L);
        contactPhone.setPhoneType(phoneType3);
        phones.add(contactPhone);
        // ============================================================
        System.out.println("createEmails: FINISH");
        return phones;
    }

    @Test
    public void testContactFetchByUser() throws Exception
    {
        System.out.println("testContactFetchByUser: START");
        UserEntity user = new UserEntity();
        user.setUserId(1L);

        List<ContactEntity> contactList = contactRepository.findByUser(user);
        assertNotNull(contactList);
        assertEquals(1, contactList.size());

        user = new UserEntity();
        user.setUserId(2L);
        contactList = contactRepository.findByUser(user);
        assertEquals(2, contactList.size());

        user = new UserEntity();
        user.setUserId(3L);
        contactList = contactRepository.findByUser(user);
        assertEquals(3, contactList.size());

        System.out.println("testContactFetchByUser: FINISH");
    }

    @Test
    public void testContactFetchByUserId() throws Exception
    {
        System.out.println("testContactFetchByUserId: START");

        List<ContactEntity> contactList = contactRepository.findByUserUserId(1L);
        assertNotNull(contactList);
        assertEquals(1, contactList.size());

        contactList = contactRepository.findByUserUserId(2L);
        assertEquals(2, contactList.size());

        contactList = contactRepository.findByUserUserId(3L);
        assertEquals(3, contactList.size());

        System.out.println("testContactFetchByUser: FINISH");
    }

    @Test
    public void testContactCreate() throws Exception
    {
        System.out.println("testContactCreate: START");
        // =================================================================================
        ContactEntity contact = new ContactEntity();
        // contact.setContactId(0L);
        contact.setAddress1(_address1);
        contact.setAddress2(_address2);
        contact.setBirthDate(_birthDate);
        contact.setCity(_city);
        contact.setFirstName(_firstName);
        contact.setLastName(_lastName);
        contact.setPrefix(_prefix);
        contact.setState(_state);
        contact.setSuffix(_suffix);
        contact.setZip(_zip);
        // ***************************************************************
        CompanyEntity companyEntity = companyRepository.findByCompanyId(1);
        contact.setCompany(companyEntity);
        // ***************************************************************
        long userId = 1;
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        contact.setUser(userEntity);
        // ***************************************************************
        // contact.setEmails(createEmails(contact));
        // contact.setPhones(createPhones(contact));
        // ***************************************************************
        System.out.println("testContactCreate: " + contact.toString());
        // ***************************************************************
        System.out.println("testContactCreate: START: CREATE");
        contact = contactRepository.saveAndFlush(contact);
        assertNotNull(contact);
        System.out.println("testContactCreate: FINISH: CREATE");
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
        List<ContactEntity> contacts = (List<ContactEntity>) contactRepository.findAll();
        assertNotNull(contacts);
        for (ContactEntity contact : contacts)
        {
            assertNotNull(contact.getContactId());
            // ************************************************************
// assertEquals(contact.getAddress1(),address1);
// assertEquals(contact.getAddress2(),address2);
// assertEquals(contact.getCity(),city);
// assertEquals(contact.getCompanyId(),companyId);
// assertEquals(contact.getFirstName(),firstName);
// assertEquals(contact.getId(),id);
// assertEquals(contact.getLastName(),lastName);
// //assertEquals(contact.getMiddleName(),middleName);
// assertEquals(contact.getPassword(),password);
// assertEquals(contact.getPrefix(),prefix);
// assertEquals(contact.getState(),state);
// assertEquals(contact.getSuffix(),suffix);
// assertEquals(contact.getUsername(),username);
// assertEquals(contact.getZip(),zip);
// ************************************************************
            System.out.println("testContactRetrieve: contact=" + contact.toString());
        }
        System.out.println("testContactRetrieve: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testContactRetrieveById()
    {
        System.out.println("testContactRetrieveById: START");
        // =================================================================================
        long contactId = 2;
        String address1 = "123 main street";
        String address2 = "Apt. 456";
        String city = "Randolph";
        long companyId = 23;
        String prefix = "Mr.";
        String suffix = "Jr.";
        String state = "MA";
        String zip = "12345-1234";
        // =================================================================================
        // ***************************************************************
        System.out.println("testContactRetrieveById: START: CREATE");
        ContactEntity contact = contactRepository.findById(contactId).orElse(null);
        ;
        assertNotNull(contact.getContactId());
        // ************************************************************
        assertEquals(contact.getAddress1(), address1);
        assertEquals(contact.getAddress2(), address2);
        assertEquals(contact.getCity(), city);
        assertEquals(contact.getCompany().getCompanyId(), companyId);
        // assertEquals(contact.getFirstName(),firstName);
        assertEquals(contact.getContactId(), contactId);
        // assertEquals(contact.getLastName(),lastName);
        // assertEquals(contact.getMiddleName(),middleName);
        // assertEquals(contact.getPassword(),password);
        assertEquals(contact.getPrefix(), prefix);
        assertEquals(contact.getState(), state);
        assertEquals(contact.getSuffix(), suffix);
        // assertEquals(contact.getUsername(),username);
        // assertEquals(contact.getZip(), zip);
        // assertEquals(3, contact.getEmails().size());
        // assertEquals(3, contact.getPhones().size());
        // assertEquals(0, contact.getLinks().size());
        // ************************************************************
        System.out.println("testContactRetrieveById: contact=" + contact.toString());
        System.out.println("testContactRetrieveById: FINISH: CREATE");
        // =================================================================================
    }

    @Test
    public void testContactDelete()
    {
        System.out.println("testContactDelete: START");
        long contactId = 6;
        // =================================================================================
        // ContactEntity contactEntity = contactRepository.getContactEntity(contactId);
        // assertNotNull(contactEntity);
        // System.out.println("testContactDelete: " + contactEntity.toString());
        // =================================================================================
        contactRepository.deleteById(contactId);
        System.out.println("testContactDelete: contact deleted");
        // =================================================================================
        ContactEntity contact = contactRepository.findById(contactId).orElse(null);
        assertEquals(contact, null);
        // ***************************************************************
        System.out.println("testContactDelete: FINISH");
        // =================================================================================
    }

    /*
    public void X_testContactEntityByName() {
    	System.out.println("testContactEntityByName: START");
    	// =================================================================================
    	String interestName1 = "TEST";
    	String interestUuid1 = "AAA";
    	String interestPath1 = "ABC/AAA";
    	ContactEntity interest1 = new ContactEntity();
    	interest1.setContactEntityName(interestName1);
    	interest1.setContactEntityUuid(interestUuid1);
    	interest1.setContactEntityPath(interestPath1);
    	System.out.println("testContactEntityByName: " + interestName1 + " " + interestUuid1 + " " + interestPath1);
    	interest1 = contactRepository.saveContactEntity(interest1);
    	assertNotNull(interest1);
    	// =================================================================================
    	String interestName2 = "TEST";
    	String interestUuid2 = "BBB";
    	String interestPath2 = "ABC/BBB";
    	ContactEntity interest2 = new ContactEntity();
    	interest2.setContactEntityName(interestName2);
    	interest2.setContactEntityUuid(interestUuid2);
    	interest2.setContactEntityPath(interestPath2);
    	System.out.println("testContactEntityByName: " + interestName2 + " " + interestUuid2 + " " + interestPath2);
    	interest2 = contactRepository.saveContactEntity(interest2);
    	assertNotNull(interest2);
    	// =================================================================================
    	String interestName3 = "TEST";
    	String interestUuid3 = "BBB";
    	String interestPath3 = "ABC/BBB";
    	ContactEntity interest3 = new ContactEntity();
    	interest3.setContactEntityName(interestName3);
    	interest3.setContactEntityUuid(interestUuid3);
    	interest3.setContactEntityPath(interestPath3);
    	System.out.println("testContactEntityByName: " + interestName3 + " " + interestUuid3 + " " + interestPath3);
    	interest3 = contactRepository.saveContactEntity(interest3);
    	assertNotNull(interest2);
    	// =================================================================================
    	String interestName = "TEST";
    	List<ContactEntity> interests = contactRepository.getContactEntitysByName(interestName);
    	System.out.println("testContactEntityByName: interests: size=" + interests.size() );
    	assertEquals(3,interests.size());
    	// =================================================================================
    	System.out.println("testContactEntityCRUS: START: DELETE");
    	contactRepository.deleteContactEntity(interest1);
    	contactRepository.deleteContactEntity(interest2);
    	contactRepository.deleteContactEntity(interest3);
    	System.out.println("testContactEntityCRUS: FINISH: DELETE");
    	// =================================================================================
    }
    */

    @Test
    public void testContactUpdate()
    {
        System.out.println("testContactUpdate: START");
        long contactId = 4;
        // =================================================================================
        String updateCity = "upd_Randolph4";
        String updateFirstName = "updated_fn4";
        String updateLastName = "updated_ln4";
        String updatePassword = "updated_pwd4";
        String updateUsername = "updated_username4";
        // =================================================================================
        ContactEntity contact = contactRepository.findById(contactId).orElse(null);
        ;
// assertEquals(contact.getAddress1(),address1);
// assertEquals(contact.getAddress2(),address2);
// assertEquals(contact.getCity(),city);
// assertEquals(contact.getCompanyId(),companyId);
// assertEquals(contact.getFirstName(),firstName);
// assertEquals(contact.getId(),id);
// assertEquals(contact.getLastName(),lastName);
// //assertEquals(contact.getMiddleName(),middleName);
// assertEquals(contact.getPassword(),password);
// assertEquals(contact.getPrefix(),prefix);
// assertEquals(contact.getState(),state);
// assertEquals(contact.getSuffix(),suffix);
// assertEquals(contact.getUsername(),username);
// assertEquals(contact.getZip(),zip);
        System.out.println("testContactUpdate: " + contact.toString());
        // ***************************************************************
        contact.setCity(updateCity);
        contact.setFirstName(updateFirstName);
        contact.setLastName(updateLastName);
        // ***************************************************************

        contact = contactRepository.save(contact);
        assertNotNull(contact);
        assertEquals(contact.getCity(), updateCity);
        assertEquals(contact.getFirstName(), updateFirstName);
        assertEquals(contact.getLastName(), updateLastName);
        System.out.println("testContactUpdate: FINISH: CREATE");
        // =================================================================================
    }

}
