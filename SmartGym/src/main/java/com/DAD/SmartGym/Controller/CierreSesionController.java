package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CierreSesionController {
	@RequestMapping("/cerrarSesion")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));	
		return "cerrarSesion";
	}
	@RequestMapping("/volverInicio")
	public String volverInicio(Model model) {
		return "index";
	}
}
