package com.DAD.SmartGym;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//PAGINAS PUBLICAS
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/acceso").permitAll();
		http.authorizeRequests().antMatchers("/registro").permitAll();
		
		//PAGINAS PRIVADAS
		http.authorizeRequests().anyRequest().authenticated();
		
		//PAGINA ACCESO	
		http.formLogin().loginPage("/acceso");
		http.formLogin().usernameParameter("nombreUsuario");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/usuarioBasico");
		http.formLogin().defaultSuccessUrl("/usuarioEntrenador");
		
		//PAGINA CERRAR SESION
		http.logout().logoutUrl("/cerrarSesion");
		http.logout().logoutSuccessUrl("/");
		
		//DESACTIVAR CSRF
		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
	}
	

}
