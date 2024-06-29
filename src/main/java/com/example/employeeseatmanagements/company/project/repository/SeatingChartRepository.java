package com.example.employeeseatmanagements.company.project.repository;

import com.example.employeeseatmanagements.company.project.model.SeatingChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatingChartRepository extends JpaRepository<SeatingChart, String> {
}
