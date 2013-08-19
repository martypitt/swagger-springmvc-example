package com.mangofactory.swagger.springmvc.example;

import com.wordnik.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/petgrooming", "/pets/grooming", "/pets"})
@Api(value="", description="Grooming operations for pets")
public class PetGroomingService {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Boolean> canGroom(@RequestParam String type) {
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
}
