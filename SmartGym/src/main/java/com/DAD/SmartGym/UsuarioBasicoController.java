package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioBasicoController {
	@RequestMapping("/usuarioBasico")
	public String usuarioBasico(Model model, @RequestParam String nombreUsuario) {
		model.addAttribute("nombreUsuario",nombreUsuario);
		return "usuarioBasico";
	}
}
