package com.mangofactory.swagger.springmvc.example.config;

import com.mangofactory.swagger.OperationComparator;
import com.wordnik.swagger.core.DocumentationOperation;
import org.springframework.stereotype.Component;

@Component
public class NameOperationComparator implements OperationComparator {
    @Override
    public int compare(DocumentationOperation first, DocumentationOperation second) {
        return first.getNickname().compareTo(second.getNickname());
    }
}
