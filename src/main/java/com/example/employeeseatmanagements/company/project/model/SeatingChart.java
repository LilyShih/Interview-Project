package com.example.employeeseatmanagements.company.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SeatingChart")
public class SeatingChart {

    @Id
    private String floorSeatSeq;
    private String floorNo;
    private String seatNo;

    // Getters and Setters
    public String getFloorSeatSeq() {
        return floorSeatSeq;
    }

    public void setFloorSeatSeq(String floorSeatSeq) {
        this.floorSeatSeq = floorSeatSeq;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}
