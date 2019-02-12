package com.DAD.SmartGym;

import java.util.ArrayList;
import java.util.Random;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class Clase {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String nombre;
	private String descripcion;
	
	private int intensidadCardio;
	private int intensidadFuerza;
	
	private int max_plazas;
	private int duracion;
	private ArrayList<Horario> horarios;
	
	
	@ManyToOne
	private Entrenador monitor;
	private ArrayList<Usuario> plazasReservadas;
	
	
	
	protected Clase(){} //Constructor para la base de datos
	
	public Clase(String nombre,int intensidadCardio,int intensidadFuerza,int plazas, Entrenador monitor) {
		this.nombre = nombre;
		this.intensidadCardio = intensidadCardio;
		this.intensidadFuerza = intensidadFuerza;
		this.max_plazas = plazas;
		this.monitor = monitor;
	}
	
	public String getNombre() {
        return nombre;
    }
    
    public int getIntensidadCardio() {
        return intensidadCardio;
    }
    
    public int getIntensidadFuerza() {
    	return intensidadFuerza;
    }
    

    public Entrenador getMonitor() {
        return monitor;
    }
       
    public void setPlazas(int plazas) {
    	this.max_plazas = plazas;
    }

    public void setMonitor(Entrenador monitor) {
    	this.monitor = monitor;
    }

    public void addHorarios(int hora, String dia, int sala) {
    	Horario horario = new Horario(hora,dia,sala,this.max_plazas);
    	horarios.add(horario);
    }
    
    public void removeHorarios(int indice) {
    	this.horarios.remove(indice);
    }
    /*
    private String escogerHorario(ArrayList<String> horariosLibres) {
    	String hDeseado = "";
    	Random rnd = new Random();
    	int aleatorio = rnd.nextInt(horariosLibres.size()-1);
    	hDeseado+=horariosLibres.get(aleatorio);
    	return hDeseado;
    }*/
    
    public String reservarPlaza(Usuario idUsuario, Horario hora) {
    	String resultado;
    	if(hora.getPlazas()>0) {
    		hora.reservarPlaza();
    		this.plazasReservadas.add(idUsuario);
	    		resultado ="Su plaza ha sido reservada con éxito";
    		} else {
	    		resultado ="Esta clase ha alcanzado el límite de plazas";
    		}
    	return resultado;
    }
    
    public boolean equals(Clase otra) {
        if(otra == this)
            return true;
        if((otra == null) || (otra.getClass() != this.getClass()))
            return false;
        return this.nombre.equalsIgnoreCase(otra.nombre);
    }

    public int compareTo(Clase otra) {
        int resultado = 0;
        if((this.intensidadCardio < otra.intensidadCardio) || 
        		((this.intensidadCardio == otra.intensidadCardio) && 
        				(this.intensidadFuerza < otra.intensidadFuerza)))
            resultado = -1;
        else if((this.intensidadCardio > otra.intensidadCardio) || 
        		((this.intensidadCardio == otra.intensidadCardio) && 
        				(this.intensidadFuerza > otra.intensidadFuerza)))
            resultado = 1;
        return resultado;
    }
    
    private int getSala(String dia, int hora) {
    	
    	
    	return 1;
    }
    
    /*@Override
    public String toString() {
        return this.nombre + " ( Sala " + + " )";
    }*/
}
