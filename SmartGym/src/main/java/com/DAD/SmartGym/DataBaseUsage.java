package com.DAD.SmartGym;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.DAD.SmartGym.Model.*;
import com.DAD.SmartGym.Repository.*;


@Controller
public class DataBaseUsage {
	
	@Autowired
	private UsuariosRepository userRepo;
	
	@Autowired
	private EntrenadoresRepository trainerRepo;
	
	@Autowired
	private ClaseRepository classRepo;
	
	public void init() throws Exception{
		
		Usuario user1 = new Usuario("Danny","Molina","danyel@mail.com",'m',"password");
		Usuario user2 = new Usuario("Victory","Saint","markku@mail.com",'f',"rock");
		Usuario user3 = new Usuario("Mariete", "Barriga","riddle@mail.com",'m',"wow");
		Usuario user4 = new Usuario("Juani", "Cano","cernus@mail.com",'f',"cenutria");
		
		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);
		userRepo.save(user4);
		
		List<Usuario> usuarios = userRepo.findAll();
		
		Entrenador trainer1 = new Entrenador("Sergio","Hernandez","sergym@mail.com",'m',"vaper");
		Entrenador trainer2 = new Entrenador("Sergio","Peinado","peinadoSer@mail.com",'m',"hiit");
		
		trainerRepo.save(trainer1);
		trainerRepo.save(trainer2);
		
		List<Entrenador> entrenadores = trainerRepo.findAll();
		
		user1.solicitarEntrenador(trainer1);
		user2.solicitarEntrenador(trainer2);
		
		userRepo.save(user1);
		userRepo.save(user2);
		
		trainerRepo.save(trainer1);
		trainerRepo.save(trainer2);
		
		Clase clase1 = new Clase("XtremeFit",4,5,15,trainer1);
		Clase clase2 = new Clase("Hiit",5,3,20,trainer2);
		
		clase1.addHorarios(17, "Jueves", 0);
		clase2.addHorarios(11, "Martes", 2);
		
		classRepo.save(clase1);
		classRepo.save(clase2);
		
		trainerRepo.save(trainer1);
		trainerRepo.save(trainer2);
		
		user1.solicitarRutina("Definición");
		trainer1.crearRutina(1, 6);
		
		userRepo.save(user1);
		trainerRepo.save(trainer1);
		
		
	}
}
