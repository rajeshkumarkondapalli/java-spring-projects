package com.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
	@GetMapping("/ping")
	public String ping() {
		return "ping";
	}

	@PostMapping(path = "/parse")
	public String addMember(@RequestBody String value) {
		return value;
	}

}
