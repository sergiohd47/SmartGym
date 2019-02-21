package com.DAD.SmartGym.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DAD.SmartGym.Model.Entrenador;

public interface EntrenadoresRepository extends JpaRepository<Entrenador ,Long>{
	
	List<Entrenador> findByNombre(String nombre);
	
	List<Entrenador> findByMail(String mail);
	
	@Modifying @Transactional
	@Query("update Entrenador e set e.apellidos = ?1 where e.nombre = ?2")
	void setApellidosByNombre( String apellidos, String nombre);
	
	@Modifying @Transactional
	@Query("update Entrenador e set e.genero = ?1 where e.nombre = ?2")
	void setGeneroByNombre( char genero, String nombre);
	
	@Modifying @Transactional
	@Query("update Entrenador e set e.contrasena = ?1 where e.mail = ?2")
	void setContrasenaByMail( char[] contrasena , String mail);
	
	Entrenador getByNombre(String nombre);
	
	Entrenador getByMail(String mail);
	
}
