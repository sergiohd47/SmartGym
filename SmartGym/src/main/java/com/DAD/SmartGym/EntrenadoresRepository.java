package com.DAD.SmartGym;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadoresRepository extends JpaRepository<Entrenador ,Long>{
	List<Entrenador> findByNombre(String nombre);
	List<Entrenador> findByApellidos(String apellidos);
	List<Entrenador> findByMail(String mail);
}
