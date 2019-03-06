package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Repository.*;
import com.DAD.SmartGym.Model.*;

@Controller
public class ContactarEntrenadorController {
	@Autowired
	private EntrenadoresRepository entrenadores;
	@Autowired
	private UsuariosRepository usuarios;
	@RequestMapping("/contactarEntrenador")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		model.addAttribute("listaEntrenadores",entrenadores.findAllNombreUsuario()); //MODIFICO REPOSITORY PARA SACAR TODOS LOS NOMBRES DE ENT.
		return "contactarEntrenador";
	}
	
	@RequestMapping("/seleccionarEntrenador")
	public String contactar(Model model, @RequestParam String contactarEntrenador,@RequestParam String objetivoRutina, HttpSession sesion) {
		/*entrenadores.getIdByNombreUsuario(contactarEntrenador);
		
		Entrenador trainer = entrenadores.findById;
		System.out.println(trainer.getNombreUsuario());
		Usuario user = usuarios.getByNombre(sesion.getAttribute("nombreUsuarioSesion").toString());
		String solicitarEntre = user.solicitarEntrenador(trainer);
		String rutinaSol = user.solicitarRutina(objetivoRutina);
		/*if (user.tieneEntrenador()) {
			if(user.getEntrenador().equals(trainer)) {
				String rutinaSol = user.solicitarRutina(objetivoRutina);
			}else {
				String cambiarEntre = user.cambiarEntrenador(trainer);
				String rutinaSol = user.solicitarRutina(objetivoRutina);
			}
		}else {
			String solicitarEntre = user.solicitarEntrenador(trainer);
			String rutinaSol = user.solicitarRutina(objetivoRutina);
		}
		*/
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		
		return "usuarioBasico";
	}
}
