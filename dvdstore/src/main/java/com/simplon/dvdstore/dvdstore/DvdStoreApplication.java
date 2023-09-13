package com.simplon.dvdstore.dvdstore;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DvdStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdStoreApplication.class);
	}

	/*public CommandLineRunner demo(DvdStoreRepository repository) {
		return (args) -> {
			// save a few DVDs
			repository.save(new DvdStoreRepositoryModel("Comedie", "Sans titre"));
		};
	}*/
}
