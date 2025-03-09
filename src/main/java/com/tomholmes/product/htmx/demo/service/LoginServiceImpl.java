package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.model.UserEntity;
import com.tomholmes.product.htmx.demo.repository.UserRepository;

@Transactional
@Service("loginService")
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private UserRepository userDao;

    @Override
    public UserEntity login(String username, String password)
    {
        List<UserEntity> userEntitys = userDao.findUserByUsernameAndPassword(username, password);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

    @Override
    public UserEntity loginByEmail(String email)
    {
        List<UserEntity> userEntitys = userDao.findUserByEmail(email);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

    @Override
    public UserEntity loginByUsername(String username)
    {
        List<UserEntity> userEntitys = userDao.findUserByUsername(username);
        UserEntity userEntity = null;
        if (userEntitys != null && userEntitys.size() > 0)
        {
            userEntity = userEntitys.get(0);
        }
        return userEntity;
    }

}