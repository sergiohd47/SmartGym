package SGServicioInterno.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.*;


@Entity
@Table(name = "clase")
public class Clase {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String nombre;
	@Column
	private String descripcion;
	
	@Column
	private int intensidadCardio;
	@Column
	private int intensidadFuerza;
	@Column
	private int max_plazas;
	@Column
	private int duracion;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Horario> horarios = new ArrayList<Horario>();
	
	@ManyToOne
	private Entrenador monitor;
	
	@ManyToMany(mappedBy="clases_apuntadas")
	private List<Usuario> plazasReservadas = new ArrayList<Usuario>();
	
	
	
	protected Clase(){} //Constructor para la base de datos
	
	public Clase(String nombre,int intensidadCardio,int intensidadFuerza,int plazas, Entrenador monitor,int duracion,String descripcion) {
		this.nombre = nombre;
		this.intensidadCardio = intensidadCardio;
		this.intensidadFuerza = intensidadFuerza;
		this.max_plazas = plazas;
		this.monitor = monitor;
		this.duracion = duracion;
		this.descripcion = descripcion;
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
    
    public List<Horario> getHoraios(){
    	return this.horarios;
    }
       
    public void setPlazas(int plazas) {
    	this.max_plazas = plazas;
    }

    public void setMonitor(Entrenador monitor) {
    	this.monitor = monitor;
    }

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getMax_plazas() {
		return max_plazas;
	}

	public void setMax_plazas(int max_plazas) {
		this.max_plazas = max_plazas;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	/*
    public void addHorarios(int hora, String dia, int sala) {
    	Horario horario = new Horario(hora,dia,sala,this.max_plazas);
    	horarios.add(horario);
    }
    
    public void removeHorarios(int indice) {
    	this.horarios.remove(indice);
    }
    
    public String reservarPlaza(Usuario idUsuario, Horario hora) {
    	String resultado;
    	if(hora.getPlazas()>0) {
    		hora.reservarPlaza();
    		idUsuario.anadirClase(this);
    		this.plazasReservadas.add(idUsuario);
	    		resultado ="Su plaza ha sido reservada con �xito";
    		} else {
	    		resultado ="Esta clase ha alcanzado el l�mite de plazas";
    		}
    	return resultado;
    }
    
    public String cancelarPlaza(Usuario idUsuario, Horario hora) {
    	String resultado;
    	if(this.plazasReservadas.remove(idUsuario)) {
    		hora.cancelarReserva();
    		resultado = "La reserva ha sido cancelada con éxito";
    	} else {
    		resultado = "No tiene reserva";
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
    

    /*Implementar
    private int getSala(String dia, int hora) {
    	
    	
    	return 1;
    }
    
    /*@Override
    public String toString() {
        return this.nombre + " ( Sala " + + " )";
    }*/
}
