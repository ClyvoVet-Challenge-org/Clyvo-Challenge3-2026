package com.example.clyvo_challenge3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/login", "/cadastro-clinica", "/cadastrar_clinica","/cadastro-veterinario","/cadastrar-veterinario","/").permitAll() // Permite
																														// todos
								.requestMatchers(
										"/clinica/veterinarios",
										"/clinica/veterinarios/{id}",
										"/clinica/veterinarios/novo",
										"/clinica/perfil",
										"/clinica/veterinario/salvar",
										"/clinica/edicao",
										"/clinica/atualizar"
								).hasAuthority("CLINICA")
								.requestMatchers(
										"/vet/edicao",
										"/vet/perfil",
										"/vet/atualizar",
										"/vet/minhas-consultas"
								).hasAuthority("VETERINARIO")
								.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true))
				.logout(config -> config.logoutSuccessUrl("/login"))
				.exceptionHandling((exception) -> exception.accessDeniedHandler((request, response, AccessDeniedException) -> {
							response.sendRedirect("/acesso-negado");
						}))
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
