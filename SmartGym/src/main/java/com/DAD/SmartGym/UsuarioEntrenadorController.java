package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioEntrenadorController {
	@RequestMapping("/acceso?usuario=usuarioEntrenador")
	public String usuarioEntrenador(Model model) {
		return "usuarioEntrenador.html";
	}
}
