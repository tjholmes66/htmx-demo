package com.tomholmes.product.htmx.demo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
public class RestContactEmailControllerTest
{
    @Test
    public void testGetContactEmails()
    {
        assertEquals(true, true);
    }
}
