package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.DAD.SmartGym.Repository.EntrenadoresRepository;
import com.DAD.SmartGym.Model.Entrenador;
import com.DAD.SmartGym.Model.Usuario;

@Controller
public class CarteraClientesController {
	@Autowired
	private EntrenadoresRepository entrenadores; //REPOSITORIO CON TODOS LOS USUARIOS QUE PIDEN CONTACTAR CON UN ENTRENADOR X
	@RequestMapping("/carteraClientes")
	public String acceder(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		Entrenador trainer = entrenadores.getByNombre(sesion.getAttribute("nombreUsuarioSesion").toString());
		model.addAttribute("listaClientes",trainer.getUsuarios()); // Devuelve el nombre de todos los clientes que quieren estar con ese entrenador -> Devuelve una lista de los usuarios que es entrenador
		if(trainer.getUsuarios()!=null) {
			for(Usuario usuario: trainer.getUsuarios()) {
				model.addAttribute("objetivoRutina",usuario.getObjetivoRutinaPedida());
			}
		}
		return "carteraClientes";
	}
}
