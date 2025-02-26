package com.tomholmes.product.htmx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class HtmxDemoApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(HtmxDemoApplication.class, args);
    }

}
