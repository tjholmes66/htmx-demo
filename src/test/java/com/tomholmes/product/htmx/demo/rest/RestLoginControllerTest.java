package com.tomholmes.product.htmx.demo.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomholmes.product.htmx.demo.dto.LoginDTO;

@SpringBootTest
@WebAppConfiguration
public class RestLoginControllerTest
{
    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    protected MockHttpSession session;

    @BeforeEach
    public void setUp()
    {
        this.session = new MockHttpSession();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testLoginSuccess() throws Exception
    {
        String username = "demo";
        String password = "demo";
        LoginDTO loginDto = new LoginDTO();
        loginDto.setPassword(password);
        loginDto.setUsername(username);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(loginDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/rest/login").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testLoginFailure() throws Exception
    {
        String username = "tom@tomholmes";
        String password = "password1966!";
        LoginDTO loginDto = new LoginDTO();
        loginDto.setPassword(password);
        loginDto.setUsername(username);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(loginDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/rest/login").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

}
