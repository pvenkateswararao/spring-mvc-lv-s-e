package com.spring.mvc.love.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import com.spring.mvc.love.DAO.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityFilterChainConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("myDataSource")
	DataSource myDataSource;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//im memory/server memory auth
//		auth.inMemoryAuthentication()
//		.withUser("venkat")
//		.password("$2a$10$0.wmwCDYAijb7444wXnSX.DLbPOITayxg9RbtuVAzOXEmKu1NsJEu")
//		.roles("admin");
		
		//auth.jdbcAuthentication().dataSource(myDataSource).passwordEncoder(passwordEncoder);
		
		
		
		//Traditional Approach
		/*
		ArrayList<SimpleGrantedAuthority> authorities= new ArrayList<>();
		SimpleGrantedAuthority role1 = new SimpleGrantedAuthority("admin");
		authorities.add(role1);
		
		User user = new User("hi", "hi@123", authorities);
		
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		
		userDetailsManager.createUser(user);
		
		auth.userDetailsService(userDetailsManager);
		*/
		
		//Traditional Approach Inmemory But user creation using chain functions
		/*
		UserDetails user = User.withUsername("hi").password("hi@123").roles("admin").build();
		
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		userDetailsManager.createUser(user);
		auth.userDetailsService(userDetailsManager);
		*/
		
//		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(myDataSource);
//		jdbcUserDetailsManager.setUsersByUsernameQuery("select username,password,enabled from customusers where username = ?");
//		jdbcUserDetailsManager.setCreateAuthoritySql("select username,roles from customusers where username = ?");
//		auth.userDetailsService(jdbcUserDetailsManager).passwordEncoder(passwordEncoder);
//		
		
		//JDBC standard form
		/*
		auth.jdbcAuthentication().dataSource(myDataSource)
		.usersByUsernameQuery("select username,password,enabled from customusers where username = ?")
		.authoritiesByUsernameQuery("select username,roles from customusers where username = ?");
		*/
		
		//Custom Userdetails
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home","/","/calculate-love").hasRole("Admin")
		.antMatchers("/loginPage").permitAll()
		.and()
		.formLogin().loginPage("/loginPage")
		.and()
		.httpBasic()
		.and().logout();
	}

}
