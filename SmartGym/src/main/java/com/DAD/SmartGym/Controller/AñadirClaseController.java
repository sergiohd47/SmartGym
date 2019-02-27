package com.DAD.SmartGym.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class AñadirClaseController {
	@RequestMapping("/añadirClase")
	public String añadirClase(Model model) {
		return "añadirClase";
	}
}
