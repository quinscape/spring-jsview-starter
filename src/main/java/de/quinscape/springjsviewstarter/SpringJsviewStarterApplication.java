package de.quinscape.springjsviewstarter;

import de.quinscape.springjsviewstarter.controller.JsViewController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackageClasses = JsViewController.class)
@Import(WebConfiguration.class)
public class SpringJsviewStarterApplication
    extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(SpringJsviewStarterApplication.class);
    }


    public static void main(String[] args)
    {
        SpringApplication.run(SpringJsviewStarterApplication.class, args);
    }
}
