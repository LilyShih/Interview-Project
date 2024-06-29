package com.example.employeeseatmanagements.company.project.controller;

import com.example.employeeseatmanagements.company.project.model.SeatAssignmentRequest;
import com.example.employeeseatmanagements.company.project.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/seats")
    public ResponseEntity<Map<String, Object>> getAllSeats() {
        Map<String, Object> response = new HashMap<>();
        response.put("seats", seatService.getAllSeats());
        response.put("employees", seatService.getAllEmployees());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/assign-seat")
    public ResponseEntity<Map<String, String>> assignSeat(@RequestBody SeatAssignmentRequest request) {
        boolean success = seatService.assignSeat(request);
        Map<String, String> response = new HashMap<>();
        response.put("success", success ? "true" : "false");
        return ResponseEntity.ok(response);
    }
}
