package com.tomholmes.product.htmx.demo.mapper;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.dto.CompanyDTO;
import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo")
public class CompanyListMapperTest {

    @Autowired
    private CompanyRepository companyRepository; // repository

    @Autowired
    private CompanyListMapper companyListMapper;

    @Test
    public void testDtoListToEntityList() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll();
        assertNotNull(companyEntityList);
        assertEquals(4, companyEntityList.size());

        List<CompanyDTO> companyDTOList = companyListMapper.entityListToDtoList(companyEntityList);
        assertNotNull(companyDTOList);
        assertEquals(4, companyDTOList.size());

        companyEntityList = companyListMapper.dtoListToEntityList(companyDTOList);
        assertNotNull(companyDTOList);
        assertEquals(4, companyDTOList.size());
    }

    @Test
    public void testEntityListToDtoList() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll();
        assertNotNull(companyEntityList);
        assertEquals(4, companyEntityList.size());

        List<CompanyDTO> companyDTOList = companyListMapper.entityListToDtoList(companyEntityList);
        assertNotNull(companyDTOList);
        assertEquals(4, companyDTOList.size());
    }

}
