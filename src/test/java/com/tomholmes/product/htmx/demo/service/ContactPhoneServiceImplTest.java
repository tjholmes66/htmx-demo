package com.tomholmes.product.htmx.demo.service;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.PhoneTypeEntity;
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
public class ContactPhoneServiceImplTest
{
    @Autowired
    private ContactPhoneService service;

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

    private final static String phone = "111-222-1234";
    private final static long phoneTypeId = 1;

    private ContactPhoneEntity createContactPhoneDto()
    {
        long contactId = 4;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ============================================================
        ContactPhoneEntity contactPhoneDto = new ContactPhoneEntity();
        contactPhoneDto.setContact(contactEntity);
        contactPhoneDto.setPhoneId(id);
        contactPhoneDto.setEnteredDate(enteredDate);
        contactPhoneDto.setPhone(phone);

        PhoneTypeEntity phoneType = new PhoneTypeEntity();
        phoneType.setId(phoneTypeId);
        contactPhoneDto.setPhoneType(phoneType);

        return contactPhoneDto;
    }

    @Test
    public void testCreateContactPhone() throws Exception
    {
        System.out.println("testCreateContactPhone: START");
        ContactPhoneEntity contactPhoneEntity = createContactPhoneDto();
        contactPhoneEntity.setPhoneId(null);
        // ==================================================
        ContactPhoneEntity newContactPhoneEntity = service.createContactPhone(contactPhoneEntity);
        assertNotNull(newContactPhoneEntity);
        assertNotNull(newContactPhoneEntity.getPhoneId());
        // ==================================================
        System.out.println("testCreateContactPhone: FINISH");
    }

    @Test
    public void testDeleteContactPhone() throws Exception
    {
        System.out.println("testDeleteContactPhone: START");
        System.out.println("createContactPhone: START");
        ContactPhoneEntity contactPhoneEntity = createContactPhoneDto();
        contactPhoneEntity.setPhoneId(null);
        // ==================================================
        ContactPhoneEntity newContactPhoneEntity = service.createContactPhone(contactPhoneEntity);
        assertNotNull(newContactPhoneEntity);
        assertNotNull(newContactPhoneEntity.getPhoneId());
        System.out.println("createContactPhone: FINISH");
        // ==================================================
        System.out.println("deleteContactPhone: START");
        service.deleteContactPhone(newContactPhoneEntity);
        System.out.println("deleteContactPhone: FINISH");
        // ==================================================
        System.out.println("testDeleteContactPhone: FINISH");
    }

    @Test
    public void testDeleteContactPhoneById() throws Exception
    {
        System.out.println("testDeleteContactPhone: START");
        System.out.println("createContactPhone: START");
        ContactPhoneEntity contactPhoneEntity = createContactPhoneDto();
        contactPhoneEntity.setPhoneId(null);
        // ==================================================
        ContactPhoneEntity newContactPhoneEntity = service.createContactPhone(contactPhoneEntity);
        assertNotNull(newContactPhoneEntity);
        assertNotNull(newContactPhoneEntity.getPhoneId());
        System.out.println("createContactPhone: FINISH");
        // ==================================================
        System.out.println("deleteContactPhone: START");
        service.deleteContactPhoneById(newContactPhoneEntity.getPhoneId());
        System.out.println("deleteContactPhone: FINISH");
        // ==================================================
        System.out.println("testDeleteContactPhone: FINISH");
    }

    @Test
    public void testRetrievePhonesByContactDto1() throws Exception
    {
        System.out.println("testFetchByContactExample1: START");
        long contactId = 1;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ==================================================
        List<ContactPhoneEntity> contactPhones = service.getAllPhonesByContactId(contactEntity.getContactId());
        ContactPhoneEntity contactPhone = null;
        if (contactPhones != null)
        {
            System.out.println("testFetchByContactExample1: contacts: size=" + contactPhones.size());
            System.out.println("testFetchByContactExample1: contacts=" + contactPhones.toString());

            if (contactPhones.size() > 0)
            {
                contactPhone = contactPhones.get(0);
                System.out.println("testFetchByContactExample1: contactPhone: id=" + contactPhone.getPhoneId());
                System.out.println("testFetchByContactExample1: contactPhone: contactId=" + contactPhone.getContact().getContactId());
                System.out.println("testFetchByContactExample1: contactPhone: phone=" + contactPhone.getPhone());
                System.out.println("testFetchByContactExample1: contactPhone=" + contactPhone.toString());
            }
        }
        assertNotNull(contactPhones);
        // ==================================================
        System.out.println("testFetchByContactExample: FINISH");
    }

    @Test
    public void testRetrievePhonesByContactDto2() throws Exception
    {
        System.out.println("testFetchByContactExample1: START");
        long contactId = 4;
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(contactId);
        // ==================================================
        List<ContactPhoneEntity> contactPhones = service.getAllPhonesByContactId(contactEntity.getContactId());
        ContactPhoneEntity contactPhone = null;
        if (contactPhones != null)
        {
            System.out.println("testFetchByContactExample1: contacts: size=" + contactPhones.size());
            System.out.println("testFetchByContactExample1: contacts=" + contactPhones.toString());

            if (contactPhones.size() > 0)
            {
                contactPhone = contactPhones.get(0);
                System.out.println("testFetchByContactExample1: contactPhone: id=" + contactPhone.getPhoneId());
                System.out.println("testFetchByContactExample1: contactPhone: contactId=" + contactPhone.getContact().getContactId());
                System.out.println("testFetchByContactExample1: contactPhone: phone=" + contactPhone.getPhone());
                System.out.println("testFetchByContactExample1: contactPhone=" + contactPhone.toString());
            }
        }
        assertNotNull(contactPhones);
        // ==================================================
        System.out.println("testFetchByContactExample: FINISH");
    }

    @Test
    public void testFetchById() throws Exception
    {
        System.out.println("testFetchById: START");
        long phoneId = 4;
        // ==================================================
        ContactPhoneEntity contactPhone = service.getPhoneContactById(phoneId);
        System.out.println("testFetchByContactExample: contactPhone: id=" + contactPhone.getPhoneId());
        System.out.println("testFetchByContactExample: contactPhone: contactId=" + contactPhone.getContact().getContactId());
        System.out.println("testFetchByContactExample: contactPhone: phone=" + contactPhone.getPhone());
        System.out.println("contacts=" + contactPhone.toString());
        assertNotNull(contactPhone);
        // ==================================================
        System.out.println("testFetchById: FINISH");
    }

}
