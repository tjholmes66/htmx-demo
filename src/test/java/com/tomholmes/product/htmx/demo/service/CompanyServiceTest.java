package com.tomholmes.product.htmx.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.htmx.demo.HtmxDemoApplication;
import com.tomholmes.product.htmx.demo.model.CompanyEntity;

@SpringBootTest(classes = HtmxDemoApplication.class)
@ComponentScan("com.tomholmes.product.htmx.demo.services")
@Transactional
public class CompanyServiceTest
{
    @Autowired
    private CompanyService service;

    @Test
    public void getCompanyById()
    {
        long companyId = 1;

        CompanyEntity entity = service.findById(companyId);

        assertNotNull(entity);
        assertEquals(companyId, entity.getCompanyId());
    }

    @Test
    public void findAllCompanies()
    {
        List<CompanyEntity> companyEntityList = service.findAllCompanies();
        assertNotNull(companyEntityList);
        assertEquals(1, companyEntityList.size());
    }

}
