package org.example.springsecurity6.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping
    public ResponseEntity<?> home() {
        return ResponseEntity.ok("Welcome to the home page");
    }
}
