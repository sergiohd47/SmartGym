package com.DAD.SmartGym;

public class Fecha {
	
	private int anno;
	private int mes;
	private int dia;
	
	public Fecha (int anno, int mes, int dia) {
		this.anno = anno;
		this.mes = mes;
		this.dia = dia;
	}
	
	public void setFecha(int anno, int mes, int dia) {
		this.anno = anno;
		this.mes = mes;
		this.dia = dia;
	}
	
	public int getAnno() {
		return this.anno;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getDia() {
		return this.dia;
	}

	@Override
	public String toString() {
		return ""+ dia + "/"+ mes + "/" + anno +"";
	}
	
	

}
