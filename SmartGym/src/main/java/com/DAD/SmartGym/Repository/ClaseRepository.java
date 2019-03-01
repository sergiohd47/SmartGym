package com.DAD.SmartGym.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.DAD.SmartGym.Model.Clase;

public interface ClaseRepository extends JpaRepository<Clase, Long>{
	List<Clase> findByNombre(String nombre);
	
	/*@Query(value = "select clase.nombre from clase inner join clase_horarios on clase_horarios.clase_id=clase.id inner join horario on horario.id=clase_horarios.horarios_id where horario.dia= ?1 and horario.hora= ?2")
	Optional<String> findNombreByDiaAndHora(String dia, int hora);*/
	
	@Query(value = "select id from clase where clase.nombre = ?1", nativeQuery = true)
	int getIdByNombre(String nombre);
	
	@Query("select c from Clase c where c.intensidadCardio between :intensidadCardio1 and :intensidadCardio2")
	List<Clase> findByRangoCardio( int intensidadCardio1, int intensidadCardio2);
	
	@Query("select c from Clase c where c.intensidadFuerza between :intensidadFuerza1 and :intensidadFuerza2")
	List<Clase> findByRangoFuerza(int intensidadFuerza1, int intensidadFuerza2);
	
	@Modifying @Transactional
	@Query("update Clase c set c.max_plazas = ?1 where c.nombre = ?2")
	void setPlazasByNombre(int max_plazas, String nombre);
	
	@Modifying @Transactional
	@Query("update Clase c set c.duracion = ?1 where c.nombre = ?2")
	void setDuracionByNombre(int duracion, String nombre);
	
	@Modifying @Transactional
	@Query("update Clase c set c.descripcion = ?1 where c.nombre = ?2")
	void setDescripcionByNombre(String descripcion, String nombre);
	
	Clase getByNombre(String nombre);
	
	
}
