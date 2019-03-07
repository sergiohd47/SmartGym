package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Repository.*;
import com.DAD.SmartGym.Controller.*;
import com.DAD.SmartGym.Model.*;

@Controller
public class RutinasPersonalizadasController {
	@Autowired
	private UsuariosRepository usuarios;
	@Autowired
	private TablaRutinaRepository tablas;
	@RequestMapping("/rutinasPersonalizadas")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		
		Usuario usuario=usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		model.addAttribute("listaRutinasPersonales",tablas.findByUsuario(usuario)); //MODIFICO REPOSITORY PARA SACAR TODOS LOS NOMBRES DE ENT.
		return "rutinasPersonalizadas";
	}
	
	@RequestMapping("/favorito")
	public String favorito(Model model,@RequestParam long anadirFavoritos, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		TablaRutina rutina = tablas.getById(anadirFavoritos);
		Usuario usuario=usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		usuario.ponerRutinaFavorita(rutina);
		usuarios.save(usuario);
		model.addAttribute("listaRutinasPersonales",tablas.findByUsuario(usuario)); //MODIFICO REPOSITORY PARA SACAR TODOS LOS NOMBRES DE ENT.
		return "rutinasPersonalizadas";
	}
	
	@RequestMapping("/quitarFavorito")
	public String quitarFavorito(Model model,@RequestParam long quitFavoritos, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		TablaRutina rutina = tablas.getById(quitFavoritos);
		Usuario usuario=usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		usuario.quitarRutinaFavorita(rutina);
		usuarios.save(usuario);
		model.addAttribute("listaRutinasPersonales",tablas.findByUsuario(usuario)); //MODIFICO REPOSITORY PARA SACAR TODOS LOS NOMBRES DE ENT.
		return "rutinasPersonalizadas";
	}

}
