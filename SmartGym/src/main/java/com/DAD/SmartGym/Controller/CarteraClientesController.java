package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DAD.SmartGym.Repository.*;

@Controller
public class CarteraClientesController {
	@Autowired
	private ClientesRepository clientes; //REPOSITORIO CON TODOS LOS USUARIOS QUE PIDEN CONTACTAR CON UN ENTRENADOR X
	@RequestMapping("/carteraClientes")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		model.addAttribute("listaClientes",clientes.); // Devuelve el nombre de todos los clientes que quieren estar con ese entrenador
		return "carteraClientes";
	}
}
