package com.example.employeeseatmanagements.company.project.repository;

import com.example.employeeseatmanagements.company.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class EmployeeRepository implements JpaRepository<Employee, Long> {
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        String sql = "SELECT * FROM Employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public void update(Employee employee) {
        String sql = "UPDATE Employee SET FLOOR_SEAT_SEQ = ? WHERE EMP_ID = ?";
        jdbcTemplate.update(sql, employee.getFloorSeatSeq(), employee.getEmpId());
    }

    public void clearSeatForEmployee(String employeeId) {
        String sql = "UPDATE Employee SET FLOOR_SEAT_SEQ = NULL WHERE EMP_ID = ?";
        jdbcTemplate.update(sql, employeeId);
    }

    private static final class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmpId(rs.getString("EMP_ID"));
            employee.setName(rs.getString("Name"));
            employee.setEmail(rs.getString("Email"));
            employee.setFloorSeatSeq(rs.getString("FLOOR_SEAT_SEQ"));
            return employee;
        }
    }
}
