package com.tomholmes.product.htmx.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomholmes.product.htmx.demo.model.PhoneTypeEntity;


@Repository("phoneTypeRepository")
public interface PhoneTypeRepository extends JpaRepository<PhoneTypeEntity, Long>
{

}
