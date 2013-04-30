package com.mangofactory.swagger.springmvc.example.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mangofactory.swagger.configuration.ExtensibilityModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class ExampleExtensibilityModule extends ExtensibilityModule {

    private final ObjectMapper documentationObjectMapper;

    @Autowired
    public ExampleExtensibilityModule(ObjectMapper documentationObjectMapper) {
        this.documentationObjectMapper = documentationObjectMapper;
        this.documentationObjectMapper.addMixInAnnotations(HttpHeaders.class, HttpHeadersMixin.class);
    }

    @Override
    protected void customizeIgnorableParameterTypes(List<Class<?>> ignorableParameterTypes) {
        ignorableParameterTypes.add(UriComponentsBuilder.class);
    }

    private class HttpHeadersMixin {
        @JsonIgnore
        public void setIfNoneMatch(List<String> ifNoneMatchList) {
        }

        @JsonIgnore
        public void setLocation(URI uri) {
        }
    }

}
