package com.mangofactory.swagger.springmvc.example;

import com.wordnik.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping({"/petgrooming", "/pets/grooming", "/pets"})
@Api(value="", description="Grooming operations for pets")
public class PetGroomingService {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Boolean> canGroom(@RequestParam String type) {
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
    @RequestMapping(value = "voidMethod/{someValue}", method = RequestMethod.DELETE,
            headers = { "Accept=application/xml,application/json" })
    @ResponseStatus(value = HttpStatus.OK, reason = "Just testing")
    public void someFunction(@PathVariable("someValue") String someValue) throws Exception {
    }

}
