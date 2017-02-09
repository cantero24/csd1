package csd.configuraciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import csd.modelo.servicios.ServicioAutentificacion;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	

	public ConfiguracionSeguridad() {
		System.out.println("crea seguridad");
	}


	@Autowired
	private ServicioAutentificacion servicoAutentificacion;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(servicoAutentificacion);
			//.passwordEncoder(encoder());
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("PIZZARIA");
		System.out.println("configura");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/jugador/**","/equipos/**","/federacion/**").hasRole("ADMIN")
				.anyRequest().permitAll()
		.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/autentificar")
				.defaultSuccessUrl("/jugador")
				.failureUrl("/login?errorLogin=true")
				.usernameParameter("username")
				.passwordParameter("password")
				
			.and()
				.logout()
					.logoutUrl("/salir")
					.logoutSuccessUrl("/login?salir=true");
	}
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	
}
