package com.tomholmes.product.htmx.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.service.CompanyService;

@RestController
@RequestMapping("/companys")
public class RestCompanyController
{
    private final CompanyService companyService;

    public RestCompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<CompanyEntity> getCompanyList1()
    {
        List<CompanyEntity> companyEntityList = companyService.getAllCompanys();
        return companyEntityList;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<CompanyEntity> getCompanyList2()
    {
        List<CompanyEntity> companyEntityList = companyService.getAllCompanys();
        return companyEntityList;
    }

    @RequestMapping(value = "/companyId/{companyId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody CompanyEntity getCompanyById(@PathVariable("companyId") long companyId)
    {
        CompanyEntity companyEntity = companyService.getCompanyById(companyId);
        System.out.println("CompanyController: retrieveCompany: companyEntity=" + companyEntity);
        return companyEntity;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody CompanyEntity createCompany(@RequestBody CompanyEntity company)
    {
        System.out.println("CompanyController: createCompany: company=" + company);
        CompanyEntity companyEntity = companyService.add(company);
        return companyEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody CompanyEntity updateCompany(@RequestBody CompanyEntity company)
    {
        System.out.println("CompanyController: START: updateCompany: company=" + company);
        CompanyEntity companyEntity = companyService.update(company);
        System.out.println("CompanyController: FINISH: updateCompany: companyEntity=" + companyEntity);
        return companyEntity;
    }

    @RequestMapping(value = "/delete/{companyId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public @ResponseBody void deleteCompany(@PathVariable("companyId") long companyId)
    {
        System.out.println("CompanyController: START: deleteCompany: companyId=" + companyId);
        companyService.deleteById(companyId);
        System.out.println("CompanyController: FINISH: deleteCompany:");
    }
}
