package com.DAD.SmartGym.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.DAD.SmartGym.Model.TablaRutina;
import com.DAD.SmartGym.Model.Usuario;
import com.DAD.SmartGym.Model.Entrenador;

public interface TablaRutinaRepository extends JpaRepository<TablaRutina,Long> {
	
	List<TablaRutina> findByUsuario(Usuario usuario);
	
	List<TablaRutina> findByEntrenador(Entrenador entrenador);
	
	@Modifying @Transactional
	@Query("update TablaRutina t set t.duracion = ?1 where t.usuario = ?2")
	void setDuracionByUsuario( int duracion, Usuario usuario );
	
	@Modifying @Transactional
	@Query("update TablaRutina t set t.objetivo = ?1 where t.usuario = ?2")
	void setObjetivoByUsuario( String objetivo, Usuario usuario );
	
	TablaRutina getByUsuario(Usuario usuario);
	
	TablaRutina getByEntrenador(Usuario entrenador);
}
