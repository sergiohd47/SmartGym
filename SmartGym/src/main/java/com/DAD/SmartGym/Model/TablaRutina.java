package com.DAD.SmartGym.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.DAD.SmartGym.Model.EjerciciosTabla;

@Entity
@Table(name = "rutina")
public class TablaRutina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRutina;
	
	@ManyToOne
	private Entrenador entrenador;
	
	@ManyToOne
	private Usuario usuario;
	
	@Column
	private int duracion;//semanas
	@Column
	private String objetivo;
	

	/*@Column
	private Date inicio;
	private DateFormat form = new SimpleDateFormat("dd-MM-yyyy");*/
	
	@OneToOne(cascade=CascadeType.ALL)
	private EjerciciosTabla ejercicios;
	
	@Column
	private String pdf;
	
	protected TablaRutina() {} // Constructor para la base de datos
	
	public TablaRutina (Entrenador entrenador, Usuario usuario, String objetivo) {
		this.entrenador = entrenador;
		this.usuario = usuario;
		this.objetivo = objetivo;
	}
	
	public TablaRutina iniciarRutina( int duracion) {
		//this.inicio = new Date();
		this.duracion = duracion;
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
		return this.entrenador.getNombreUsuario();
	}
	
	/*public String fechaInicio() {
		return this.form.format(inicio);
	}*/
	
	public String getObjetivo() {
		return this.objetivo;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
	
	public EjerciciosTabla getEjercicios() {
		return this.ejercicios;
	}

	

}
