package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Repository.EntrenadoresRepository;
import com.DAD.SmartGym.Repository.UsuariosRepository;
import com.DAD.SmartGym.Repository.ClaseRepository;

@Controller
public class EditarPerfilController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@Autowired
	private UsuariosRepository usuarios;
	@Autowired
	private ClaseRepository clases;
	
	@RequestMapping("/editarPerfil")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuarioAntiguo",sesion.getAttribute("nombreUsuarioSesion"));
		return "editarPerfil";
	}
	/*
	@RequestMapping("/cancelar")
	public String cancelar(Model model,@RequestParam String editar, HttpSession sesion) {
		if(editar.equals("usuarioBasico")) {
			model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
			return "usuarioBasico";
		} else {
			model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
			return "usuarioEntrenador";
		}
	}
	*/
	@PostMapping("/cambiarPerfil")
	public String cambiar(Model model,@RequestParam String nombreUsuario,
			@RequestParam String email, @RequestParam String contrasena, HttpSession sesion) {
		if(sesion.getAttribute("tipoUsuarioSesion").equals("usuarioBasico")) {
			
			int id = (int) usuarios.getIdByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
			usuarios.setUsuarioById(nombreUsuario, id);
			usuarios.setMailById(email, id);
			usuarios.setContrasenaById(contrasena, id);
			model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
			return "usuarioBasico";
		} else {
			
			int id = entrenadores.getIdByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
			entrenadores.setUsuarioById(nombreUsuario, id);
			entrenadores.setContrasenaById(contrasena, id);
			entrenadores.setMailById(email, id);
			model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
			model.addAttribute("listaClases",clases.findAllNombre());
			return "usuarioEntrenador";
		}
	}
	
}