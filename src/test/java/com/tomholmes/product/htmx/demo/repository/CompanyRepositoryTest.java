package com.tomholmes.product.htmx.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;

@DataJpaTest
// We dont want the H2 in-memory database
// We will provide a custom `test container` as DataSource, don't replace it.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTest
{
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testFindById()
    {
        long companyId = 1;
        CompanyEntity companyEntity = companyRepository.findById(companyId).orElse(null);
        assertNotNull(companyEntity);
    }

    @Test
    public void testFindByCode()
    {
        String companyCode = "IBM";
        List<CompanyEntity> companyRecordList = companyRepository.findByCompanyCode(companyCode);
        assertNotNull(companyRecordList);
    }

    @Test
    public void testFindAll_Entity()
    {
        List<CompanyEntity> companyEntityList = companyRepository.findAll();
        assertNotNull(companyEntityList);
    }

}
