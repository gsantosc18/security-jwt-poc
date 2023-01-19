package com.gedalias.securityjwt;

import com.gedalias.securityjwt.security.domain.Role;
import com.gedalias.securityjwt.security.domain.User;
import com.gedalias.securityjwt.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static java.util.Collections.emptyList;

@SpringBootApplication
public class SecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJwtApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "MANAGER"));
			userService.saveRole(new Role(null, "ADMIN"));
			userService.saveRole(new Role(null, "SUPER_ADMIN"));

			userService.saveUser(new User(null, "Gedalias", "gedalias", "1234", emptyList()));
			userService.saveUser(new User(null, "Aida", "aida", "1234", emptyList()));
			userService.saveUser(new User(null, "Adriane", "adriane", "1234", emptyList()));
			userService.saveUser(new User(null, "Leno", "leno", "1234", emptyList()));

			userService.addRoleToUser("gedalias", "USER");
			userService.addRoleToUser("aida", "SUPER_ADMIN");
			userService.addRoleToUser("adriane", "ADMIN");
			userService.addRoleToUser("leno", "MANAGER");
			userService.addRoleToUser("gedalias", "ADMIN");
		};
	}

}
