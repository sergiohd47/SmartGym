package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioBasicoController {
	@RequestMapping("/usuarioBasico")
	public String usuarioBasico(Model model) {
		model.addAttribute("nombreUsuario","Sergio_usuarioBasico");
		return "usuarioBasico";
	}
}
