package com.spring.mvc.love.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.mvc.love.entity.UserDBentity;

@Service
public class CustomUserDetailsService implements UserDetailsService {


	@Autowired
	public UserDBDAO UserDBDAO;

	public CustomUserDetailsService() {
		System.out.println("CustomUserDetailsService object created");
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserDBDAOimpl userDBDAOimpl = new UserDBDAOimpl();
		UserDBentity userdb = null;
		try {
			System.out.println("UserName : " + username);
			System.out.println("Bean : " + UserDBDAO);
			userdb = UserDBDAO.findByUserName(username);

		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User Name Not found");
		}
		if (userdb == null) {
			throw new UsernameNotFoundException("User Name Not found");
		}
		UserDetails user = User.withUsername(userdb.getUsername()).password(userdb.getPassword())
				.roles(userdb.getRoles()).build();

		return user;
	}

}
