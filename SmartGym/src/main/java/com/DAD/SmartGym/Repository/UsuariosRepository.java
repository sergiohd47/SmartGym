package com.DAD.SmartGym.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DAD.SmartGym.Model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario,Long>{
	List<Usuario> findByNombre(String nombre);

	List<Usuario> findByMail(String mail);

	
	@Modifying @Transactional
	@Query("update Usuario u set u.apellidos = ?1 where u.nombre = ?2")
	void setApellidosByNombre( String apellidos, String nombre);
	
	@Modifying @Transactional
	@Query("update Usuario u set u.genero = ?1 where u.nombre = ?2")
	void setGeneroByNombre( char genero, String nombre);
	
	@Modifying @Transactional
	@Query("update Usuario u set u.contrasena = ?1 where u.mail = ?2")
	void setContrasenaByMail( char[] contrasena , String mail);
	
	Usuario getByNombre(String nombre);
	
	Usuario getByMail(String mail);
}
