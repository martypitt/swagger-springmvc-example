package com.mangofactory.swagger.springmvc.example.config;

import com.mangofactory.swagger.EndpointComparator;
import com.wordnik.swagger.core.DocumentationEndPoint;
import org.springframework.stereotype.Component;

@Component
public class NameEndPointComparator implements EndpointComparator {
    @Override
    public int compare(DocumentationEndPoint first, DocumentationEndPoint second) {
        return first.getPath().compareTo(second.getPath());
    }
}
