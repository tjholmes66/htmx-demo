package com.tomholmes.product.htmx.demo.service;

import com.tomholmes.product.htmx.demo.model.UserEntity;

public interface LoginService
{
    UserEntity login(String username, String password);

    UserEntity loginByEmail(String email);

    UserEntity loginByUsername(String username);
}
