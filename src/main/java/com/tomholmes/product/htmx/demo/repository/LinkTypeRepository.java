package com.tomholmes.product.htmx.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomholmes.product.htmx.demo.model.LinkTypeEntity;


@Repository("linkTypeRepository")
public interface LinkTypeRepository extends JpaRepository<LinkTypeEntity, Long>
{

}