package br.com.fwpf.authorizationserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

	@GetMapping("/echo")
	@PreAuthorize("hasAuthority('READY')")
	public String echo() {
		return "Echo";
	}
	
}
