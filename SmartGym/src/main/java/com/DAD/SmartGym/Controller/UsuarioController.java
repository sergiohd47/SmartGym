package com.DAD.SmartGym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Repository.EntrenadoresRepository;
import com.DAD.SmartGym.Repository.UsuariosRepository;

@Controller
public class UsuarioController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@Autowired
	private UsuariosRepository usuarios;
	@RequestMapping("/usuarioController")
	public String usuarioBasico(Model model, @RequestParam String nombreUsuario, @RequestParam String contrasena, @RequestParam String usuario) {
		if(usuario.equals("usuarioBasico") ) {
			if(usuarios.getContrasenaByNombreUsuario(nombreUsuario).toString().equals(contrasena)) {
				model.addAttribute("nombreUsuario",nombreUsuario);
				return "usuarioBasico";
			} else {
				return "acceso";
			}
			
		} else if (usuario.equals("usuarioEntrenador")) {
			
			if(entrenadores.getContrasenaByNombreUsuario(nombreUsuario).toString().equals(contrasena)) {
				model.addAttribute("nombreUsuario",nombreUsuario);
				return "usuarioEntrenador";
			} else {
				return "acceso";
			}
			
		}
		return "acceso";
	} 
	
}