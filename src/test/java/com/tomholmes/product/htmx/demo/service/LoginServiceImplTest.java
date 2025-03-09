package com.tomholmes.product.htmx.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.dto.LoginDTO;
import com.tomholmes.product.htmx.demo.model.UserEntity;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo.services")
@Transactional
public class LoginServiceImplTest
{
    @Autowired
    private LoginService service;

    @Test
    public void testFetchByLogin() throws Exception
    {
        String username = "demo";
        String password = "demo";
        // ==================================================
        UserEntity user = service.login(username, password);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    public void testFetchByLoginByDto() throws Exception
    {
        String username = "demo";
        String password = "demo";
        LoginDTO loginDto = new LoginDTO();
        loginDto.setUsername(username);
        loginDto.setPassword(password);
        // ==================================================
        UserEntity user = service.login(loginDto);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    public void testFetchByEmail() throws Exception
    {
        String email = "tom@tomholmes.net";
        // ==================================================
        UserEntity user = service.loginByEmail(email);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }

    @Test
    public void testFetchByUsername() throws Exception
    {
        String username = "demo";
        // ==================================================
        UserEntity user = service.loginByUsername(username);
        assertNotNull(user);
        // ==================================================
        if (user != null)
        {
            System.out.println("users=" + user.toString());
        }
    }
}
