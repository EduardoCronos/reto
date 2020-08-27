package com.crono.reto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



import org.springframework.security.core.userdetails.User;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
//		PasswordEncoder encoder = passwordEncoder();
//		
//		UserBuilder users = User.builder().passwordEncoder(password -> {
//			return encoder.encode(password);
//		});
//
//		builder.inMemoryAuthentication().withUser(users.username("admin").password("123456").roles("ADMIN", "USER"))
//		.withUser(users.username("eduardo").password("qwerty").roles("USER"));
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				// nuestras rutas publicas
//				.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
//				.antMatchers("/").hasAnyRole("ADMIN")
//				.antMatchers("/").hasAnyRole("USER")
//				.antMatchers("/hub/**").hasAnyRole("ADMIN")
//				.antMatchers("/devices/**").hasAnyRole("ADMIN")	
//				.and()
//					.formLogin()
//					.permitAll() 
//				.and()
//				.logout().permitAll();
	}
}
