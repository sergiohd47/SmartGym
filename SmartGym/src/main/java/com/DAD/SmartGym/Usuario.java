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
	private String id;
	private char[] contrasena = new char[8];
	
	private String nombre;
	private char genero;
	private int edad;
	
	@ManyToOne
	private Entrenador entrenador;
	
	private int num_rutinas;
	private int num_favoritas;
	
	@OneToMany
	private List<TablaRutina> rutinas= new ArrayList<TablaRutina>();
	@OneToMany
	private List<TablaRutina> rutinas_fav = new ArrayList<TablaRutina>();
	
	protected Usuario() {} //Constructor para la base de datos
	
	public Usuario(String nombre, String id, char genero, int edad,String contrasena) {
		this.nombre = nombre;
		this.id = id;
		this.contrasena = contrasena.toCharArray();
		this.edad = edad;
		this.genero = genero;
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getId() {
		return id;
	}

	public void cambiarId(String id) { //setId
		this.id = id;
	}

	public char getGenero() {
		return genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
	
	public void solicitarRutina(String objetivo) {
		if ((this.num_rutinas < MAXRUTINAS)&&(this.entrenador.casillero())){
			this.num_rutinas++;
			this.entrenador.rutinaCasillero(this,objetivo);
		}
		
	}
	
	
	public void recibirRutina(TablaRutina rutina) {
		rutinas.add(rutina);
	}
	
	public void darDeBajaRutina(int id) {
		
	}
	
	
	
}
