package br.com.fwpf.authorizationserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

	@GetMapping("/echo")
	public String echo() {
		return "Echo";
	}
	
}
