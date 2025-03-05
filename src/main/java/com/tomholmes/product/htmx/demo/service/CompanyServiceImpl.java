package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService
{
    private CompanyRepository companyRepo;

    public CompanyServiceImpl(CompanyRepository companyRepo)
    {
        this.companyRepo = companyRepo;
    }

    // CREATE ==============================================================================

    @Override
    public CompanyEntity ceateNewCompany(CompanyEntity company)
    {
        CompanyEntity companyEntity = companyRepo.saveAndFlush(company);
        return companyEntity;
    }

    @Override
    public CompanyEntity add(CompanyEntity company)
    {
        CompanyEntity companyEntity = companyRepo.saveAndFlush(company);
        return companyEntity;
    }

    // RETRIEVE ============================================================================

    @Override
    public CompanyEntity findById(long companyId)
    {
        CompanyEntity companyEntity = companyRepo.findById(companyId).orElse(null);
        return companyEntity;
    }

    @Override
    public List<CompanyEntity> findAllCompanies()
    {
        return companyRepo.findAll();
    }

    @Override
    public List<CompanyEntity> getAllCompanys()
    {
        return companyRepo.findAll();
    }

    @Override
    public CompanyEntity getCompanyById(long companyId)
    {
        CompanyEntity companyEntity = companyRepo.findById(companyId).orElse(null);
        return companyEntity;
    }

    // UPDATE ==============================================================================

    @Override
    public CompanyEntity save(CompanyEntity companyEntity)
    {
        return companyRepo.save(companyEntity);
    }

    @Override
    public CompanyEntity update(CompanyEntity companyEntity)
    {
        return companyRepo.save(companyEntity);
    }

    // DELETE ==============================================================================

    @Override
    public void deleteById(long companyId)
    {
        companyRepo.deleteById(companyId);
    }

    @Override
    public void remove(long companyId)
    {
        companyRepo.deleteById(companyId);
    }

}
