package com.DAD.SmartGym.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DAD.SmartGym.Model.Clase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ClaseRepository extends JpaRepository<Clase, Long>{
	List<Clase> findByNombre(String nombre);
	
	@Modifying @Transactional
	@Query("update Clase c set c.intensidadCardio = ?1 where c.nombre = ?2")
	void setIntensidadCardioByNombre( int intensidadCardio, String nombre);
	
	@Modifying @Transactional
	@Query("update Clase c set c.intensidadFuerza = ?1 where c.nombre = ?2")
	void setIntensidadFuerzaByNombre(int intensidadFuerza, String nombre);
	
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
