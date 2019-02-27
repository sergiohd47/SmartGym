package com.DAD.SmartGym.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "entrenador")
public class Entrenador {
	
	private final int MAXUSUARIOS = 20;
	private final int MAXCLASES = 5;
	private final int MAXRUTINA = 20; //Numero maximo de rutinas pendientes
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String nombreUsuario;
	@Column
	private char genero;
	@Column
	private String mail;
	@Column
	//private char[] contrasena = new char[8];
	private String contrasena;
	
	/*
	private int numUsuarios;
	private int numRutinasPendientes;
	private int numClases;
	*/
	
	@OneToMany(mappedBy="entrenador")
	private List<Usuario> usuarios = new ArrayList<Usuario>(MAXUSUARIOS);
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<TablaRutina> pendientes = new ArrayList<TablaRutina>(MAXRUTINA);
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Clase> clases = new ArrayList<Clase>(MAXCLASES);
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Retroalimentacion> comentarios = new ArrayList<Retroalimentacion>();
	
	protected Entrenador() {} //Constructor para la base de datos
	
	public Entrenador(String nombre, String apellidos,String nombreUsuario, String mail, char genero ,String contrasena) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.mail = mail;
		this.genero = genero;
		this.contrasena = contrasena;
	}
	
	public String getNombre() {
		return this.nombre + " " + this.apellidos;
	}
	
	public boolean disponible() {
		return MAXUSUARIOS > usuarios.size();
	}
	
	public boolean libre() {
		return MAXCLASES > clases.size();
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void anadirUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void quitarUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}
	
	public boolean casillero() {
		return MAXRUTINA > pendientes.size();
	}
	
	public void rutinaCasillero(Usuario usuario, String objetivo) {
		TablaRutina rutina = new TablaRutina(this, usuario, objetivo);
		pendientes.add(rutina);
	}
	
	public void crearRutina(int duracion) {
		TablaRutina rutina = this.pendientes.get(0);
		rutina.getUsuario().recibirRutina(rutina.iniciarRutina(duracion));
	}
	
	public void añadirComentario(Retroalimentacion comentario) {
		comentarios.add(comentario);
	} 
	
	public Retroalimentacion getComentarios(int indice) {
		return this.comentarios.get(indice);
	}
	
}
