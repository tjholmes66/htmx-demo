package com.tomholmes.product.htmx.demo.htmx;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.service.CompanyService;

@Controller
public class HomeController
{

    private final CompanyService companyService;

    public HomeController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public String homeTest()
    {
        return "index";
    }

    @PostMapping("/clicked")
    public String clicked(Model model)
    {
        model.addAttribute("now", LocalDateTime.now().toString());
        return "clicked :: result";
    }

    @GetMapping("/test")
    public List<CompanyEntity> home()
    {
        return companyService.findAllCompanies();
    }

}