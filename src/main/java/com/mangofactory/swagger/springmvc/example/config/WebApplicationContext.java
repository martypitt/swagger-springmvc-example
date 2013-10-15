package com.mangofactory.swagger.springmvc.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Import(RestDocumentationConfig.class)
@EnableWebMvc
@Configuration
public class WebApplicationContext extends WebMvcConfigurerAdapter {
    // Additional stuff to initialize application context

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // map all static resources coming to '/usage/**' to the resource files under the 'swagger' directory
        ResourceHandlerRegistration registration = registry.addResourceHandler("/usage/**");
        registration.addResourceLocations("classpath:swagger/");
    }
}