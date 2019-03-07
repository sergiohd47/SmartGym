package com.DAD.SmartGym.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DAD.SmartGym.Model.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

	//List<> findBy ();
	List<Horario> findByDia (String dia);
	
	List<Horario> findBySala (int sala);
	
	@Modifying @Transactional
	@Query("update Horario h set h.hora = ?1 where h.dia = ?2")
	void setHoraByDia(int hora, String dia);
	
	@Modifying @Transactional
	@Query("update Horario h set h.plazas = ?1 where h.sala = ?2")
	void setPlazasBySala(int plazas, int sala);
	
	Horario getByDia(String dia);
	
	Horario getBySala(int sala);
	
	Horario getById(long id);
}
