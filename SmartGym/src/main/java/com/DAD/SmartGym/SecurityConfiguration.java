package com.DAD.SmartGym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	UserRepositoryAuthenticationProvider authenticatorProvider;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//PAGINAS PUBLICAS
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/acceso").permitAll();
		http.authorizeRequests().antMatchers("/registro").permitAll();
		http.authorizeRequests().antMatchers("/accesoRegistro").permitAll();
		http.authorizeRequests().antMatchers("/vendor/**").permitAll();
		http.authorizeRequests().antMatchers("/css/**").permitAll();
		http.authorizeRequests().antMatchers("/scss/**").permitAll();
		http.authorizeRequests().antMatchers("/img/**").permitAll();
		http.authorizeRequests().antMatchers("/js/**").permitAll();
		
		
		
		
		
		//PAGINAS PRIVADAS
		
		http.authorizeRequests().antMatchers("/usuarioBasico").hasAnyRole("USUARIO");
		http.authorizeRequests().antMatchers("/usuarioEntrenador").hasAnyRole("ENTRENADOR");

		
		//PAGINA ACCESO	
		http.formLogin().loginPage("/acceso");
		
		http.formLogin().usernameParameter("nombreUsuario");
		http.formLogin().passwordParameter("contrasena");
		http.formLogin().defaultSuccessUrl("/usuarioBasico");
		http.formLogin().defaultSuccessUrl("/usuarioEntrenador");
		
		//PAGINA CERRAR SESION
		http.logout().logoutUrl("/cerrarSesion");
		http.logout().logoutSuccessUrl("/");
		
		//DESACTIVAR CSRF
		//http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("usuario").password("pass").roles("USUARIO");
		auth.inMemoryAuthentication().withUser("entrenador").password("entrenadorpass").roles(/*"USUARIO",*/"ENTRENADOR");
		//auth.authenticationProvider(authenticatorProvider);
	}
	

}
