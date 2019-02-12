package com.DAD.SmartGym.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.DAD.SmartGym.Model.Usuario;;

public interface UsuariosRepository extends JpaRepository<Usuario,Long>{
	List<Usuario> findByNombre(String nombre);
	List<Usuario> findByApellidos(String apellidos);
	List<Usuario> findByMail(String mail);
	//List<Usuario> findByGenero(char genero);
}
