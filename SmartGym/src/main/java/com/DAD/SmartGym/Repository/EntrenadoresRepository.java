package com.DAD.SmartGym.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DAD.SmartGym.Model.Entrenador;
import com.DAD.SmartGym.Model.Usuario;

public interface EntrenadoresRepository extends JpaRepository<Entrenador ,Long>{
	
	List<Entrenador> findByNombre(String nombre);
	
	Entrenador findByNombreUsuario(String nombreUsuario);
	
	List<Entrenador> findListByNombreUsuario(String nombreUsuario);
	
	List<Entrenador> findByMail(String mail);
	
	@Query(value="select nombre from entrenador", nativeQuery=true)
	List<String> findAllNombre();
	
	@Query(value = "select contrasena from entrenador where entrenador.nombre_usuario= ?1", nativeQuery = true)
	String getContrasenaByNombreUsuario(String nombreUsuario);
	
	@Query(value = "select id from entrenador where entrenador.nombre_usuario= ?1", nativeQuery = true)
	int getIdByNombreUsuario(String nombreUsuario);
	
	@Modifying @Transactional
	@Query("update Entrenador e set e.apellidos = ?1 where e.nombre = ?2")
	void setApellidosByNombre( String apellidos, String nombre);
	
	@Modifying @Transactional
	@Query(value = "update entrenador set entrenador.nombre_usuario = ?1 where entrenador.id = ?2", nativeQuery = true)
	void setUsuarioById( String nombreUsuario , int id);
	
	@Modifying @Transactional
	@Query("update Entrenador e set e.genero = ?1 where e.nombre = ?2")
	void setGeneroByNombre( char genero, String nombre);
	
	@Modifying @Transactional
	@Query(value = "update entrenador set entrenador.contrasena = ?1 where entrenador.id = ?2", nativeQuery = true)
	void setContrasenaById( String contrasena , int id);
	
	@Modifying @Transactional
	@Query(value = "update entrenador set entrenador.mail = ?1 where entrenador.id = ?2", nativeQuery = true)
	void setMailById( String mail , int id);
	
	Entrenador getByNombre(String nombre);
	
	Entrenador getByMail(String mail);
	
}
