package com.DAD.SmartGym.Model;

public class Retroalimentacion {
	private boolean valoracion; //TRUE-> ME GUSTA   FALSE-> NO ME GUSTA
	private String comentario;
	
	public Retroalimentacion(boolean valoracion, String comentario) {
		this.valoracion=valoracion;
		this.comentario=comentario;
	}
	public Retroalimentacion(String comentario) {
		this.comentario=comentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public boolean getValoracion() {
		return valoracion;
	}
	public void setValoracion(boolean valoracion) {
		this.valoracion=valoracion;
	}
}
