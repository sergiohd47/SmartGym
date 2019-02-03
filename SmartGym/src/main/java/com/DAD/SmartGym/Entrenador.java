package com.DAD.SmartGym;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Entrenador {
	
	private final int MAXUSUARIOS = 20;
	private final int MAXCLASES = 5;
	private final int MAXRUTINA = 20; //Numero maximo de rutinas pendientes
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String apellidos;
	private char genero;
	private String mail;
	private char[] contrasena = new char[8];
	private int numUsuarios;
	private int numRutinasPendientes;
	private int numClases;
	
	@OneToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>(MAXUSUARIOS);
	@OneToMany
	private List<TablaRutina> pendientes = new ArrayList<TablaRutina>(MAXRUTINA);
	//implementar la lista de tablas como una cola (Queue)
	@OneToMany
	private List<Clase> clases = new ArrayList<Clase>(MAXCLASES);
	
	protected Entrenador() {} //Constructor para la base de datos
	
	
	public String getNombre() {
		return this.nombre + " " + this.apellidos;
	}
	
	public boolean disponible() {
		return MAXUSUARIOS > numUsuarios;
	}
	
	public boolean libre() {
		return MAXCLASES > numClases;
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
	
	public void rutinaCasillero(Usuario usuario, String objetivo) {
		TablaRutina rutina = new TablaRutina(this, usuario, objetivo);
		pendientes.add(rutina);
		numRutinasPendientes++;
	}
	
	public void crearRutina(int id, int duracion) {
		TablaRutina rutina = this.pendientes.get(0);
		rutina.getUsuario().recibirRutina(rutina.iniciarRutina(id, duracion));
		numRutinasPendientes--;
	}
	
}
