package com.DAD.SmartGym;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TablaRutina {

	private int idRutina;
	
	private Entrenador entrenador;
	private Usuario usuario;
	
	private Date inicio;
	private DateFormat form = new SimpleDateFormat("dd-MM-yyyy");
	private int duracion;//semanas
	
	private String objetivo;
	
	//private PNG rutina;
	
	public TablaRutina (Entrenador entrenador, Usuario usuario, String objetivo) {
		this.entrenador = entrenador;
		this.usuario = usuario;
		this.objetivo = objetivo;
	}
	
	public TablaRutina iniciarRutina(int id, int duracion) {
		this.idRutina = id;
		this.inicio = new Date();
		return this;
	}
	
	public int getId() {
		return this.idRutina;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public Entrenador getEntrenador() {
		return this.entrenador;
	}
	
	public String nombreUsuario() {
		return this.usuario.getNombre();
	}
	
	public String fechaInicio() {
		return this.form.format(inicio);
	}
	
	public String getObjetivo() {
		return this.objetivo;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
	

	

}
