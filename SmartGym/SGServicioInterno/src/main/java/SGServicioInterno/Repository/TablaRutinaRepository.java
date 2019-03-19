package SGServicioInterno.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import SGServicioInterno.Model.TablaRutina;
import SGServicioInterno.Model.Usuario;
import SGServicioInterno.Model.Entrenador;

public interface TablaRutinaRepository extends JpaRepository<TablaRutina,Long> {
	
	List<TablaRutina> findByUsuario(Usuario usuario);
	
	List<TablaRutina> findByEntrenador(Entrenador entrenador);
	
	@Query(value = "select * from rutina where rutina.id_rutina = ?1", nativeQuery = true)
	TablaRutina getById(long id);
	
	@Query(value = "select rutinas_fav_id_rutina from usuario_rutinas_fav where usuario_rutinas_fav.usuario_id= ?1", nativeQuery = true)
	long[] findFavByUsuario(long usuario);
	
	@Query(value = "select * from rutina inner join usuario_rutinas_fav on rutina.id_rutina=usuario_rutinas_fav.rutinas_fav_id_rutina where usuario_rutinas_fav.usuario_id= ?1", nativeQuery = true)
	List<TablaRutina> findFavoritasByIdUsuario(long usuario);
	
	//@Query(value = "select * from usuario_rutinas_fav where usuario_rutinas_fav.usuario_id = ?1")
	//List<TablaRutina> hayFavoritasByIdUsuario(long usuario);
	
	@Modifying @Transactional
	@Query("update TablaRutina t set t.duracion = ?1 where t.usuario = ?2")
	void setDuracionByUsuario( int duracion, Usuario usuario );
	
	@Modifying @Transactional
	@Query("update TablaRutina t set t.objetivo = ?1 where t.usuario = ?2")
	void setObjetivoByUsuario( String objetivo, Usuario usuario );
	
	TablaRutina getByUsuario(Usuario usuario);
	
	TablaRutina getByEntrenador(Usuario entrenador);
}
