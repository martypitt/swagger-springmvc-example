package com.mangofactory.swagger.springmvc.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("api/examples")
public class ExampleServiceController {

    private static final String EFFECTIVE = "/effective";

    @RequestMapping(value = "/effective", method = RequestMethod.GET)
    public ResponseEntity<Example> getEffective(UriComponentsBuilder builder) {
        return new ResponseEntity<Example>(new Example("Hello", 1, Baz.ONE, new Camp("test")), HttpStatus.OK);
    }

    @RequestMapping(value = "/effective", method = RequestMethod.POST)
    public void getBare(Example example) {
        //No-op
    }

}
