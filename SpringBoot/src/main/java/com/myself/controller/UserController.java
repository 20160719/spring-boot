package com.myself.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@GetMapping(value = "/index.action")
	public String index() {
		return "aaa";
	}

}
