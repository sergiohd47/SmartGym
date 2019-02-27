package com.DAD.SmartGym.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClasesController {
	@RequestMapping("/apuntarseClase")
	public String apuntarseClase(Model model) {
		model.addAttribute("nombreUsuario","Sergio_usuarioBasico");
		
		model.addAttribute("descripcionCrossfit","Entrenamiento funcional");
		model.addAttribute("duracionCrossfit","120");
		model.addAttribute("intensidadCardioCrossfit","7");
		model.addAttribute("intensidadFuerzaCrossfit","9");
		model.addAttribute("salaCrossfit","Box");
		model.addAttribute("plazasLibresCrossfit","20");
		
		model.addAttribute("descripcionSpinning","Entrenamiento cardiovascular");
		model.addAttribute("duracionSpinning","120");
		model.addAttribute("intensidadCardioSpinning","9");
		model.addAttribute("intensidadFuerzaSpinning","2");
		model.addAttribute("salaSpinning","1 y 4");
		model.addAttribute("plazasLibresSpinning","40");
		
		model.addAttribute("descripcionZumba","Entrenamiento cardiovascular");
		model.addAttribute("duracionZumba","120");
		model.addAttribute("intensidadCardioZumba","8");
		model.addAttribute("intensidadFuerzaZumba","4");
		model.addAttribute("salaZumba","2 y 3");
		model.addAttribute("plazasLibresZumba","25");
		return "apuntarseClase";
	}
}
