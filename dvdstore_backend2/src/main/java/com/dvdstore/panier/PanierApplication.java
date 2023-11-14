package com.dvdstore.panier;

import com.dvdstore.panier.services.PanierService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PanierApplication {

	private final PanierService panierService;

	public PanierApplication(PanierService panierService) {
		this.panierService = panierService;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PanierApplication.class);
		PanierApplication application= context.getBean(PanierApplication.class);
		/*application.panierService.total();
		application.panierService.supppanier();/**/
	}
}
