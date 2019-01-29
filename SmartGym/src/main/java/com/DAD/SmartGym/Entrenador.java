package com.DAD.SmartGym;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {
	
	private final int MAXUSUARIOS = 20;
	private final int MAXRUTINA = 20; //Numero maximo de rutinas pendientes
	
	private String nombre;
	private String id;
	private char[] contrasena = new char[8];
	private char genero;
	private int edad;
	
	private int numUsuarios;
	private int numRutinasPendientes;
	
	private List<Usuario> usuarios = new ArrayList<Usuario>(MAXUSUARIOS);
	
	private List<TablaRutina> pendientes = new ArrayList<TablaRutina>(MAXRUTINA);
	
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean disponible() {
		return MAXUSUARIOS > numUsuarios;
	}
	
	public void anadirUsuario(Usuario usuario) {
		numUsuarios++;
		usuarios.add(usuario);
	}
	
	public void quitarUsuario(Usuario usuario) {
		numUsuarios--;
		usuarios.remove(usuario);
	}
	
	public boolean casillero() {
		return MAXRUTINA > numRutinasPendientes;
	}
	
	public void rutinaCasillero(Usuario usuario, String Objetivo) {
		//TablaRutina rutina = new TablaRutina();
	}
}
