package com.mangofactory.swagger.springmvc.example.config;

import com.mangofactory.swagger.configuration.ExtensibilityModule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class ExampleExtensibilityModule extends ExtensibilityModule {

    @Override
    protected void customizeIgnorableParameterTypes(List<Class<?>> ignorableParameterTypes) {
        ignorableParameterTypes.add(UriComponentsBuilder.class);
        ignorableParameterTypes.add(ResponseEntity.class);
    }
}
