package com.aluralatam.LiterAlura;

import com.aluralatam.LiterAlura.principal.Principal;
import com.aluralatam.LiterAlura.repository.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication  implements CommandLineRunner {

	private final LibroRepository libroRepository;

	public LiterAluraApplication(LibroRepository libroRepository){
		this.libroRepository = libroRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
	Principal principal = new Principal(libroRepository);
	principal.muestraElMenu();
	}
}
