package com.DAD.SmartGym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccesoController {
	//@Autowired
	//private EntrenadoresRepository entrenadores;
	//@Autowired
	//private UsuariosRepository usuarios;
	@RequestMapping("/acceso")
	public String acceder(Model model) {
		return "acceso";
	}
	
}
