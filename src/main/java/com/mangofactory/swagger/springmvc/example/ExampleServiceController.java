package com.mangofactory.swagger.springmvc.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("api/examples")
public class ExampleServiceController {

    private static final String EFFECTIVE = "/effective";

    @RequestMapping(value = "/effective", method = RequestMethod.GET)
    public Example getEffective(UriComponentsBuilder builder) {
        return new Example("Hello", 1, Baz.ONE, new Camp("test"));
    }

    @RequestMapping(value = "/effective", method = RequestMethod.POST)
    public void getBare(Example example) {
        //No-op
    }

}
