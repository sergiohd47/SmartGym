package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClasesController {
	@RequestMapping("/apuntarseClase")
	public String apuntarseClase(Model model) {
		return "apuntarseClase.html";
	}
}
