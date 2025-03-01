package com.tomholmes.product.htmx.demo.htmx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/companys")
public class HtmxCompanyController
{

    private final CompanyService companyService;

    public HtmxCompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping
    public String listCompanies(Model model)
    {
        model.addAttribute("companys", companyService.findAllCompanies());
        return "companys";
    }

    @GetMapping("/new")
    public String newCompanyForm(Model model)
    {
        model.addAttribute("company", new CompanyEntity());
        return "company-form";
    }

    @PostMapping
    public String createCompany(CompanyEntity company, Model model)
    {
        companyService.save(company);
        model.addAttribute("companys", companyService.findAllCompanies());
        return "fragments/company-list :: companyRows";
    }

    @GetMapping("/{id}/edit")
    public String editCompanyForm(@PathVariable Long id, Model model)
    {
        model.addAttribute("company", companyService.getCompanyEntityById(id));
        return "company-form";
    }

    @PutMapping("/{id}")
    public String updateCompany(@PathVariable Long id, CompanyEntity company, Model model)
    {
        company.setCompanyId(id);
        companyService.save(company);
        model.addAttribute("companys", companyService.findAllCompanies());
        return "fragments/company-list :: companyRows";
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id, Model model)
    {
        companyService.deleteById(id);
        model.addAttribute("companys", companyService.findAllCompanies());
        return "fragments/company-list :: companyRows";
    }
}
