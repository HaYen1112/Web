package com.example.mypkg.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.mypkg.dto.RoleDTO;
import com.example.mypkg.dto.UserAppDTO;
import com.example.mypkg.service.RoleService;
import com.example.mypkg.service.UserAppRoleService;
import com.example.mypkg.service.UserService;
import com.example.mypkg.until.EncrytedPasswordUtils;
import com.example.mypkg.until.Role;

@Configuration
public class CommandLineRunnerConfiguration {
	@Bean
	CommandLineRunner commandLineRunner(RoleService roleService, UserService userService,
			UserAppRoleService userAppRoleService) {
		return args -> {
			roleService.addRole(new RoleDTO(Role.ROLE_USER.get()));
			roleService.addRole(new RoleDTO(Role.ROLE_ADMIN.get()));
			userService.register(new UserAppDTO("admin@gmail.com", EncrytedPasswordUtils.encrytePassword("123")));
			userAppRoleService.addRoleToUser(Long.valueOf(1), Role.ROLE_USER.get());
		};
	}
}
