package com.tomholmes.product.htmx.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;

@Repository("CompanyRepository")
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>
{
    public CompanyEntity findByCompanyId(long companyId);

    public List<CompanyEntity> findAll();

    List<CompanyEntity> findByCompanyCode(String companyCode);
}
