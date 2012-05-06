package com.mangofactory.swagger.springmvc.example;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.core.Api;
import com.wordnik.swagger.core.ApiError;
import com.wordnik.swagger.core.ApiErrors;
import com.wordnik.swagger.core.ApiOperation;

@Controller
@RequestMapping("/users")
@Api(value="", description="Operations about users")
public class UserService {

	@RequestMapping(value="/{petId}",method=RequestMethod.GET)
	@ApiOperation(value = "Find pet by ID", notes = "Returns a pet when ID < 10. "
			+ "ID > 10 or nonintegers will simulate API error conditions", responseClass = "com.wordnik.swagger.sample.model.Pet")
	@ApiErrors(value = { @ApiError(code = 400, reason = "Invalid ID supplied"),
			@ApiError(code = 404, reason = "Pet not found") })
	public List<Pet> getPets()
	{
		return Collections.emptyList();
	}

}
