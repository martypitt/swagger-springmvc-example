package com.mangofactory.swagger.springmvc.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * <p>Configures the automatic generation of REST documentation.</p>
 */
@Configuration
@Import({ CustomDocumentationConfig.class })
@ComponentScan(basePackages = "com.mangofactory.swagger.springmvc.example",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(Controller.class)
        }
)
public class RestDocumentationConfig implements ServletContextAware {

    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Bean
    public ExampleExtensibilityModule extensibilityModule() {
        //Possibly inject your own preconfigured object mapper here
        return new ExampleExtensibilityModule(new ObjectMapper());
    }

    @Bean
    public PropertyPlaceholderConfigurer swaggerProperties() throws UnknownHostException {

        // Swagger expects these to property values to be replaced. We don't want to propagate these to consumers of
        // this configuration, so we derive reasonable defaults here and configure the properties programmatically.
        Properties properties = new Properties();
        properties.setProperty("documentation.services.basePath", servletContext.getContextPath());
        // this property will be overridden at runtime, so the value here doesn't matter
        properties.setProperty("documentation.services.version", "ignored");

        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setProperties(properties);
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

}