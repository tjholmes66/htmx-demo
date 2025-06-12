package com.tomholmes.product.htmx.demo.service;

import java.util.List;

import com.tomholmes.product.htmx.demo.dto.CompanyDTO;
import com.tomholmes.product.htmx.demo.mapper.CompanyListMapper;
import com.tomholmes.product.htmx.demo.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService
{
    private CompanyRepository companyRepo;
    private CompanyMapper companyMapper;
    private CompanyListMapper companyListMapper;

    public CompanyServiceImpl(CompanyRepository companyRepo, CompanyMapper companyMapper, CompanyListMapper companyListMapper)
    {
        this.companyRepo = companyRepo;
        this.companyMapper = companyMapper;
        this.companyListMapper = companyListMapper;
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
    public CompanyDTO findDtoById(long companyId)
    {
        CompanyEntity companyEntity = companyRepo.findById(companyId).orElse(null);
        CompanyDTO companyDto = companyMapper.entityToDTO(companyEntity);
        return companyDto;
    }

    @Override
    public List<CompanyEntity> findAllCompanies()
    {
        return companyRepo.findAll();
    }

    @Override
    public List<CompanyDTO> getAllCompanys()
    {
        List<CompanyEntity> companyEntityList = companyRepo.findAll();
        List<CompanyDTO> companyDtoList = companyListMapper.entityListToDtoList(companyEntityList);
        return companyDtoList;
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
