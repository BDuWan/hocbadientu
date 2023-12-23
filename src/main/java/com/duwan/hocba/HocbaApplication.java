package com.duwan.hocba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HocbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HocbaApplication.class, args);
	}
	
//	public static void main(String[] args) {
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(HocbaApplication.class, args);
//		UserInterface userInterface =  applicationContext.getBean(UserDao.class);
//		List<User> users = userInterface.fetchAllUser();
//		User user = users.get(0);
//		System.out.println(user);
//		System.out.println("---------------------------------------");
//		userInterface.fetchAllUser().forEach(System.out::println);
//		System.out.println("---------------------------------------");
//	}
}
