package com.DAD.SmartGym;


public class TablaRutina {

	private int idRutina;
	
	private EntidadEntrenador entrenador;
	private EntidadUsuario usuario;
	
	private Fecha inicio;
	private int duracion;//semanas
	
	private String objetivo;
	
	public TablaRutina (int id,EntidadEntrenador entrenador, EntidadUsuario usuario, String objetivo) {
		this.idRutina = id;
		this.entrenador = entrenador;
		this.usuario = usuario;
		this.inicio = inicio;
		this.duracion = duracion;
		this.objetivo = objetivo;
	}
	
	public void iniciarRutina(Fecha inicio, int duracion) {
		this.inicio = inicio;
		this.duracion = duracion;
	}
	
	public int getId() {
		return this.idRutina;
	}
	public EntidadUsuario getUsuario() {
		return this.usuario;
	}
	
	public EntidadEntrenador getEntrenador() {
		return this.entrenador;
	}
	
	public String nombreUsuario() {
		return this.usuario.getNombre();
	}
	
	public String fechaInicio() {
		return this.inicio.toString();
	}
	
	public String getObjetivo() {
		return this.objetivo;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
	

	

}
