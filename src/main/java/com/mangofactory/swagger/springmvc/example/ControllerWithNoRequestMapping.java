package com.mangofactory.swagger.springmvc.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class ControllerWithNoRequestMapping {
    @RequestMapping(value = "/pets/no-request-mapping", method = RequestMethod.GET)
    public ResponseEntity<Example> exampleWithNoRequestMapping(UriComponentsBuilder builder) {
        return new ResponseEntity<Example>(new Example("Hello", 1, Baz.ONE, new Camp("test")), HttpStatus.OK);
    }
}
