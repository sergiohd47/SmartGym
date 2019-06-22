package com.DAD.SmartGym;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.DAD.SmartGym.Model.Entrenador;
import com.DAD.SmartGym.Model.Usuario;
import com.DAD.SmartGym.Repository.EntrenadoresRepository;
import com.DAD.SmartGym.Repository.UsuariosRepository;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {
	 @Autowired
	 private UsuariosRepository userRepository;
	 @Autowired
	 private EntrenadoresRepository trainerRepository;
	 @Override
	 public Authentication authenticate(Authentication auth) throws AuthenticationException {
		 
		 String rol="";
		 
		 Usuario user = userRepository.findByNombreUsuario(auth.getName());
		 Entrenador trainer = trainerRepository.findByNombreUsuario(auth.getName());
		 if ((user == null)&&(trainer==null)) {
			 throw new BadCredentialsException("El usuario/entrenador no esta en la base de datos");
		 }else if (user != null) {
			 rol="USUARIO";
		 }else if (trainer != null){
			 rol="ENTRENADOR";
		 }
		 
		 String password = (String) auth.getCredentials();
		 if (!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {
			 throw new BadCredentialsException("Contraseña erronea");
		 }
		
		 List<GrantedAuthority> roles = new ArrayList<>();
		 roles.add(new SimpleGrantedAuthority(rol));
		 
		 return new UsernamePasswordAuthenticationToken(auth.getName(), password, roles);
	 }
	 
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
}

