package com.DAD.SmartGym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Repository.EntrenadoresRepository;
import com.DAD.SmartGym.Model.Entrenador;
import com.DAD.SmartGym.Repository.UsuariosRepository;
import com.DAD.SmartGym.Model.Usuario;

@Controller
public class InicioRegistroController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@Autowired
	private UsuariosRepository usuarios;	
	@RequestMapping("/accesoRegistro")
	public String inicioRegistrar(Model model,@RequestParam String nombre, @RequestParam String apellidos,
			@RequestParam char sexo,@RequestParam String nombreUsuario,@RequestParam String email,
			@RequestParam String contrasena, @RequestParam String usuario) {
		if(usuario.equals("usuarioBasico")) {
			if(usuarios.findByNombreUsuario(nombreUsuario).size()==0) {
				Usuario user = new Usuario(nombre,apellidos,nombreUsuario,email,sexo,contrasena);
				usuarios.save(user);
				return "acceso";
			}
		} else if(usuario.equals("usuarioEntrenador")) {
			if(entrenadores.findByNombreUsuario(nombreUsuario).size()==0) {
				Entrenador trainer = new Entrenador(nombre,apellidos,nombreUsuario,email,sexo,contrasena);
				entrenadores.save(trainer);
				return "acceso";
			}
		}
		return "registro";
	}

}
