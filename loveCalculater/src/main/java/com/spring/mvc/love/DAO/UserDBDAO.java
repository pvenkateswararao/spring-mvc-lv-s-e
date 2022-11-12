package com.spring.mvc.love.DAO;

import com.spring.mvc.love.entity.UserDBentity;

public interface UserDBDAO {
	public UserDBentity findByUserName(String username);
}
