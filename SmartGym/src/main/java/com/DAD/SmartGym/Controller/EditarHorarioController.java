package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Model.Clase;
import com.DAD.SmartGym.Repository.ClaseRepository;

@Controller
public class EditarHorarioController {
	
	@Autowired
	private ClaseRepository clases;
	
	@RequestMapping("/editarHorario")
	public String cambiar(Model model,@RequestParam String nombreClase, @RequestParam String diaClase,
			@RequestParam int horaClase,@RequestParam int salaClase, HttpSession sesion) {
		Clase clase = clases.getByNombre(nombreClase);
		clase.addHorarios(horaClase, diaClase, salaClase);
		clases.save(clase);
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		model.addAttribute("listaClases",clases.findAllNombre());
		//tablaHorario(model);
		return "usuarioEntrenador";
	}
}
