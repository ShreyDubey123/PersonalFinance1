package com.app.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {

	
	@RequestMapping(value = "/test-cors", method = RequestMethod.GET)
    public ResponseEntity<String> handleTestCors() {
        return ResponseEntity.ok("CORS test successful");
    }
    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public void handleOptions() {
        // Handle OPTIONS requests
    }
    
}
