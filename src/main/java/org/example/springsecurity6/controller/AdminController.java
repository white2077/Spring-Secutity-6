package org.example.springsecurity6.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok("Welcome to the admin home page");
    }
}
