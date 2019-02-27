package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
	private String nombreUsuarioSesion;
	private String tipoUsuarioSesion;
	@RequestMapping("/usuarioController")
	public String usuarioBasico(Model model, @RequestParam String nombreUsuario, @RequestParam String usuario, HttpSession sesion) {
		sesion.setAttribute("nombreUsuarioSesion", nombreUsuario);
		sesion.setAttribute("tipoUsuarioSesion", usuario);
		if(sesion.getAttribute("tipoUsuarioSesion").equals("usuarioBasico") ) {
			model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
			return "usuarioBasico";
		} else {
			model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
			return "usuarioEntrenador";
		}
		
	}
}