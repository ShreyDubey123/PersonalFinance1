package com.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entity.User;
import com.app.entity.UserRegistry;
import com.app.service.UserService;

import jakarta.servlet.http.HttpSession;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

//	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody UserRegistry user) {
//    	logger.debug("Received request to create user: {}", user);
    	
        return ResponseEntity.ok(userService.saveUser(user));
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserRegistry user, HttpSession session) {
//    	logger.debug("Received request to create user: {}", user);
    	User u = userService.loginUser(user);
    	if( u == null)
        return ResponseEntity.badRequest().build();
    	else {
    		HttpHeaders headers = new HttpHeaders();
    		Integer id = u.getUserId();
            headers.add("user", id.toString());
    		session.setAttribute("userId", u.getUserId());
    		return new ResponseEntity<>(u, headers, HttpStatus.OK);
    	}
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user")
    public User getUserById(HttpSession session) {
    	int id = (Integer) session.getAttribute("userId");
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserRegistry user) {
        user.setUserRegistryId(id);
        return userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
