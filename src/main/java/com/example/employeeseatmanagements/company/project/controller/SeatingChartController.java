package com.example.employeeseatmanagements.company.project.controller;

import com.example.employeeseatmanagements.company.project.model.SeatingChart;
import com.example.employeeseatmanagements.company.project.repository.SeatingChartRepository;
import com.example.employeeseatmanagements.company.project.service.SeatingChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatingChartController {

    @Autowired
    private SeatingChartRepository seatingChartRepository;

    @Autowired
    private SeatingChartService seatingChartService;

    @GetMapping("/seating-charts")
    public List<SeatingChart> getAllSeatingCharts() {
        return seatingChartService.findAll();
    }

    @GetMapping("/seating-charts/{id}")
    public SeatingChart getSeatingChartById(@PathVariable String id) {
        return seatingChartService.findById(id);
    }
}
