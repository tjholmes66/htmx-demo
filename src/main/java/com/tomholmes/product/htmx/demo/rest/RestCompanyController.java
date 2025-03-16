package com.tomholmes.product.htmx.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.service.CompanyService;

@RestController
@RequestMapping("/rest/companys")
@CrossOrigin(origins = "*")
public class RestCompanyController
{
    private final CompanyService companyService;

    public RestCompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping(value = "", headers = "Accept=application/json")
    public List<CompanyEntity> getCompanyList1()
    {
        List<CompanyEntity> companyEntityList = companyService.getAllCompanys();
        return companyEntityList;
    }

    @GetMapping(value = "/", headers = "Accept=application/json")
    public @ResponseBody List<CompanyEntity> getCompanyList2()
    {
        List<CompanyEntity> companyEntityList = companyService.getAllCompanys();
        return companyEntityList;
    }

    @GetMapping(value = "/companyId/{companyId}", headers = "Accept=application/json")
    public @ResponseBody CompanyEntity getCompanyById(@PathVariable("companyId") long companyId)
    {
        CompanyEntity companyEntity = companyService.getCompanyById(companyId);
        System.out.println("CompanyController: retrieveCompany: companyEntity=" + companyEntity);
        return companyEntity;
    }

    @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody CompanyEntity createCompany(@RequestBody CompanyEntity company)
    {
        System.out.println("CompanyController: createCompany: company=" + company);
        CompanyEntity companyEntity = companyService.add(company);
        return companyEntity;
    }

    @PutMapping(value = "/update", produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody CompanyEntity updateCompany(@RequestBody CompanyEntity company)
    {
        System.out.println("CompanyController: START: updateCompany: company=" + company);
        CompanyEntity companyEntity = companyService.update(company);
        System.out.println("CompanyController: FINISH: updateCompany: companyEntity=" + companyEntity);
        return companyEntity;
    }

    @DeleteMapping(value = "/delete/{companyId}", headers = "Accept=application/json")
    public @ResponseBody void deleteCompany(@PathVariable("companyId") long companyId)
    {
        System.out.println("CompanyController: START: deleteCompany: companyId=" + companyId);
        companyService.deleteById(companyId);
        System.out.println("CompanyController: FINISH: deleteCompany:");
    }
}
