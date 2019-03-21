package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/seleccionarEntrenador")
	public String seleccionar(Model model, @RequestParam String contactarEntrenador,@RequestParam String objetivoRutina, HttpSession sesion) {
		Entrenador trainer = entrenadores.findByNombreUsuario(contactarEntrenador);
		Usuario user = usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		String respuestaRutina;
		String respuestaEntrenador;
		int duracion = (int)(Math.random()*8)+1;
		if(user.tieneEntrenador()) {
			if(user.getEntrenador().getNombreUsuario().equals(contactarEntrenador)) {
				respuestaRutina = user.solicitarRutina(objetivoRutina);
				respuestaEntrenador = "No cambia";
				trainer.crearRutina(duracion);
			}else {
				respuestaEntrenador = user.cambiarEntrenador(trainer);
				respuestaRutina = user.solicitarRutina(objetivoRutina);
				trainer.crearRutina(duracion);
			}
		} else {
			respuestaEntrenador = user.solicitarEntrenador(trainer);
			respuestaRutina = user.solicitarRutina(objetivoRutina);
			trainer.crearRutina(duracion);
			
		}
		//System.out.println(respuestaEntrenador);
		//System.out.println(respuestaRutina);
		usuarios.save(user);
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		return "usuarioBasico";
	}
}
