package com.tomholmes.product.htmx.demo.repository;

import java.util.List;

import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;

@Repository("contactLinkRepository")
public interface ContactLinkRepository extends JpaRepository<ContactLinkEntity, Long>
{

    List<ContactLinkEntity> findByContact(ContactEntity contact);

    List<ContactLinkEntity> findByContactContactId(Long contactId);

}
