package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.dto.PositionDTO;
import com.tomholmes.product.htmx.demo.dto.UserDTO;
import com.tomholmes.product.htmx.demo.model.PositionEntity;
import com.tomholmes.product.htmx.demo.model.UserEntity;
import com.tomholmes.product.htmx.demo.repository.PositionRepository;
import com.tomholmes.product.htmx.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo")
public class UserMapperTest
{
    @Autowired
    private UserRepository userRepository; // repository

    @Autowired
    private PositionRepository positionRepository; // repository

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PositionMapper positionMapper;

    private long _userId = 2;
    private boolean _active = true;
    private String _address1 = "123 main street";
    private String _address2 = "Apt. 456";
    private boolean _admin = false;
    private String _dob = "11/03/1966";
    private LocalDate _birthDate = null;
    private String _city = "Randolph";
    private String _firstName = "first_name";
    private String _lastName = "last_name";
    private String _password = "passwd";
    private String _username = "usernm";
    private String _prefix = "Mr.";
    private String _suffix = "Jr.";
    private String _state = "MA";
    private String _zip = "12345-1234";
    private long _positionId = 2;

    private String _email = "test@test.net";
    private String _securityQuestion1 = "Meaning of Life?";
    private String _securityAnswer1 = "42";
    private String _securityQuestion2 = "What city were you born in?";
    private String _securityAnswer2 = "Fall River";

    @Test
    public void entity_To_DTO_whenMaps_thenCorrect() {
        UserEntity entity = new UserEntity();
        entity.setUserId(_userId);
        entity.setActive(_active);
        entity.setFirstName(_firstName);
        entity.setLastName(_lastName);
        entity.setUsername(_username);
        entity.setPassword(_password);
        entity.setSecurityAnswer1(_securityAnswer1);
        entity.setSecurityQuestion1(_securityQuestion1);
        entity.setSecurityAnswer2(_securityAnswer2);
        entity.setSecurityQuestion2(_securityQuestion2);
        entity.setEmail(_email);
        entity.setBirthDate(_birthDate);
        //===========================================================
        PositionEntity positionEntity = positionRepository.findById(_positionId).orElse(null);
        entity.setPosition(positionEntity);
        //===========================================================

        UserDTO userDto = userMapper.entityToDTO(entity);

        assertEquals(entity.getUsername(), userDto.getUsername());
        assertEquals(entity.getFirstName(), userDto.getFirstName());
        assertEquals(entity.getLastName(), userDto.getLastName());
        assertEquals(entity.getPassword(), userDto.getPassword());
        assertEquals(entity.getSecurityAnswer1(), userDto.getSecurityAnswer1());
        assertEquals(entity.getSecurityQuestion1(), userDto.getSecurityQuestion1());
        assertEquals(entity.getSecurityAnswer2(), userDto.getSecurityAnswer2());
        assertEquals(entity.getSecurityQuestion2(), userDto.getSecurityQuestion2());
        assertEquals(entity.getEmail(), userDto.getEmail());
        assertEquals(entity.getBirthDate(), userDto.getBirthDate());
        assertEquals(entity.getPosition().getPositionId(), userDto.getPosition().getPositionId());
    }

    @Test
    public void DTO_To_Entity_whenMaps_thenCorrect() {
        UserDTO dto = new UserDTO();
        dto.setUserId(_userId);
        dto.setActive(_active);
        dto.setFirstName(_firstName);
        dto.setLastName(_lastName);
        dto.setUsername(_username);
        dto.setPassword(_password);
        dto.setSecurityAnswer1(_securityAnswer1);
        dto.setSecurityQuestion1(_securityQuestion1);
        dto.setSecurityAnswer2(_securityAnswer2);
        dto.setSecurityQuestion2(_securityQuestion2);
        dto.setEmail(_email);
        dto.setBirthDate(_birthDate);
        //===========================================================
        PositionEntity positionEntity = positionRepository.findById(_positionId).orElse(null);
        PositionDTO positionDto = positionMapper.entityToDTO(positionEntity);
        dto.setPosition(positionDto);
        //===========================================================

        UserEntity userEntity = userMapper.dtoToEntity(dto);

        assertEquals(dto.getUsername(), userEntity.getUsername());
        assertEquals(dto.getFirstName(), userEntity.getFirstName());
        assertEquals(dto.getLastName(), userEntity.getLastName());
        assertEquals(dto.getPassword(), userEntity.getPassword());
        assertEquals(dto.getSecurityAnswer1(), userEntity.getSecurityAnswer1());
        assertEquals(dto.getSecurityQuestion1(), userEntity.getSecurityQuestion1());
        assertEquals(dto.getSecurityAnswer2(), userEntity.getSecurityAnswer2());
        assertEquals(dto.getSecurityQuestion2(), userEntity.getSecurityQuestion2());
        assertEquals(dto.getEmail(), userEntity.getEmail());
        assertEquals(dto.getBirthDate(), userEntity.getBirthDate());
        assertEquals(dto.getPosition().getPositionId(), userEntity.getPosition().getPositionId());
    }

}
