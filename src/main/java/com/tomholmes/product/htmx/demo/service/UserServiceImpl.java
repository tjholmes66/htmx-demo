package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.model.UserEntity;
import com.tomholmes.product.htmx.demo.repository.UserRepository;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
    private UserRepository userDao;

    public UserServiceImpl(UserRepository userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public List<UserEntity> getAllUsers()
    {
        List<UserEntity> userList = (List<UserEntity>) userDao.findAll();
        return userList;
    }

    @Override
    public UserEntity getUserById(long userId)
    {
        UserEntity userEntity = userDao.findById(userId).orElse(null);
        return userEntity;
    }

    @Override
    public UserEntity add(UserEntity newUser)
    {
        UserEntity userEntity = userDao.save(newUser);
        return userEntity;
    }

    @Override
    public void remove(UserEntity userEntity)
    {
        userDao.deleteById(userEntity.getUserId());
    }

    @Override
    public void remove(long userId)
    {
        userDao.deleteById(userId);
    }

    @Override
    public UserEntity update(UserEntity newUser)
    {
        UserEntity updatedUserEntity = userDao.save(newUser);
        return updatedUserEntity;
    }
}
