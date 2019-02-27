package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditarPerfilController {
	@RequestMapping("/editarPerfil")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuarioAntiguo",sesion.getAttribute("nombreUsuarioSesion"));
		return "editarPerfil";
	}
	
}