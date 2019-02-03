package com.DAD.SmartGym;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario,Long>{
	List<Usuario> findByNombre(String nombre);
	List<Usuario> findByApellidos(String apellidos);
	List<Usuario> findByMail(String mail);
	//List<Usuario> findByGenero(char genero);
}
