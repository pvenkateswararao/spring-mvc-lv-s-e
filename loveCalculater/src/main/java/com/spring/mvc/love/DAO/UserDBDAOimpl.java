package com.spring.mvc.love.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.spring.mvc.love.entity.UserDBentity;

@Repository
public class UserDBDAOimpl implements UserDBDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public UserDBDAOimpl() {
		System.out.println("UserDBDAOimpl Object Created");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public UserDBentity findByUserName(String username) {

		String sql = "select * from customusers where username=?";
		Object args[] = { username };
		UserDBentity userdb = null;
		System.out.println("Jdbc template " + jdbcTemplate);
		try {
			System.out.println("UserName : " + username);
			System.out.println("Jdbc template " + jdbcTemplate);
			userdb = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<UserDBentity>(UserDBentity.class));

		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User Name Not found");
		}

		return userdb;

	}

}
