package com.mangofactory.swagger.springmvc.example;

import org.joda.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

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

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public void updateBaz(Baz baz) {
        //No-op
    }

    @RequestMapping(value = "/date", method = RequestMethod.POST)
    public void updateDate(LocalDate localDate) {
        //No-op
    }

    @RequestMapping(value = "/bigDecimal", method = RequestMethod.POST)
    public void updateBigDecimal(BigDecimal input) {
        //No-op
    }

}
