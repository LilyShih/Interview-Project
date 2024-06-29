package com.example.employeeseatmanagements.company.project.service;

import com.example.employeeseatmanagements.company.project.model.SeatingChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SeatingChartService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SeatingChart> findAll() {
        String sql = "SELECT * FROM SeatingChart";
        return jdbcTemplate.query(sql, new SeatingChartRowMapper());
    }

    public SeatingChart findById(String floorSeatSeq) {
        String sql = "SELECT * FROM SeatingChart WHERE FLOOR_SEAT_SEQ = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{floorSeatSeq}, new SeatingChartRowMapper());
    }

    private static final class SeatingChartRowMapper implements RowMapper<SeatingChart> {
        @Override
        public SeatingChart mapRow(ResultSet rs, int rowNum) throws SQLException {
            SeatingChart seat = new SeatingChart();
            seat.setFloorSeatSeq(rs.getString("FLOOR_SEAT_SEQ"));
            seat.setFloorNo(rs.getString("FLOOR_NO"));
            seat.setSeatNo(rs.getString("SEAT_NO"));
            return seat;
        }
    }
}