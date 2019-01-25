package com.DAD.SmartGym;

import java.util.ArrayList;
import java.util.List;

public class EntidadUsuario {

	final int MAXRUTINAS = 3;
	
	private String nombre;
	private String id;
	private char[] contrasena = new char[8];
	private char genero;
	private int edad;
	
	private EntidadEntrenador entrenador;
	
	private int num_rutinas;
	private int num_favoritas;
	
	private List<TablaRutina> rutinas= new ArrayList<TablaRutina>();
	private List<TablaRutina> rutinas_fav = new ArrayList<TablaRutina>();
	
	public EntidadUsuario(String nombre, String id, char genero, int edad,String contrasena) {
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

	public EntidadEntrenador getEntrenador() {
		return entrenador;
	}

	public String solicitarEntrenador(EntidadEntrenador entrenador) {
		if (entrenador.disponible()) {
			entrenador.anadirUsuario(this);
			this.entrenador = entrenador;
			return "" + entrenador.getNombre() + " es ahora tu entrenador.";
		} else {
			return "El entrenador " + entrenador.getNombre() + " no puede admitir más usuarios";
		}
	}
	
	public String cambiarEntrenador(EntidadEntrenador entrenador) { //setEntrenador
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
		
	}
	
	
	
}
