package com.DAD.SmartGym.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Repository.EntrenadoresRepository;
import com.DAD.SmartGym.Repository.UsuariosRepository;
import com.DAD.SmartGym.Repository.ClaseRepository;


@Controller
public class UsuarioController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@Autowired
	private UsuariosRepository usuarios;
	@Autowired
	private ClaseRepository clases;
	
	private String nombreUsuarioSesion;
	private String tipoUsuarioSesion;
	@RequestMapping("/usuarioController")
	public String usuarioBasico(Model model, @RequestParam String nombreUsuario, @RequestParam String contrasena, @RequestParam String usuario, HttpSession sesion) {
		sesion.setAttribute("nombreUsuarioSesion", nombreUsuario);
		sesion.setAttribute("tipoUsuarioSesion", usuario);
		if(sesion.getAttribute("tipoUsuarioSesion").equals("usuarioBasico") ) {
			if(usuarios.getContrasenaByNombreUsuario(nombreUsuario).toString().equals(contrasena)) {
				model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
				model.addAttribute("listaClases",clases.findAll());
				return "usuarioBasico";
			} else {
				return "acceso";
			}
			
		} else if (sesion.getAttribute("tipoUsuarioSesion").equals("usuarioEntrenador")) {
			
			if(entrenadores.getContrasenaByNombreUsuario(nombreUsuario).toString().equals(contrasena)) {
				model.addAttribute("nombreUsuario",nombreUsuario);
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