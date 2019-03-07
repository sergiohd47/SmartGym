package com.DAD.SmartGym.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DAD.SmartGym.Model.*;
import com.DAD.SmartGym.Repository.*;
@Controller
public class ClasesController {
	@Autowired
	private ClaseRepository clases;
	@Autowired
	private UsuariosRepository usuarios;
	@Autowired
	private HorarioRepository horarios;
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
		/*if(claseSacada.getHoraios()!=null) {
			int i = 1;
			String nombre;
			for(Horario horario: claseSacada.getHoraios()) {
				nombre=get.Dia
				model.addAttribute(nombre,horario.getDia());
				nombre="horaComienzo"+i;
				model.addAttribute(nombre,horario.getHora());
				nombre="salaClase"+i;
				model.addAttribute(nombre,horario.getSala());
				i++;
			}*/
		
		//model.addAttribute("listaDiasClases",claseSacada.getHoraios());
		
		
		
		return "apuntarseClase";
	}
	
	@RequestMapping("/reservarHora")
	public String reservarHora(Model model,@RequestParam long reservarHorario, HttpSession sesion) {
		/*Horario hora = horarios.getById(reservarHorario);
		System.out.println(hora.getDia());
		Usuario user = usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		System.out.println(user.getNombreUsuario());
		Clase clase=clases.getById(clases.getClaseByHorario(reservarHorario));
		System.out.println(clase.getNombre());
		clase.reservarPlaza(user, hora);
		*/
		clases.getById(clases.getClaseByHorario(reservarHorario)).reservarPlaza(usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString()),
				horarios.getById(reservarHorario));
		Usuario user = usuarios.findByNombreUsuario(sesion.getAttribute("nombreUsuarioSesion").toString());
		usuarios.save(user);
		model.addAttribute("nombreUsuario",sesion.getAttribute("nombreUsuarioSesion"));
		model.addAttribute("listaClases",clases.findAllNombre());
		
		return "usuarioBasico";
	}
	
	
}
