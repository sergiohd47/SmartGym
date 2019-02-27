package com.DAD.SmartGym.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactarEntrenadorController {
	@RequestMapping("/contactarEntrenador")
	public String acceder(Model model) {
		model.addAttribute("nombreUsuario","sergioBasico");
		return "contactarEntrenador";
	}
}
