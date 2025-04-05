package com.tomholmes.product.htmx.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.model.ContactEntity;

@Repository("contactEmailRepository")
public interface ContactEmailRepository extends JpaRepository<ContactEmailEntity, Long>
{

    List<ContactEmailEntity> findByContact(ContactEntity contact);

    List<ContactEmailEntity> findByContactContactId(Long contactId);
}
