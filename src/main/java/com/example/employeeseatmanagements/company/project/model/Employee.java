package com.example.employeeseatmanagements.company.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empId;
    private String name;
    private String email;
    private String floorSeatSeq;

    // Constructors, getters, and setters

    public Employee() {
    }

    public Employee(String empId, String name, String email, String floorSeatSeq) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.floorSeatSeq = floorSeatSeq;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and Setters
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFloorSeatSeq() {
        return floorSeatSeq;
    }

    public void setFloorSeatSeq(String floorSeatSeq) {
        this.floorSeatSeq = floorSeatSeq;
    }
}
