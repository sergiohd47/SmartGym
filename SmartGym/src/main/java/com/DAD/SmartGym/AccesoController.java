package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccesoController {
	@RequestMapping("/acceso")
	public String acceder(Model model) {
		return "acceso.html";
	}
}
