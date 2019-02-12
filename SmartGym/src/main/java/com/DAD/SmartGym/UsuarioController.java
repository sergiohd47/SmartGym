package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
	@RequestMapping("/usuarioController")
	public String usuarioBasico(Model model, @RequestParam String nombreUsuario, @RequestParam String usuario) {
		if(usuario.equals("usuarioBasico") ) {
			model.addAttribute("nombreUsuario",nombreUsuario);
			return "usuarioBasico";
		} else {
			model.addAttribute("nombreUsuario",nombreUsuario);
			return "usuarioEntrenador";
		}
		
	}
}