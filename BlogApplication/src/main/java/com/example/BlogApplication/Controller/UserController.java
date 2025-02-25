package com.example.BlogApplication.Controller;

import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogApplication.Model.User;
import com.example.BlogApplication.Service.UserService;

@RestController
@RequestMapping("/bloguser")
public class UserController {
	@Autowired
	UserService service;
	@GetMapping
	List<User> getAllUser(){
		return service.getAllUser();
	}
	@PostMapping
	String addUser(@RequestBody User user) {
		service.addUser(user);
		return "User is added!!";
	}
	
	@GetMapping("/{id}")
	User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	@PutMapping("/{id}")
	String updateUserById(@PathVariable int id , @RequestBody User user) {
		service.updateUserById(id,user);
		return"update successfully!!";
	}
	@DeleteMapping("/{id}")
	String deletUser(@PathVariable int id) {
		service.deletUser(id);
		return "Delete successfully!!";
	}
}
