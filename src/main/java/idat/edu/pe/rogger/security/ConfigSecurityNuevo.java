package idat.edu.pe.rogger.security;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecurityNuevo {
	
	@Bean
	public UserDetailsService userDetail() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withUsername("alumno")
				.password(encriptado().encode("123"))
				.roles("ADMIN")
				.build()
		);
		
		return manager;
	}
	
	@Bean //@Bean -> ese metodo guarda en el contenedor de spring, el metodo se podra usar en cualquier lado
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/producto/v1/*").access("hasRole('ADMIN')")
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
		
		return http.build();
	}
	
}
*/