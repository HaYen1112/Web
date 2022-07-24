package com.example.mypkg.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypkg.dto.ResponseObject;

@RestController
public class AuthController {

	@GetMapping("check-logged")
	public ResponseEntity<?> isLogged(Principal principal) {
		return ResponseEntity.ok().body(new ResponseObject(String.valueOf(HttpStatus.OK), "", principal != null));
	}
}
