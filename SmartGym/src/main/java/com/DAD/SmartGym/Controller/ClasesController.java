package com.DAD.SmartGym.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Model.Clase;
import com.DAD.SmartGym.Model.Horario;
import com.DAD.SmartGym.Repository.*;
@Controller
public class ClasesController {
	@Autowired
	private ClaseRepository clases;
	/*@Autowired
	private horariosClases; //REPOSITORY QUE RELACIONA UNA CLASE CON LOS DIAS HORA DE COMIENZO Y SALA DE LA CLASE
	*/
	@RequestMapping("/apuntarseClase")
	public String apuntarseClase(Model model,@RequestParam String nombreClase, HttpSession sesion) {
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		Clase claseSacada=clases.getClaseByNombre(nombreClase);
		model.addAttribute("nombreClase",nombreClase);
		model.addAttribute("descripcionClase",claseSacada.getDescripcion());
		model.addAttribute("duracionClase",claseSacada.getDuracion());
		model.addAttribute("intensidadCardioClase",claseSacada.getIntensidadCardio());
		model.addAttribute("intensidadFuerzaClase",claseSacada.getIntensidadFuerza());
		model.addAttribute("plazasClase",claseSacada.getMax_plazas());
		model.addAttribute("monitorClase",claseSacada.getMonitor().getNombre());
		model.addAttribute("listaHorariosClases",claseSacada.getHoraios());
		if(claseSacada.getHoraios()!=null) {
			for(Horario horario: claseSacada.getHoraios()) {
				model.addAttribute("diaClase",horario.getDia());
				model.addAttribute("horaComienzo",horario.getHora());
				model.addAttribute("salaClase",horario.getSala());
			}
		}
		
		return "apuntarseClase";
	}
}
