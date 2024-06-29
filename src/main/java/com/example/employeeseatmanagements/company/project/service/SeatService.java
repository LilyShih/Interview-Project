package com.example.employeeseatmanagements.company.project.service;

import com.example.employeeseatmanagements.company.project.model.Employee;
import com.example.employeeseatmanagements.company.project.model.SeatAssignmentRequest;
import com.example.employeeseatmanagements.company.project.model.SeatingChart;
import com.example.employeeseatmanagements.company.project.repository.EmployeeRepository;
import com.example.employeeseatmanagements.company.project.repository.SeatingChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatingChartRepository seatingChartRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public boolean assignSeat(SeatAssignmentRequest request) {
        Employee employee = employeeRepository.findAll().stream()
                .filter(e -> e.getEmpId().equals(request.getEmployeeId()))
                .findFirst().orElse(null);
        if (employee != null) {
            // Clear current seat of the employee
            employeeRepository.clearSeatForEmployee(employee.getEmpId());
        }

        // Assign new seat
        Optional<SeatingChart> optionalSeat = seatingChartRepository.findById(request.getSeatId());
        if (optionalSeat.isPresent()) {
            SeatingChart seat = optionalSeat.get();
            employee.setFloorSeatSeq(seat.getFloorSeatSeq());
            employeeRepository.update(employee);
            return true;
        }
        return false;
    }

    public List<SeatingChart> getAllSeats() {
        return seatingChartRepository.findAll();
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

