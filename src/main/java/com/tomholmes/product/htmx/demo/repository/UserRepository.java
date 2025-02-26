package com.tomholmes.product.htmx.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomholmes.product.htmx.demo.model.UserEntity;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    List<UserEntity> findUserByUsernameAndPassword(String username, String password);

    List<UserEntity> findUserByEmail(String email);

    List<UserEntity> findUserByUsername(String username);

}
