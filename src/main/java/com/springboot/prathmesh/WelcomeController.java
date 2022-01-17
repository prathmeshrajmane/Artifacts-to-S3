package com.springboot.prathmesh;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome to my first spring boot page";
		
	}
}
