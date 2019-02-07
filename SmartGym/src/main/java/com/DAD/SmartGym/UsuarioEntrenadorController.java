package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioEntrenadorController {
	@RequestMapping("/usuarioEntrenador")
	public String usuarioEntrenador(Model model) {
		model.addAttribute("nombreUsuario","Sergio_usuarioEntrenador");
		return "usuarioEntrenador";
	}
}
