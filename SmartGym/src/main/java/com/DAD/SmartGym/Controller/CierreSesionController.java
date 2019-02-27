package com.DAD.SmartGym.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CierreSesionController {
	@RequestMapping("/cerrarSesion")
	public String acceder(Model model) {
		model.addAttribute("nombreUsuario","SergioUsuario");	
		return "cerrarSesion";
	}
	@RequestMapping("/volverInicio")
	public String volverInicio(Model model) {
		return "index";
	}
}
