package com.classconnect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.classconnect.model.UserRegister;
import com.classconnect.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	UserService service;
	
	
	@PostMapping("/register")
	public UserRegister register(@RequestBody UserRegister userRegister) {
		return service.register(userRegister);
	}
	
	@GetMapping("/getUser")
	public Optional<UserRegister> getUser(@RequestParam Long id) {
		return service.getUser(id);
	}
	
	@GetMapping("/getAllUser")
	public List<UserRegister> getAllUser(){
		return service.getAllUser();
	}

	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam Long id) {
		return ResponseEntity.ok(service.deleteUserById(id));
	}
	
	@PutMapping("/updateInfo")
	public ResponseEntity<?> updateInfo(@RequestBody UserRegister register) {
		return service.UpdateInfo(register);
		
	}
	
}
