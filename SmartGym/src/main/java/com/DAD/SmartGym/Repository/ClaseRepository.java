package com.DAD.SmartGym.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DAD.SmartGym.Model.Clase;


public interface ClaseRepository extends JpaRepository<Clase, Long>{
	List<Clase> findByNombre(String nombre);
}
