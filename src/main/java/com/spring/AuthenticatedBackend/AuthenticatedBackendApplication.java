package com.spring.AuthenticatedBackend;

import com.spring.AuthenticatedBackend.models.ApplicationUser;
import com.spring.AuthenticatedBackend.models.Role;
import com.spring.AuthenticatedBackend.repository.RoleRepository;
import com.spring.AuthenticatedBackend.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthenticatedBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthenticatedBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository,
						  UserRepository userRepository,
						  PasswordEncoder passwordEncode){
		return args -> {

			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole= roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			ApplicationUser admin = new ApplicationUser(
					1,
					"admin",
					passwordEncode.encode("password"),
					roles);
			userRepository.save(admin);
		};
	}


}
