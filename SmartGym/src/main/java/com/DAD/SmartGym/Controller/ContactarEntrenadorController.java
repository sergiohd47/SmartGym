package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DAD.SmartGym.Repository.*;
import com.DAD.SmartGym.Model.*;

@Controller
public class ContactarEntrenadorController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@RequestMapping("/contactarEntrenador")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		model.addAttribute("listaEntrenadores",entrenadores.findAllNombre()); //MODIFICO REPOSITORY PARA SACAR TODOS LOS NOMBRES DE ENT.
		return "contactarEntrenador";
	}
}
