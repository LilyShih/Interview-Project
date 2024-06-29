package com.example.employeeseatmanagements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.employeeseatmanagements.company.project.repository")
public class EmployeeSeatManagementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSeatManagementsApplication.class, args);
    }

}
