package com.tomholmes.product.htmx.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.tomholmes.product.htmx.demo.dto.ContactDTO;
import com.tomholmes.product.htmx.demo.dto.ContactDataResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.UserEntity;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo.services")
@Transactional
public class ContactServiceImplTest
{
    @Autowired
    private ContactService service;

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

    private ContactEntity createContactEntity()
    {
        long userId = 2;
        UserEntity user = new UserEntity();
        user.setUserId(userId);

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setUser(user);
        contactEntity.setContactId(id);

        contactEntity.setPrefix(prefix);
        contactEntity.setFirstName(firstname);
        contactEntity.setMiddleName(middlename);
        contactEntity.setLastName(lastname);
        contactEntity.setPrefix(suffix);

        contactEntity.setAddress1(address1);
        contactEntity.setAddress2(address2);
        contactEntity.setCity(city);
        contactEntity.setState(state);
        contactEntity.setZip(zip);

        contactEntity.setEnteredBy(enteredBy);
        contactEntity.setEnteredDate(enteredDate);
        contactEntity.setEditedBy(editedBy);
        contactEntity.setEditedDate(editedDate);

        // contactEntity.setCompanyId(companyId);
        contactEntity.setBirthDate(birthDate);

        return contactEntity;
    }

    // public List<ContactEntity> getAllContacts()
    @Test
    public void testGetAllContacts() {
        List<ContactEntity> contacts = service.getAllContacts();
}

    // public List<ContactEntity> getContactsByUserId(long userId)
    @Test
    public void testGetContactsByUserId() {
        long userId = 1;
        List<ContactDTO> contacts = service.getContactsByUserId(userId);
        assertEquals(1, contacts.size());

        userId = 2;
        contacts = service.getContactsByUserId(userId);
        assertEquals(2, contacts.size());

        userId = 3;
        contacts = service.getContactsByUserId(userId);
        assertEquals(2, contacts.size());

        userId = 4;
        contacts = service.getContactsByUserId(userId);
        assertEquals(0, contacts.size());
    }

    // public ContactEntity getContactById(long contactId)
    // public ContactEntity add(ContactEntity newContact)
    // public ContactEntity update(ContactEntity newContact)
    // public void remove(long contactId)

    @Test
    public void testGetContactDataById() {
        Long contactId = 5L;
        ContactDataResponseDTO contactDataResponseDTO = service.getContactDataById(contactId);
        assertNotNull(contactDataResponseDTO);
        assertEquals(3, contactDataResponseDTO.getEmailList().size());
        assertEquals(3, contactDataResponseDTO.getPhoneList().size());
        assertEquals(1, contactDataResponseDTO.getLinkList().size());
    }
}
