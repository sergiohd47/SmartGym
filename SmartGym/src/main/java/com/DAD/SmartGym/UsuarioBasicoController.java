package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioBasicoController {
	@RequestMapping("/usuario=usuarioBasico")
	public String usuarioBasico(Model model) {
		return "usuarioBasico.html";
	}
}
