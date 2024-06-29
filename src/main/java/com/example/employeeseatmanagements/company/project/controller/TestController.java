package com.example.employeeseatmanagements.company.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class TestController {
    @GetMapping("/api/test")
    public String test() {
        return "Backend is working!";
    }
}
