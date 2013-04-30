package com.mangofactory.swagger.springmvc.example;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class PetResource extends ResourceSupport {
    private String name;
    private int age;
}
