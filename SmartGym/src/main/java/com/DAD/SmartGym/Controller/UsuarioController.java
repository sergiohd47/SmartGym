package com.DAD.SmartGym.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Repository.EntrenadoresRepository;
import com.DAD.SmartGym.Repository.TablaRutinaRepository;
import com.DAD.SmartGym.Repository.UsuariosRepository;
import com.DAD.SmartGym.Model.TablaRutina;
import com.DAD.SmartGym.Model.Usuario;
import com.DAD.SmartGym.Repository.ClaseRepository;


@Controller
public class UsuarioController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@Autowired
	private UsuariosRepository usuarios;
	@Autowired
	private ClaseRepository clases;
	@Autowired
	private TablaRutinaRepository rutinas; //REPOSITORY EN EL QUE SE GUARDARIAN LAS RUTINAS PEDIDAS A UN ENTRENADOR PERSONAL RELACION USUARIO->ENTRENADOR
	/*
	@Autowired 
	private RutinasFavoritasRepository rutinasFavoritas; //REPOSITORY DE RUTINAS FAVORITAS DE UN USUARIO
	*/
	private String nombreUsuarioSesion;
	private String tipoUsuarioSesion;
	@RequestMapping("/usuarioController")
	public String usuarioBasico(Model model, @RequestParam String nombreUsuario, @RequestParam String contrasena, @RequestParam String usuario, HttpSession sesion) {
		sesion.setAttribute("nombreUsuarioSesion", nombreUsuario);
		sesion.setAttribute("tipoUsuarioSesion", usuario);
		if(sesion.getAttribute("tipoUsuarioSesion").equals("usuarioBasico") ) {
			if(usuarios.getContrasenaByNombreUsuario(nombreUsuario).equals(contrasena)) {
				Usuario user = usuarios.findByNombreUsuario(nombreUsuario);
				model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
				model.addAttribute("listaClases",clases.findAllNombre());
				/*if(rutinas.findByUsuario(user)!=null) {
					/model.addAttribute("listaRutinasPersonales",rutinas.findByUsuario(user)); //RUTINAS PERSONALES MANDADAS POR UN ENTRENADOR -> Devuelvo la lista de rutinas del usuario
				}*/
				//if(rutinas.findFavByUsuario(usuarios.getIdByNombreUsuario(user.getNombreUsuario()))!=null) {
				if(user.hayFavoritas()) {
					model.addAttribute("listaRutinasFavoritas",rutinas.findFavoritasByIdUsuario(usuarios.getIdByNombreUsuario(user.getNombreUsuario()))); //RUTINAS FAVORITAS DE UN USUARIO -> Devuelvo la lista de rutinas favoritas del usuario
				}
				return "usuarioBasico";
			} else {
				return "acceso";
			}
			
		} else if (sesion.getAttribute("tipoUsuarioSesion").equals("usuarioEntrenador")) {
			
			if(entrenadores.getContrasenaByNombreUsuario(nombreUsuario).equals(contrasena)) {
				model.addAttribute("nombreUsuario",nombreUsuario);
				model.addAttribute("listaClases",clases.findAllNombre());
				//model.addAttribute("listaRutinasPersonales",rutinas.); //RUTINAS PERSONALES MANDADAS POR UN ENTRENADOR
				return "usuarioEntrenador";
			} else {
				return "acceso";
			}
/*			
	private String nombreUsuarioSesion;
	private String tipoUsuarioSesion;
	@RequestMapping("/usuarioController")
	public String usuarioBasico(Model model, @RequestParam String nombreUsuario, @RequestParam String usuario, HttpSession sesion) {
		sesion.setAttribute("nombreUsuarioSesion", nombreUsuario);
		sesion.setAttribute("tipoUsuarioSesion", usuario);
		if(sesion.getAttribute("tipoUsuarioSesion").equals("usuarioBasico") ) {
			model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
			return "usuarioBasico";
		} else {
			model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
			return "usuarioEntrenador";
*/
		}
		return "acceso";
	} 
	
}