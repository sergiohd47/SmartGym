package com.DAD.SmartGym.Model;

import javax.persistence.*;

@Entity
@Table(name = "horario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private int hora;
	@Column
	private String dia;
	@Column
	private int sala;
	@Column
	private int plazas;
	

	public Horario(int hora, String dia, int sala, int plazas) {
		this.hora = hora;
		this.dia = dia;
		this.sala = sala;
		this.plazas = plazas;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public int numDia() {
		int diaSemana;
		switch (this.dia) {
			case "Lunes":		diaSemana = 1;
								break;
			case "Martes":		diaSemana = 2;
								break;
			case "Miércoles":	diaSemana = 3;
								break;
			case "Jueves":		diaSemana = 4;
								break;
			case "Viernes":		diaSemana = 5;
								break;
			default:			diaSemana = 6;
		}
		return diaSemana;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}
	
	public void reservarPlaza() {
		this.plazas--;
	}
	
	public void cancelarReserva() {
		this.plazas++;
	}
	
	public int getPlazas() {
		return this.plazas;
	}
	
	public void resetPlazas(int plazas) {
		this.plazas = plazas;
	}
	
}
