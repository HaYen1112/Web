package com.example.mypkg.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.mypkg.dto.UserAppDTO;
import com.example.mypkg.service.UserAppService;
import com.example.mypkg.until.EncrytedPasswordUtil;

@Configuration
public class CommandLineRunnerConfiguration {
	@Bean
	CommandLineRunner commandLineRunner(UserAppService userService) {
		return args -> {
			userService.register(new UserAppDTO("admin@gmail.com", EncrytedPasswordUtil.encrytePassword("123")));
		};
	}
}
