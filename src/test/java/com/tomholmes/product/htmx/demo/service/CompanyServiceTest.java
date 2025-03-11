package com.tomholmes.product.htmx.demo.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

    // CREATE ==================================================================================

    @Test
    // CompanyEntity add(CompanyEntity newCompany);
    public void testAdd()
    {
        long id = 0;
        Boolean active = true;
        String address1 = "123 Main Street";
        String city = "Boston";
        String companyCode = "code";
        String companyName = "name";
        String description = "my company description";
        String state = "MA";
        String zip = "12345";

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setAddress1(address1);
        companyEntity.setCity(city);
        companyEntity.setCompanyCode(companyCode);
        companyEntity.setCompanyName(companyName);
        companyEntity.setDescription(description);
        companyEntity.setState(state);
        companyEntity.setZip(zip);
        companyEntity.setActive(active);

        CompanyEntity newCompany = service.add(companyEntity);
        assertNotNull(newCompany);
        assertEquals(true, newCompany.getCompanyId() > 1);
        assertNotEquals(0, newCompany.getCompanyId());
        assertEquals(city, newCompany.getCity());
    }

    @Test
    // CompanyEntity ceateNewCompany(CompanyEntity company);
    public void testCeateNewCompany()
    {
        long id = 0;
        Boolean active = true;
        String address1 = "123 Main Street";
        String city = "Boston";
        String companyCode = "code";
        String companyName = "name";
        String description = "my company description";
        String state = "MA";
        String zip = "12345";

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setAddress1(address1);
        companyEntity.setCity(city);
        companyEntity.setCompanyCode(companyCode);
        companyEntity.setCompanyName(companyName);
        companyEntity.setDescription(description);
        companyEntity.setState(state);
        companyEntity.setZip(zip);
        companyEntity.setActive(active);

        CompanyEntity newCompany = service.add(companyEntity);
        assertNotNull(newCompany);
        assertEquals(true, newCompany.getCompanyId() > 1);
        assertNotEquals(0, newCompany.getCompanyId());
        assertEquals(city, newCompany.getCity());
        assertEquals(active, newCompany.getActive());
    }

    // RETRIEVE ================================================================================

    @Test
    // CompanyEntity testGetCompanyById(long contactId);
    public void getCompanyById()
    {
        long companyId = 1;
        CompanyEntity entity = service.findById(companyId);
        assertNotNull(entity);
        assertEquals(companyId, entity.getCompanyId());
    }

    @Test
    // CompanyEntity findById(long companyId);
    public void testFindById()
    {
        long companyId = 1;
        CompanyEntity entity = service.findById(companyId);
        assertNotNull(entity);
        assertEquals(companyId, entity.getCompanyId());
    }

    @Test
    // List<CompanyEntity> findAllCompanies();
    public void findAllCompanies()
    {
        List<CompanyEntity> companyEntityList = service.findAllCompanies();
        assertNotNull(companyEntityList);
        assertEquals(true, companyEntityList.size() >= 1);
    }

    @Test
    // List<CompanyEntity> getAllCompanys();
    public void testGetAllCompanys()
    {
        List<CompanyEntity> companyEntityList = service.findAllCompanies();
        assertNotNull(companyEntityList);
        assertEquals(true, companyEntityList.size() >= 1);
    }

    // UPDATE ==================================================================================

    @Test
    // CompanyEntity update(CompanyEntity oldCompany);
    public void testUpdate()
    {
        long companyId = 1;
        CompanyEntity companyEntity = service.findById(companyId);
        assertNotNull(companyEntity);
        assertEquals(companyId, companyEntity.getCompanyId());

        String address1 = "123 Main Street";
        String city = "Boston";
        String companyCode = "code";
        String companyName = "name";
        String description = "my company description";
        String state = "MA";
        String zip = "12345";

        companyEntity.setAddress1(address1);
        companyEntity.setCity(city);
        companyEntity.setCompanyCode(companyCode);
        companyEntity.setCompanyName(companyName);
        companyEntity.setDescription(description);
        companyEntity.setState(state);
        companyEntity.setZip(zip);

        CompanyEntity company = service.update(companyEntity);
        assertNotNull(company);
        assertEquals(1L, company.getCompanyId());
        assertEquals(city, company.getCity());
    }

    @Test
    // CompanyEntity save(CompanyEntity companyEntity);
    public void testSave()
    {
        long companyId = 1;
        CompanyEntity companyEntity = service.findById(companyId);
        assertNotNull(companyEntity);
        assertEquals(companyId, companyEntity.getCompanyId());

        String address1 = "123 Main Street";
        String city = "Boston";
        String companyCode = "code";
        String companyName = "name";
        String description = "my company description";
        String state = "MA";
        String zip = "12345";

        companyEntity.setAddress1(address1);
        companyEntity.setCity(city);
        companyEntity.setCompanyCode(companyCode);
        companyEntity.setCompanyName(companyName);
        companyEntity.setDescription(description);
        companyEntity.setState(state);
        companyEntity.setZip(zip);

        CompanyEntity company = service.update(companyEntity);
        assertNotNull(company);
        assertEquals(1L, company.getCompanyId());
        assertEquals(city, company.getCity());
    }

    // DELETED =================================================================================

    @Test
    // void remove(long contactId);
    public void testRemove()
    {
        long companyId = 1;
        service.remove(companyId);
        CompanyEntity companyEntity = service.findById(companyId);
        assertNull(companyEntity);
    }

    @Test
    // void deleteById(long companyId);
    public void testDeleteById()
    {
        long companyId = 1;
        service.deleteById(companyId);
        CompanyEntity companyEntity = service.findById(companyId);
        assertNull(companyEntity);
    }

}
