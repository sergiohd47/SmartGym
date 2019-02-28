package com.DAD.SmartGym.Controller;

import org.springframework.ui.Model;

import com.DAD.SmartGym.Repository.ClaseRepository;
import com.DAD.SmartGym.Repository.HorarioRepository;

public class HorarioController {

	public void tablaHorario(Model model) {
		
		model.addAttribute("Lunes9Clase","Entrenamiento funcional");
	}
	
}
