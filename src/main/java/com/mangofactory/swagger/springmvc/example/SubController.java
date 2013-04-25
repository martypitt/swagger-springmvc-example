package com.mangofactory.swagger.springmvc.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/suburl")
public class SubController extends BaseController<FancyPet> {

    // some subclass dependency here
    // override one of superclass
    @Override
    public @ResponseBody
    int createObject(@RequestBody FancyPet object) {
        int id = super.createObject(object);
        // do some logic with sub class
        return id;
    }
}
