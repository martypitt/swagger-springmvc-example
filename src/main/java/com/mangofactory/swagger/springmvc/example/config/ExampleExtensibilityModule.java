package com.mangofactory.swagger.springmvc.example.config;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mangofactory.swagger.configuration.ExtensibilityModule;
import com.mangofactory.swagger.models.AlternateTypeProcessingRule;
import com.mangofactory.swagger.models.TypeProcessingRule;
import com.mangofactory.swagger.models.WildcardType;
import com.mangofactory.swagger.springmvc.example.Pet;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import static com.mangofactory.swagger.models.AlternateTypeProcessingRule.*;
import static com.mangofactory.swagger.models.IgnorableTypeRule.*;

public class ExampleExtensibilityModule extends ExtensibilityModule {

    private final ObjectMapper documentationObjectMapper;

    @Autowired
    public ExampleExtensibilityModule(ObjectMapper documentationObjectMapper) {
        this.documentationObjectMapper = documentationObjectMapper;
        this.documentationObjectMapper.addMixInAnnotations(HttpHeaders.class, HttpHeadersMixin.class);
    }

    @Override
    protected void customizeTypeProcessingRules(List<TypeProcessingRule> rules) {
        rules.add(ignorable(UriComponentsBuilder.class));
        rules.add(new AlternateTypeProcessingRule(BigDecimal.class, Double.class));
        rules.add(new AlternateTypeProcessingRule(LocalDate.class, String.class));
        rules.add(new AlternateTypeProcessingRule(DateTime.class, String.class));
        rules.add(responseEntity());
        rules.add(hashmapAlternate(String.class, Pet.class));
    }

    public static AlternateTypeProcessingRule responseEntity() {
        TypeResolver resolver = new TypeResolver();
        return alternate(resolver.resolve(ResponseEntity.class, WildcardType.class),
                resolver.resolve(WildcardType.class));
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
