package com.spring.mvc.love.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOimpl implements StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void insert() {
		String s = "Insert into student values (?,?,?,?)";
		Object[] params = { 2, "ttt", "hello", "ghello@GMAIL.COM" };
		try {
			int n = jdbcTemplate.update(s, params);
			System.out.println("DB operation Done + " + n);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
