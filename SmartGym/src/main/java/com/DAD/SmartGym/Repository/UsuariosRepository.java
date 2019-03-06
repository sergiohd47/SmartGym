package com.DAD.SmartGym.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DAD.SmartGym.Model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario,Long>{
	List<Usuario> findByNombre(String nombre);
	
	@Query(value="select * from usuario where usuario.nombre_usuario = ?1", nativeQuery=true)
	Usuario findByNombreUsuario(String nombreUsuario);

	List<Usuario> findByMail(String mail);
	
	@Query(value = "select contrasena from usuario where usuario.nombre_usuario= ?1", nativeQuery = true)
	String getContrasenaByNombreUsuario(String nombreUsuario);
	
	@Query(value = "select id from usuario where usuario.nombre_usuario= ?1", nativeQuery = true)
	int getIdByNombreUsuario(String nombreUsuario);
	
	@Modifying @Transactional
	@Query("update Usuario u set u.apellidos = ?1 where u.nombre = ?2")
	void setApellidosByNombre( String apellidos, String nombre);
	
	@Modifying @Transactional
	@Query(value = "update usuario set usuario.nombre_usuario = ?1 where usuario.id = ?2", nativeQuery = true)
	void setUsuarioById( String nombreUsuario, int id);
	
	@Modifying @Transactional
	@Query("update Usuario u set u.genero = ?1 where u.nombre = ?2")
	void setGeneroByNombre( char genero, String nombre);
	
	@Modifying @Transactional
	@Query(value ="update usuario set usuario.contrasena = ?1 where usuario.id = ?2", nativeQuery = true)
	void setContrasenaById( String contrasena , int id);
	
	@Modifying @Transactional
	@Query(value ="update usuario set usuario.mail = ?1 where usuario.id = ?2", nativeQuery = true)
	void setMailById( String mail , int id);
	
	Usuario getByNombre(String nombre);
	
	Usuario getByMail(String mail);
}
