package com.tomholmes.product.htmx.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.model.PositionEntity;
import com.tomholmes.product.htmx.demo.model.UserEntity;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo.services")
@Transactional
public class UserServiceImplTest
{
    @Autowired
    private UserService service;

    @BeforeEach
    public void setUp() throws Exception
    {
        System.out.println("setUp: service: " + service);
    }

    @AfterEach
    public void tearDown()
    {
        service = null;
        System.out.println("tearDown: context set null.");
    }

    private final static long id = 0;
    private final static String email = "tom@tomholmes.new";
    private final static long positionId = 2;
    private final static String firstname = "tom_new";
    private final static String lastname = "holmes_new";
    private final static String username = "user1new";
    private final static String password = "pass1new";
    private final static String securityQuestion1 = "question1";
    private final static String securityQuestion2 = "question2";
    private final static String securityAnswer1 = "answer1";
    private final static String securityAnswer2 = "answer2";

    private UserEntity createUserEntity()
    {
        UserEntity userEntity = new UserEntity();
        // userEntity.setUserId(id);
        userEntity.setActive(true);
        userEntity.setEmail(email);
        PositionEntity position = new PositionEntity();
        position.setId(positionId);
        position.setActive(true);
        userEntity.setPosition(position);
        userEntity.setFirstname(firstname);
        userEntity.setLastname(lastname);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setSecurityQuestion1(securityQuestion1);
        userEntity.setSecurityAnswer1(securityAnswer1);
        userEntity.setSecurityQuestion2(securityQuestion2);
        userEntity.setSecurityAnswer2(securityAnswer2);
        return userEntity;
    }

    @Test
    public void testCreateUser() throws Exception
    {
        UserEntity userEntity = createUserEntity();
        // ==================================================
        UserEntity newUserEntity = service.add(userEntity);
        assertNotNull(newUserEntity);
        if (newUserEntity != null)
        {
            assertEquals(email, newUserEntity.getEmail());
        }
        // ==================================================
    }

    @Test
    public void testFetchById() throws Exception
    {
        long userId = 2;
        // ==================================================
        UserEntity user = service.getUserById(userId);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    // @Test
    public void testUpdateById() throws Exception
    {
        long userId = 6;
        // ==================================================
        String email = "tom@tomholmes.upd";
        Long positionId = 2L;
        String firstname = "tom_upd";
        String lastname = "holmes_upd";
        String username = "user1upd";
        String password = "pass1upd";
        String securityQuestion1 = "question11";
        String securityQuestion2 = "question22";
        String securityAnswer1 = "answer11";
        String securityAnswer2 = "answer22";
        // ==================================================
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setActive(false);
        userEntity.setEmail(email);
        PositionEntity position = new PositionEntity();
        position.setId(positionId);
        position.setActive(true);
        userEntity.setPosition(position);
        userEntity.setFirstname(firstname);
        userEntity.setLastname(lastname);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setSecurityQuestion1(securityQuestion1);
        userEntity.setSecurityAnswer1(securityAnswer1);
        userEntity.setSecurityQuestion2(securityQuestion2);
        userEntity.setSecurityAnswer2(securityAnswer2);
        // ==================================================
        UserEntity user = service.update(userEntity);
        assertNotNull(user);
        if (user != null)
        {
            assertEquals(email, user.getEmail());
            assertEquals(firstname, user.getFirstname());
        }
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }
}
