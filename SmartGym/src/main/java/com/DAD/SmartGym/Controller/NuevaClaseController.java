package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Model.Clase;
import com.DAD.SmartGym.Model.Entrenador;
import com.DAD.SmartGym.Repository.ClaseRepository;
import com.DAD.SmartGym.Repository.EntrenadoresRepository;

@Controller
public class NuevaClaseController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@Autowired
	private ClaseRepository clases;
	@PostMapping("/nuevaClase")
	public String nuevaClase(Model model, @RequestParam String nombreClaseNueva,
			@RequestParam int fuerzaClaseNueva,@RequestParam int cardioClaseNueva, @RequestParam int plazasClaseNueva,
			@RequestParam int duracionClaseNueva,@RequestParam String descripcionClaseNueva, HttpSession sesion) {
		
		Entrenador trainer = entrenadores.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		Clase clase = new Clase(nombreClaseNueva,cardioClaseNueva,fuerzaClaseNueva,plazasClaseNueva,trainer,duracionClaseNueva,descripcionClaseNueva);
		clases.save(clase);
		//entrenadores.save(trainer);
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		model.addAttribute("listaClases",clases.findAllNombre());
		return "usuarioEntrenador";
	}
}
