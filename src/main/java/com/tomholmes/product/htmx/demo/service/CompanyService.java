package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.repository.CompanyRepository;

@Service
public class CompanyService
{
    private CompanyRepository companyRepo;

    public CompanyService(CompanyRepository companyRepo)
    {
        this.companyRepo = companyRepo;
    }

    public CompanyEntity getCompanyEntityById(long companyId)
    {
        CompanyEntity companyEntity = companyRepo.findById(companyId).orElse(null);
        return companyEntity;
    }

    public List<CompanyEntity> findAllCompanies()
    {
        return companyRepo.findAll();
    }

    public CompanyEntity save(CompanyEntity companyEntity)
    {
        return companyRepo.save(companyEntity);
    }

    public void deleteById(Long id)
    {
        companyRepo.deleteById(id);
    }

}
