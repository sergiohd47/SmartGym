package com.DAD.SmartGym;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.DAD.SmartGym.Model.*;
import com.DAD.SmartGym.Repository.*;
import javax.annotation.PostConstruct;

@Controller
public class DataBaseUsage {
	
	@Autowired
	private UsuariosRepository userRepo;
	
	@Autowired
	private EntrenadoresRepository trainerRepo;
	
	@Autowired
	private ClaseRepository classRepo;
	
	@Autowired
	private TablaRutinaRepository rutinaRepo;
	
	@PostConstruct
	public void init(){
		/*
		Usuario user1 = new Usuario("Danny","Molina","Raider","danyel@mail.com",'m',"password");
		Usuario user2 = new Usuario("Victory","Saint","Hatebreeder","markku@mail.com",'f',"rock");
		Usuario user3 = new Usuario("Mariete", "Barriga","NonRiddel","riddle@mail.com",'m',"wow");
		Usuario user4 = new Usuario("Juani", "Cano","ggcg13","cernus@mail.com",'f',"cenutria");
		
		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);
		userRepo.save(user4);
		
		//List<Usuario> usuarios = userRepo.findAll();
		
		Entrenador trainer1 = new Entrenador("Sergio","Hernandez","SergioEntrenador","sergym@mail.com",'m',"vaper");
		Entrenador trainer2 = new Entrenador("Sergio","Peinado","SergioPeinado","peinadoSer@mail.com",'m',"hiit");
		
		trainerRepo.save(trainer1);
		trainerRepo.save(trainer2);
		
		List<Entrenador> entrenadores = trainerRepo.findAll();
		
		user1.solicitarEntrenador(trainer1);
		user2.solicitarEntrenador(trainer2);
		
		userRepo.save(user1);
		userRepo.save(user2);
		
		//trainerRepo.save(trainer1);
		//trainerRepo.save(trainer2);
		
		Clase clase1 = new Clase("XtremeFit",9,10,15,trainer1,60,"Una clase potente.");
		Clase clase2 = new Clase("Hiit",7,9,20,trainer2,45,"Una clase menos potente.");
		
		clase1.addHorarios(17, "Jueves", 0);
		clase2.addHorarios(11, "Martes", 2);
		
		classRepo.save(clase1);
		classRepo.save(clase2);
		
		trainerRepo.save(trainer1);
		trainerRepo.save(trainer2);
		
		user1.solicitarRutina("Definición");
		trainer1.crearRutina(6);
		rutinaRepo.
		
		userRepo.save(user1);
		trainerRepo.save(trainer1);
				
		//userRepo.setContrasenaByMail("maggy".toCharArray(), "cernus@mail.com");
		
	
		user1.anadirComentario(new Retroalimentacion ("ExtremeFit", true, "Esta muy bien la clase para aquellos que quieran llegar al limite",user1));
		userRepo.save(user1);
		*//*
		Entrenador trainer = new Entrenador("Cristina","Cifuentes","Cifu","cifu@mail.com",'f',"master");
		trainerRepo.save(trainer);
		
		
		Usuario user = new Usuario("Juanma", "Tell","Janmatell","cali@mail.com",'m',"telas");
		userRepo.save(user);
		user.solicitarEntrenador(trainer);
		user.solicitarRutina("Calistenia");
		*/
	}
}
