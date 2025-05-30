package com.tomholmes.product.htmx.demo.graphql;

import com.tomholmes.product.htmx.demo.dto.CompanyDTO;
import com.tomholmes.product.htmx.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/graphql/companys")
public class GraphQLCompanyController {

    /*
    private final CompanyService companyService;

    @Autowired
    public GraphQLCompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }
     */

    @QueryMapping
    public CompanyDTO companyById(@Argument long id) {

        CompanyDTO companyDto = new CompanyDTO();
        companyDto.setCompanyId(id);
        companyDto.setCompanyCode("HOLMES");
        companyDto.setCompanyName("TOM");

        return companyDto;
    }

}
