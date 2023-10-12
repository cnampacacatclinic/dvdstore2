package com.dvdstore.panier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PanierApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanierApplication.class);
	}
}
