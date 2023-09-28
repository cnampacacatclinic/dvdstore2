package com.simplon.dvdstore.dvdstore;

import com.simplon.dvdstore.dvdstore.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(Config.class)
@SpringBootApplication
public class DvdStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdStoreApplication.class);
	}
}
