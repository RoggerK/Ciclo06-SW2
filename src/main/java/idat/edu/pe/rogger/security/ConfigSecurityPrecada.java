package idat.edu.pe.rogger.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecurityPrecada extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("PROFESOR").password(encriptado().encode("123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("ALUMNO").password(encriptado().encode("123")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/producto/v1/listar").hasAnyRole("ADMIN", "USER")
		.antMatchers("/producto/v1/listar/**").hasAnyRole("ADMIN", "USER")
		.antMatchers("/producto/v1/guardar").hasAnyRole("ADMIN") //.access("hasRole('ADMIN')")
		.antMatchers("/producto/v1/editar").hasAnyRole("ADMIN")
		.antMatchers("/producto/v1/eliminar/**").hasAnyRole("ADMIN")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}

}
