package com.zhuowang.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.zhuowang.entity.Student;

@Service
public class StudentService {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Student> getList(){
		String sql = "select ID,NAME,SCORE_SUM,SCORE_AVG,AGE from t_student";
		return jdbcTemplate.query(sql, new RowMapper<Student>(){

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("ID"));
				student.setName(rs.getString("NAME"));
				student.setSumScore(rs.getString("SCORE_SUM"));
				student.setAvgScore(rs.getString("SCORE_AVG"));
				student.setAge(rs.getInt("AGE"));
				return student;
			}
		});
	}
}
