package com.tomholmes.product.htmx.demo.graphql;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(GraphQLCompanyController.class)
public class GraphQLCompanyControllerTest {

    @Autowired
    private GraphQlTester tester;

}
