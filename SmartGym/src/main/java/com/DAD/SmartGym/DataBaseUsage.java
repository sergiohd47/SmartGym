package com.DAD.SmartGym;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DataBaseUsage {
	
	@Autowired
	private UsuariosRepository userRepo;
	
	@Autowired
	private EntrenadoresRepository trainerRepo;
	
	public void run(String... args)throws Exception{
		
		userRepo.save(new Usuario("Danny","Molina","danyel@mail.com",'m',"password"));
		userRepo.save(new Usuario("Victory","Saint","makku@mail.com",'f',"rock"));
		userRepo.save(new Usuario("Mariete", "Barriga","riddle@mail.com",'m',"wow"));
		userRepo.save(new Usuario("Juani", "Cano","cernus@mail.com",'f',"cenutria"));
		
		List<Usuario> usuarios = userRepo.findAll();
		
		trainerRepo.save(new Entrenador("Sergio","Hernandez","sergym@mail.com",'m',"vaper"));
		
		List<Entrenador> entrenadores = trainerRepo.findAll();
	}
}
