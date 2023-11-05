package com.assignment.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class LoginController {

	@GetMapping("/index")
	public String welcome() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
