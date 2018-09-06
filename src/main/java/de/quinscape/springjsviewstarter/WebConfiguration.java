package de.quinscape.springjsviewstarter;

import de.quinscape.spring.jsview.JsViewResolver;
import de.quinscape.spring.jsview.ModelMapProvider;
import de.quinscape.spring.jsview.loader.ResourceLoader;
import de.quinscape.spring.jsview.loader.ServletResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import java.io.IOException;

@Configuration
public class WebConfiguration
    implements WebMvcConfigurer
{
    private final ServletContext servletContext;

    @Autowired
    public WebConfiguration(
        ServletContext servletContext
    )
    {
        this.servletContext = servletContext;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry)
    {
        registry.viewResolver(
            JsViewResolver.newResolver(servletContext, "WEB-INF/template.html")
                .withResourceLoader(resourceLoader())

                .withViewDataProvider(new ModelMapProvider())
                .withViewDataProvider( ctx -> {
                    ctx.provideViewData("contextPath", ctx.getRequest().getContextPath());
                })
                .build()
        );
    }

    @Bean
    public ResourceLoader resourceLoader()
    {
        try
        {
            return new ServletResourceLoader(
                servletContext,
                "/",
                true
            );
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
