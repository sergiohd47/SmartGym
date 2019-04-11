package com.DAD.SmartGym.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class NuevaRutinaController {
	
	private static final String direccionURL = "http://192.168.1.1:8080/crearPDF/";
	@RequestMapping("/nuevaRutina")
	public String nuevaRutina(Model model) {
		return "nuevaRutina";	
	}
	
	@PostMapping("/nuevaRutinaFormulario")
	public String nuevaRutinaFormulario(Model model, @RequestParam String nombreEjercicio1,@RequestParam int seriesEjercicio1,
			@RequestParam int repeticionesEjercicio1, @RequestParam String intensidadEjercicio1, @RequestParam int descansoEjercicio1,
			@RequestParam String nombreEjercicio2,@RequestParam int seriesEjercicio2,
			@RequestParam int repeticionesEjercicio2, @RequestParam String intensidadEjercicio2, @RequestParam int descansoEjercicio2,
			@RequestParam String nombreEjercicio3,@RequestParam int seriesEjercicio3,
			@RequestParam int repeticionesEjercicio3, @RequestParam String intensidadEjercicio3, @RequestParam int descansoEjercicio3,
			@RequestParam String nombreEjercicio4,@RequestParam int seriesEjercicio4,
			@RequestParam int repeticionesEjercicio4, @RequestParam String intensidadEjercicio4, @RequestParam int descansoEjercicio4) {
		
		return "carteraClientes";
	}
	
	@GetMapping("pdf")
	public void getPdf(@RequestParam long id, HttpServletResponse response) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		try {
			ObjectNode data = restTemplate.getForObject(direccionURL + id, ObjectNode.class);
			
			response.flushBuffer();
		} catch (Exception e) {
			response.sendRedirect("/error");
		}
	}
	

	
}
