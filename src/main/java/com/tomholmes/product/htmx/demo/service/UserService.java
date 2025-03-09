package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import com.tomholmes.product.htmx.demo.model.UserEntity;

public interface UserService
{

    // CREATE ==============================================================

    UserEntity add(UserEntity userEntity);

    // RETRIEVE ============================================================

    public List<UserEntity> getAllUsers();

    UserEntity getUserById(long userId);

    // UPDATE ==============================================================

    UserEntity update(UserEntity userEntity);

    // DELETE ==============================================================

    void remove(UserEntity record);

    void remove(long userId);
}
