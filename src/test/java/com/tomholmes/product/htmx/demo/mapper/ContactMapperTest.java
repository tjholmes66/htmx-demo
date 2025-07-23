package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.dto.CompanyDTO;
import com.tomholmes.product.htmx.demo.dto.ContactDTO;
import com.tomholmes.product.htmx.demo.dto.UserDTO;
import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.UserEntity;
import com.tomholmes.product.htmx.demo.repository.CompanyRepository;
import com.tomholmes.product.htmx.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo")
public class ContactMapperTest
{
    @Autowired
    private UserRepository userRepository; //

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private CompanyMapper companyMapper;

    private long _id = 2;
    private boolean _active = true;
    private String _address1 = "123 main street";
    private String _address2 = "Apt. 456";
    private boolean _admin = false;
    private String _dob = "11/03/1966";
    private LocalDate _birthDate = null;
    private String _city = "Randolph";
    private long _companyId = 1;
    private String _firstName = "first_name";
    private String _lastName = "last_name";
    private String _password = "password";
    private String _username = "username";
    private String _prefix = "Mr.";
    private String _suffix = "Jr.";
    private String _state = "MA";
    private String _zip = "12345-1234";

    @Test
    public void entity_To_DTO_whenMaps_thenCorrect() {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactId(_id);
        contactEntity.setAddress1(_address1);
        contactEntity.setAddress2(_address2);
        contactEntity.setBirthDate(_birthDate);
        contactEntity.setCity(_city);
        contactEntity.setFirstName(_firstName);
        contactEntity.setLastName(_lastName);
        contactEntity.setPrefix(_prefix);
        contactEntity.setState(_state);
        contactEntity.setSuffix(_suffix);
        contactEntity.setZip(_zip);
        // ***************************************************************
        CompanyEntity companyEntity = companyRepository.findByCompanyId(_companyId);
        contactEntity.setCompany(companyEntity);
        // ***************************************************************
        long userId = 1;
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        contactEntity.setUser(userEntity);

        ContactDTO contactDto = contactMapper.entityToDTO(contactEntity);

        assertEquals(contactEntity.getCity(), contactDto.getCity());
        assertEquals(contactEntity.getContactId(), contactDto.getContactId());
        assertNotNull(contactDto.getCompany());
        assertEquals(contactDto.getCompany().getCompanyId(), _companyId);
    }

    @Test
    public void DTO_To_Entity_whenMaps_thenCorrect() {
        ContactDTO contactDto = new ContactDTO();
        contactDto.setContactId(_id);
        contactDto.setAddress1(_address1);
        contactDto.setAddress2(_address2);
        contactDto.setBirthDate(_birthDate);
        contactDto.setCity(_city);
        contactDto.setFirstName(_firstName);
        contactDto.setLastName(_lastName);
        contactDto.setPrefix(_prefix);
        contactDto.setState(_state);
        contactDto.setSuffix(_suffix);
        contactDto.setZip(_zip);
        // ***************************************************************
        CompanyEntity companyEntity = companyRepository.findByCompanyId(_companyId);
        CompanyDTO companyDto = companyMapper.entityToDTO(companyEntity);
        contactDto.setCompany(companyDto);
        // ***************************************************************
        long userId = 1;
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        UserDTO userDto = userMapper.entityToDTO(userEntity);
        contactDto.setUser(userDto);

        ContactEntity contactEntity = contactMapper.dtoToEntity(contactDto);

        assertEquals(contactDto.getCity(), contactEntity.getCity());
        assertEquals(contactDto.getContactId(), contactEntity.getContactId());
        assertEquals(contactDto.getUser().getUserId(), contactEntity.getUser().getUserId());
    }

}

