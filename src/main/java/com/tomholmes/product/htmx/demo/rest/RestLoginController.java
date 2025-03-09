package com.tomholmes.product.htmx.demo.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomholmes.product.htmx.demo.dto.LoginDTO;
import com.tomholmes.product.htmx.demo.model.UserEntity;
import com.tomholmes.product.htmx.demo.service.LoginService;

@RestController
@RequestMapping("/rest/login")
public class RestLoginController
{

    private LoginService service;

    public RestLoginController(LoginService service)
    {
        this.service = service;
    }

    @PostMapping(value = "", produces = "application/json", headers = "content-type=application/json")
    public UserEntity login(@RequestBody LoginDTO loginDto)
    {
        System.out.println("RestLoginController: login: loginDto=" + loginDto);
        UserEntity userEntity = service.login(loginDto);
        System.out.println("RestLoginController: login: user=" + userEntity);
        return userEntity;
    }

}
