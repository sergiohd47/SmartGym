package com.DAD.SmartGym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	@RequestMapping("/")
	public String inicio(Model model) {
		return "index.html";
	}
}
