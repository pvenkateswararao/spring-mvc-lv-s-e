package com.spring.mvc.love;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.mvc.love.DAO.UserDBDAOimpl;
import com.spring.mvc.love.formatter.CrushNameConvertor;
import com.spring.mvc.love.formatter.NameFormatter;

@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.spring.mvc","com.spring.mvc.love.security"})
@PropertySource(value = { "classpath:dataBase.properties" })
public class ApplicationContextConfigCustom extends WebMvcConfigurerAdapter{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("Add formatter function in Bean configuration");
		NameFormatter nf = new NameFormatter();
		registry.addFormatter(nf);
		registry.addConverter(new CrushNameConvertor());
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		System.out.println("View Resolver");
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate j = new JdbcTemplate(dataSource());
		System.out.println("JDBC Bean created");
		return j;
	}
	
	@Bean("myDataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/mvcspringsecurity?useSSL=false");
		dataSource.setUsername("hbstudent");
		dataSource.setPassword("hbstudent");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

	
}
