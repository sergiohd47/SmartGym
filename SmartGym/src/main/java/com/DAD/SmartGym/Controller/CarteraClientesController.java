package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DAD.SmartGym.Repository.EntrenadoresRepository;
import com.DAD.SmartGym.Model.Entrenador;
import com.DAD.SmartGym.Model.TablaRutina;
import com.DAD.SmartGym.Model.Usuario;
import com.DAD.SmartGym.Repository.*;

@Controller
public class CarteraClientesController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@Autowired
	private UsuariosRepository usuarios;
	@Autowired
	private TablaRutinaRepository tablasRutinas;
	@RequestMapping("/carteraClientes")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		Entrenador trainer = entrenadores.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		//ACTUALIZAR HTML Y COSAS PARA QUE SEA CORRECTO
		//model.addAttribute("listaRutinasPendientes",usuarios.getNombreUsuariosByIdEntrenador(entrenadores.getIdByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString()))); 
		return "carteraClientes";
	}
}
