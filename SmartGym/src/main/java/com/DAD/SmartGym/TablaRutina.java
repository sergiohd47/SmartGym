package com.DAD.SmartGym;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TablaRutina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRutina;
	
	@ManyToOne
	private Entrenador entrenador;
	@ManyToOne
	private Usuario usuario;
	
	private Date inicio;
	private DateFormat form = new SimpleDateFormat("dd-MM-yyyy");
	private int duracion;//semanas
	
	private String objetivo;
	
	//private PNG rutina;
	
	protected TablaRutina() {} // Constructor para la base de datos
	
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
	
	public String getNombreUsuario() {
		return this.usuario.getNombre();
	}
	
	public String getNombreEntrenador(){
		return this.entrenador.getNombre();
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
