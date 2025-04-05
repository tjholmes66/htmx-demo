package com.tomholmes.product.htmx.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;

@Repository("contactPhoneRepository")
public interface ContactPhoneRepository extends JpaRepository<ContactPhoneEntity, Long>
{

    List<ContactPhoneEntity> findByContact(ContactEntity contact);

    List<ContactPhoneEntity> findByContactContactId(Long contactId);

}
