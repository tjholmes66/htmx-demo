package com.tomholmes.product.htmx.demo.htmx;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.service.CompanyService;

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
    public String listCompanys(Model model)
    {
        List<CompanyEntity> companys = companyService.findAllCompanies();
        model.addAttribute("companys", companys);
        return "companys/list";
    }

    @GetMapping("/create")
    public String createCompanyForm(Model model)
    {
        model.addAttribute("company", new CompanyEntity());
        return "companys/create-form";
    }

    @PostMapping("/create")
    public String createCompany(@ModelAttribute CompanyEntity company, Model model)
    {
        companyService.save(company);
        List<CompanyEntity> companys = companyService.findAllCompanies();
        model.addAttribute("companys", companys);
        return "companys/list::companyList";
    }

    @GetMapping("/edit/{id}")
    public String editCompanyForm(@PathVariable Long id, Model model)
    {
        CompanyEntity company = companyService.findById(id);
        model.addAttribute("company", company);
        return "companys/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editCompany(@PathVariable Long id, @ModelAttribute CompanyEntity company, Model model)
    {
        company.setCompanyId(id);
        companyService.save(company);
        List<CompanyEntity> companys = companyService.findAllCompanies();
        model.addAttribute("companys", companys);
        return "companys/list::companyList";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id, Model model)
    {
        companyService.deleteById(id);
        List<CompanyEntity> companys = companyService.findAllCompanies();
        model.addAttribute("companys", companys);
        return "companys/list::companyList";
    }

}
