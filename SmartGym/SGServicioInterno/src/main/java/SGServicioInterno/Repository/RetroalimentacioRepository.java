package SGServicioInterno.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import SGServicioInterno.Model.Usuario;
import SGServicioInterno.Model.Entrenador;
import SGServicioInterno.Model.Retroalimentacion;

public interface RetroalimentacioRepository extends JpaRepository<Retroalimentacion, Long>{
	
	List<Retroalimentacion> findByTema(String tema);
	
	List<Retroalimentacion> findByUsuario(Usuario usuario);
	
	List<Retroalimentacion> findByEntrenador(Entrenador entrenador);
	
	List<Retroalimentacion> findByValoracion(boolean valoracion);
	
	@Modifying @Transactional
	@Query("update Retroalimentacion r set r.comentario = ?1 where r.tema = ?2")
	void setComentarioByTema( String comentario, String tema );
	
	Retroalimentacion getByTema(String tema);
	
	Retroalimentacion getByUsuario(Usuario usuario);
	
	Retroalimentacion getByEntrenador(Entrenador entrenador);
	
	Retroalimentacion getByValoracion(boolean valoracion);
}
