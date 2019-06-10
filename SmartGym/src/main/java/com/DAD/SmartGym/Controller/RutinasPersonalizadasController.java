package com.DAD.SmartGym.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.DAD.SmartGym.Repository.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.DAD.SmartGym.Controller.*;
import com.DAD.SmartGym.Model.*;

@Controller
public class RutinasPersonalizadasController {
	@Autowired
	private UsuariosRepository usuarios;
	@Autowired
	private TablaRutinaRepository tablas, tablaRutina;
	
	private static final String direccionURL = "http://192.168.1.1:8080/crearPDF/";
	@RequestMapping("/rutinasPersonalizadas")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		
		Usuario usuario=usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		model.addAttribute("listaRutinasPersonales",tablas.findByUsuario(usuario)); //MODIFICO REPOSITORY PARA SACAR TODOS LOS NOMBRES DE ENT.
		return "rutinasPersonalizadas";
	}
	
	@PostMapping("/favorito")
	public String favorito(Model model,@RequestParam long anadirFavoritos, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		TablaRutina rutina = tablas.getById(anadirFavoritos);
		Usuario usuario=usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		usuario.ponerRutinaFavorita(rutina);
		usuarios.save(usuario);
		model.addAttribute("listaRutinasPersonales",tablas.findByUsuario(usuario)); //MODIFICO REPOSITORY PARA SACAR TODOS LOS NOMBRES DE ENT.
		return "rutinasPersonalizadas";
	}
	
	@PostMapping("/quitarFavorito")
	public String quitarFavorito(Model model,@RequestParam long quitFavoritos, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		TablaRutina rutina = tablas.getById(quitFavoritos);
		Usuario usuario=usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		usuario.quitarRutinaFavorita(rutina);
		usuarios.save(usuario);
		model.addAttribute("listaRutinasPersonales",tablas.findByUsuario(usuario)); //MODIFICO REPOSITORY PARA SACAR TODOS LOS NOMBRES DE ENT.
		return "rutinasPersonalizadas";
	}
	
	@GetMapping("/obtenerPDF")
	public void getPdf(@RequestParam long id, HttpServletResponse response) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		try {
			ObjectNode datos = restTemplate.getForObject(direccionURL + id, ObjectNode.class);
			
			//byte[] b = datos.get("file").binaryValue();
			
			TablaRutina rutina = tablaRutina.getById(id);
			String name = "TablaEjercicio" + rutina.getEjercicios().getId();
			File archivo = new File(name);
			FileOutputStream fos = new FileOutputStream(archivo);
			fos.write(datos.binaryValue());
			//ByteArrayOutputStream boas = new ByteArrayOutputStream();
            //boas.write(b);
			//response.getOutputStream();
			response.flushBuffer();
		} catch (Exception e) {
			response.sendRedirect("/error");
		}
	}

}
