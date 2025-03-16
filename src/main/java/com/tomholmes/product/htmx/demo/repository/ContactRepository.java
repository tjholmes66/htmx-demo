package com.tomholmes.product.htmx.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.UserEntity;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<ContactEntity, Long>
{

    List<ContactEntity> findByUser(UserEntity user);

    List<ContactEntity> findByUserUserId(Long userId);

}
