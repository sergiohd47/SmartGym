package SGServicioInterno.Model;

import javax.persistence.*;


@Entity
@Table(name = "retroalimentacion")
public class Retroalimentacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String tema;
	@Column
	private boolean valoracion; //TRUE-> ME GUSTA   FALSE-> NO ME GUSTA
	@Column
	private String comentario;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Entrenador entrenador;
	
	protected Retroalimentacion() {} //Constructor BD
	
	//Comentario Usuario
	public Retroalimentacion(String tema, boolean valoracion, String comentario, Usuario usuario) {
		this.tema=tema;
		this.valoracion=valoracion;
		this.comentario=comentario;
		this.usuario=usuario;
		this.entrenador=null;
	}
	
	//Comentario Entrenador
	public Retroalimentacion(String tema, boolean valoracion, String comentario, Entrenador entrenador) {
		this.tema=tema;
		this.valoracion=valoracion;
		this.comentario=comentario;
		this.usuario=null;
		this.entrenador=entrenador;
	}
	
	
	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
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

	@Override
	public String toString() {
		String valor;
		if (this.valoracion) {
			valor = "+1";
		} else {
			valor = "-1";
		}
		String mensaje;
		if (this.usuario==null) {
			mensaje ="Tema: " + this.tema + ". " + valor +"\n" + this.comentario +"\n Entrenador " + this.entrenador;
		} else {
			mensaje = "Tema: " + this.tema + ". " + valor +"\n" + this.comentario +"\n " + this.usuario;
		}
		return mensaje;
	}
	
	
}
