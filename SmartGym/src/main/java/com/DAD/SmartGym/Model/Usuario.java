package com.DAD.SmartGym.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import java.sql.*;

@Entity
@Table(name = "usuario")
public class Usuario {

	final int MAXRUTINAS = 6;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private char genero;
	@Column
	private String mail;
	@Column
	private char[] contrasena = new char[8];
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Entrenador entrenador;
	
	/*
	private int num_rutinas;
	private int num_favoritas;
	*/
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<TablaRutina> rutinas /*= new ArrayList<TablaRutina>(MAXRUTINAS)*/;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<TablaRutina> rutinas_fav /*= new ArrayList<TablaRutina>(MAXRUTINAS)*/;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Clase> clases_apuntadas /*= new ArrayList<Clase>()*/;
	
	
	
	protected Usuario() {} //Constructor para la base de datos
	
	public Usuario(String nombre, String apellidos, String mail, char genero ,String contrasena) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.mail = mail;
		this.contrasena = contrasena.toCharArray();
		this.genero = genero;
		
	}

	public String getNombre() {
		return nombre + " " + apellidos;
	}

	public Long getId() {
		return id;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void cambiarMail(String mail) { //SetMail
		this.mail = mail;
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
		if ((this.rutinas.size() < MAXRUTINAS)&&(this.entrenador.casillero())){
			this.entrenador.rutinaCasillero(this,objetivo);
			return "Solicitud realizada con éxito.";
		} else if (this.rutinas.size() >= MAXRUTINAS) {
			return "Ya tienes el máximo de rutinas disponibles.";
		} else {
			return "El casillero del entrenador " + this.entrenador.getNombre() + " está completo.";
		}
		
	}
	
	
	public void recibirRutina(TablaRutina rutina) {
		rutinas.add(rutina);
	}
	
	public String darDeBajaRutina(TablaRutina rutina) {
	
			if(rutinas.remove(rutina)) {
				return "La rutina ha sido dada de baja con éxito.";
			}else {
				return "No se ha encontrado la rutina.";
			}
			
	}
	
	public String ponerRutinaFavorita(TablaRutina rutina) {
		if (MAXRUTINAS > rutinas_fav.size()) {
			if (rutinas.size() > 0) {
				rutinas_fav.add(rutina);
				return "Rutina añadida a favoritas.";
			} else {
				return "No tienes rutinas disponibles";
			}
		}
		return "Tienes el máximo de rutinas favoritas disponibles.";
	}
	
	public String quitarRutinaFavorita(TablaRutina rutina) {
		if (0 <= rutinas_fav.size()) {
			if (rutinas_fav.remove(rutina)) {
				return "Rutina eliminada de favoritas.";
			} else {
				return "No se ha encontrado la rutina";
			}
		} else {
			return "No tienes rutinas favoritas.";
		}
	}
	
	
	
}
