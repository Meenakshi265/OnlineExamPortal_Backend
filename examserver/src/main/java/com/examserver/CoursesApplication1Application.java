	package com.examserver;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.examserver.repo.UserRepository;
import com.examserver.services.UserService;
 

@SpringBootApplication
public class CoursesApplication1Application implements CommandLineRunner {
    
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder   bCryptPasswordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication1Application.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		System.out.println("starting code .....");
    
	}
	
	
	
		
	
	
	
}
