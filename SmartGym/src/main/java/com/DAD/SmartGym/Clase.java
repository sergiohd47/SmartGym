package com.DAD.SmartGym;

import java.util.ArrayList;
import java.util.Random;

//import javax.persistence.Entity;

//@Entity
public class Clase {

	private static int MAX_PLAZAS;
	private String nombre;
	private int intensidadCardio;
	private int intensidadFuerza;
	private int plazas;
	private String monitor;
	private ArrayList<String> plazasReservadas;
	private ArrayList<String> horarios;
	
	public Clase(){}
	
	public Clase(String nombre,int intensidadCardio,int intensidadFuerza,int plazas,
			String monitor,ArrayList<String> plazasReservadas,ArrayList<String> horarios) {
		this.nombre = nombre;
		this.intensidadCardio = intensidadCardio;
		this.intensidadFuerza = intensidadFuerza;
		this.plazas = plazas;
		this.monitor = monitor;
		this.plazasReservadas = plazasReservadas;
		this.horarios = horarios;
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
    
    public int getPlazas() {
    	return plazas;
    }

    public String getMonitor() {
        return monitor;
    }
    
    public ArrayList<String> getPlazasReservadas() {
    	return plazasReservadas;
    }
    
    public ArrayList<String> getHorarios() {
    	return horarios;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void setIntensidadCardio(int intensidadCardio) {
    	this.intensidadCardio = intensidadCardio;
    }
    
    public void setIntensidadFuerza(int intensidadFuerza) {
    	this.intensidadFuerza = intensidadFuerza;
    }
    
    public void setPlazas(int plazas) {
    	this.plazas = plazas;
    }

    public void setMonitor(String monitor) {
    	this.monitor = monitor;
    }

    public void setPlazasReservadas(ArrayList<String> plazasReservadas) {
    	this.plazasReservadas = plazasReservadas;
    }
    
    public void setHorarios(ArrayList<String> horarios) {
    	this.horarios = horarios;
    }
    
    private int numMaxPlazasClase(String nombreClase) {
    	switch(nombreClase) {
	    	case "Crossfit": MAX_PLAZAS = 20;
	    	break;
	    	case "Spinning": MAX_PLAZAS = 30;
	    	break;
	    	default: MAX_PLAZAS = 40;
    	}
    	return MAX_PLAZAS;
    }
    
    private String escogerHorario(ArrayList<String> horariosLibres) {
    	String hDeseado = "";
    	Random rnd = new Random();
    	int aleatorio = rnd.nextInt(horariosLibres.size()-1);
    	hDeseado+=horariosLibres.get(aleatorio);
    	return hDeseado;
    }
    
    public String reservarPlaza(String idUsuario) {
    	ArrayList<String> horariosLibres = new ArrayList<>();
    	String resultado ="";
    	for(String h : horarios) {
    		if(plazas < numMaxPlazasClase(nombre)) {
    			horariosLibres.add(h);
    			String horarioEscogido = escogerHorario(horariosLibres);
	    		plazasReservadas.add(idUsuario);
	    		plazas++;
	    		resultado+="Su plaza ha sido reservada con éxito a las " + horarioEscogido ;
    		} else
	    		resultado+="Esta clase ha alcanzado el límite de plazas";
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
    
    @Override
    public String toString() {
        return this.nombre + ", cuyo entrenador personal es " + this.monitor;
    }
}
