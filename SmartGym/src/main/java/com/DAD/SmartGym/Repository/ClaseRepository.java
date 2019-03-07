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
	
	@Query(value="select nombre from clase", nativeQuery=true)
	List<String> findAllNombre();
	
	@Query(value="select clase_id from clase_horarios where clase_horarios.horarios_id=?1", nativeQuery=true)
	int getClaseByHorario(long horario);
	
	/*@Query(value = "select clase.nombre from clase, clase_horarios, horario  where clase_horarios.clase_id=clase.id and horario.id=clase_horarios.horarios_id and horario.dia= ?1 and horario.hora= ?2")
	String findNombreByDiaAndHora(String dia, int hora);*/
	
	@Query("select c from Clase c where c.nombre = ?1")
	Clase getClaseByNombre(String nombre);
	
	@Query(value = "select id from clase where clase.nombre = ?1", nativeQuery = true)
	int getIdByNombre(String nombre);
	/*
	@Query(value = "select descripcion from clase where clase.nombre = ?1", nativeQuery = true)
	String getDescripcionByNombre(String nombre);
	
	@Query(value = "select duracion from clase where clase.nombre = ?1", nativeQuery = true)
	int getDuracionByNombre(String nombre);
	
	@Query(value = "select intensidad_cardio from clase where clase.nombre = ?1", nativeQuery = true)
	int getCardioByNombre(String nombre);
	
	@Query(value = "select intensidad_fuerza from clase where clase.nombre = ?1", nativeQuery = true)
	int getFuerzaByNombre(String nombre);
	
	@Query(value = "select max_plazas from clase where clase.nombre = ?1", nativeQuery = true)
	int getPlazasByNombre(String nombre);
	
	@Query(value = "select monitor from clase where clase.nombre = ?1", nativeQuery = true)
	int getMonitorByNombre(String nombre);*/
	
	
	
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
	
	Clase getById(long id);
	
	
}
