package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistroController {
	@RequestMapping("/registro")
	public String registrar(Model model) {
		return "../templates/registro.html";
	}
}
