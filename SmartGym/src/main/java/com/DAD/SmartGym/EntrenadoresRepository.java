package com.DAD.SmartGym;

import java.util.List;

public interface EntrenadoresRepository {
	List<Entrenador> findByNombre(String nombre);
	List<Entrenador> findByApellidos(String apellidos);
	List<Entrenador> findByMail(String mail);
}
