package com.DAD.SmartGym;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.sql.*;

@Entity
public class Usuario {

	final int MAXRUTINAS = 3;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String apellidos;
	private char genero;
	private char[] contrasena = new char[8];
	
	@ManyToOne
	private Entrenador entrenador;
	
	private int num_rutinas;
	private int num_favoritas;
	
	@OneToMany
	private List<TablaRutina> rutinas= new ArrayList<TablaRutina>(MAXRUTINAS);
	@OneToMany
	private List<TablaRutina> rutinas_fav = new ArrayList<TablaRutina>(MAXRUTINAS);
	
	protected Usuario() {} //Constructor para la base de datos
	
	public Usuario(String nombre, String apellidos, Long id, char genero ,String contrasena) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id = id;
		this.contrasena = contrasena.toCharArray();
		this.genero = genero;
		
	}

	public String getNombre() {
		return nombre + " " + apellidos;
	}

	public Long getId() {
		return id;
	}

	public void cambiarId(Long id) { //setId
		this.id = id;
	}

	public char getGenero() {
		return genero;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public String solicitarEntrenador(Entrenador entrenador) {
		if (entrenador.disponible()) {
			entrenador.anadirUsuario(this);
			this.entrenador = entrenador;
			return "" + entrenador.getNombre() + " es ahora tu entrenador.";
		} else {
			return "El entrenador " + entrenador.getNombre() + " no puede admitir más usuarios";
		}
	}
	
	public String cambiarEntrenador(Entrenador entrenador) { //setEntrenador
		if (entrenador.disponible()) {
			this.entrenador.quitarUsuario(this);
			entrenador.anadirUsuario(this);
			this.entrenador = entrenador;
			return "" + entrenador.getNombre() + " es ahora tu nuevo entrenador.";
		} else {
			return "El entrenador " + entrenador.getNombre() + " no puede admitir más usuarios";
		}
	}
	
	public String quitarEntrenador() {
		this.entrenador.quitarUsuario(this);
		return "" + entrenador.getNombre() + " ya no es tu entrenador.";
	}
	
	public String solicitarRutina(String objetivo) {
		if ((this.num_rutinas < MAXRUTINAS)&&(this.entrenador.casillero())){
			this.num_rutinas++;
			this.entrenador.rutinaCasillero(this,objetivo);
			return "Solicitud realizada con éxito.";
		} else if (this.num_rutinas >= MAXRUTINAS) {
			return "Ya tienes el máximo de rutinas disponibles.";
		} else {
			return "El casillero del entrenador " + this.entrenador.getNombre() + " está completo.";
		}
		
	}
	
	
	public void recibirRutina(TablaRutina rutina) {
		rutinas.add(rutina);
	}
	
	public String darDeBajaRutina(int id) {
			int i = 0;
			for(TablaRutina rutina:rutinas) {
				if (rutina.getId()==id) {
					rutinas.remove(i);
					num_rutinas--;
					return "La rutina ha sido dada de baja con éxito.";
				}
				i++;
			}
			return "No se ha encontrado la rutina.";
	}
	
	public String ponerRutinaFavorita(int id) {
		if (MAXRUTINAS > num_favoritas) {
			if (num_rutinas > 0) {
				for (TablaRutina rutina:rutinas) {
					if (rutina.getId()==id) {
						rutinas_fav.add(rutina);
						num_favoritas++;
						return "Rutina añadida a favoritas.";
					}
				}
				return "No se ha encontrado la rutina";
			} else {
				return "No tienes rutinas disponibles";
			}
		}
		return "Tienes el máximo de rutinas favoritas disponibles.";
	}
	
	public String quitarRutinaFavorita(int id) {
		if (0 <= num_favoritas) {
			int i = 0;
			for (TablaRutina rutina:rutinas_fav) {
				if (rutina.getId()==id) {
					rutinas_fav.remove(i);
					num_favoritas--;
					return "Rutina eliminada de favoritas.";
				}
			}
				return "No se ha encontrado la rutina";
			}
		return "No tienes rutinas favoritas.";
	}
	
	
	
}
