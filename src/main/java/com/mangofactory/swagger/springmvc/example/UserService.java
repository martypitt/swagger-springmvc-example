package com.mangofactory.swagger.springmvc.example;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.mangofactory.swagger.ApiError;
import com.mangofactory.swagger.ApiErrors;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/users")
@Api(value="", description="Operations about users")
public class UserService {

	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "List all users")
	public @ResponseBody List<User> listPets()
	{
		return Lists.newArrayList();
	}

	@RequestMapping(value="/{userId}",method=RequestMethod.GET)
	@ApiOperation(value = "Find user by ID")
	@ApiErrors(errors = { @ApiError(code = 400, reason = "Invalid ID supplied"),
			@ApiError(code = 404, reason = "Pet not found") })
	public User getPets()
	{
		return new User();
	}

}
