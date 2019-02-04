package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CierreSesionController {
	@RequestMapping("/cerrarSesion")
	public String acceder(Model model) {
		return "index.html";
	}
}
