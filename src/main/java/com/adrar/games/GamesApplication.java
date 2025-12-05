package com.adrar.games;

import com.adrar.games.model.Console;
import com.adrar.games.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamesApplication implements CommandLineRunner {

	private ConsoleRepository consoleRepository;

	public GamesApplication(ConsoleRepository consoleRepository)
	{
		this.consoleRepository = consoleRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Instance d'un objet Console
		Console xbox = new Console();
		xbox.setName("Xbox One");
		xbox.setManufacturer("Microsoft");
		Console playstation = new Console();
		playstation.setName("Playstation 5");
		playstation.setManufacturer("Sony");
		Console nintendoSwitch = new Console();
		nintendoSwitch.setName("Switch 2");
		nintendoSwitch.setManufacturer("Nintendo");

		//Ajout en BDD
		consoleRepository.save(xbox);
		consoleRepository.save(nintendoSwitch);
		consoleRepository.save(playstation);

		System.out.println("Liste des consoles :");
		//Affichage des consoles
		consoleRepository.findAll().forEach(System.out::println);

		try {
			//Affichage d'une console par son ID
			System.out.println(consoleRepository.findById(2).orElseThrow());
			//Affichage d'une console par son Name
			System.out.println(consoleRepository.findByName("Switch").orElseThrow());
		} catch (Exception ex)
		{
			System.out.println("la console n'existe pas");
		}
	}
}
