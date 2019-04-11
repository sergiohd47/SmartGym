package SGServicioInterno.Model;

import javax.persistence.OneToOne;

public class EjerciciosTabla {

	private int numero;
	private String[] ejercicios;
	private int[] series;
	private int[] repeticiones;
	private int[] descanso;
	
	@OneToOne
	private TablaRutina rutina;
	
	public EjerciciosTabla(int numero) {
		this.numero = numero;
		this.ejercicios = new String[numero];
		this.series = new int[numero];
		this.repeticiones = new int[numero];
		this.descanso = new int[numero];
	
	}
	
	public void setEjercicio(int pos, String nombre, int series, int repeticiones, int descanso) {
		this.ejercicios[pos]=nombre;
		this.series[pos]=series;
		this.repeticiones[pos]=repeticiones;
		this.descanso[pos]=descanso;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getEjercicio(int pos){
		return this.ejercicios[pos];
	}
	
	public int getSerie(int pos) {
		return this.series[pos];
	}
	
	public int getRepeticiones(int pos) {
		return this.repeticiones[pos];
	}
	
	public int getDescanso(int pos) {
		return this.descanso[pos];
	}
	

	
}
