package com.DAD.SmartGym;


public class TablaRutina {

	private int idRutina;
	
	private Entrenador entrenador;
	private Usuario usuario;
	
	private Fecha inicio;
	private int duracion;//semanas
	
	private String objetivo;
	
	public TablaRutina (int id,Entrenador entrenador, Usuario usuario, String objetivo) {
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
		return this.inicio.toString();
	}
	
	public String getObjetivo() {
		return this.objetivo;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
	

	

}
