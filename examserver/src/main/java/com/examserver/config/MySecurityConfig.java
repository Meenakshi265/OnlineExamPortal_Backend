package com.examserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.examserver.services.impl.CustomeUserDeatialsServicveImpl;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

	@Autowired
	private CustomeUserDeatialsServicveImpl customeUserDeatialsServicveImpl;

	@Autowired
	private JwtAutothencationEntryPoint unauthorizedHandler;

	@Autowired
	private JwtAuthencationFilter jwtAuthencationFilter;

	@Bean
	public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {

		System.out.println("this is the filter chain bean..............1");
		http.csrf()
		.disable()
		.cors()
		.disable()
		.authorizeRequests()
		.requestMatchers("/token", "/user/")
		.permitAll()
				.requestMatchers(HttpMethod.OPTIONS)
				.permitAll().anyRequest()
				.authenticated()
				.and().exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		      http.addFilterBefore(jwtAuthencationFilter, UsernamePasswordAuthenticationFilter.class);
		      System.out.println("this is the filter chain bean..............2");
		http.authenticationProvider(this.daoAuthenticationProvider());
		System.out.println("this is the filter chain bean..............3");
		return http.build();

	}

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return  new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customeUserDeatialsServicveImpl);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		
		return authenticationConfiguration.getAuthenticationManager();
	}

}