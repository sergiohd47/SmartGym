package com.DAD.SmartGym.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AñadirClaseController {
	@RequestMapping("/añadirClase")
	public String añadirClase(Model model) {
		return "añadirClase";
	}
}
