package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;

public interface CompanyService
{

    List<CompanyEntity> getAllCompanys();

    CompanyEntity getCompanyById(long contactId);

    CompanyEntity add(CompanyEntity newCompany);

    CompanyEntity update(CompanyEntity newCompany);

    void remove(long contactId);

    void deleteById(long companyId);

    CompanyEntity ceateNewCompany(CompanyEntity company);

    CompanyEntity findById(long companyId);

    List<CompanyEntity> findAllCompanies();

    CompanyEntity save(CompanyEntity companyEntity);

}
